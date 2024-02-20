package io.github.product.service.impl

import io.github.product.api.controller.dto.Pagination
import io.github.product.api.controller.dto.ProductResponse
import io.github.product.api.controller.dto.SearchQuery
import io.github.product.domain.entity.Product
import io.github.product.domain.repository.ProductRepository
import io.github.product.service.ProductService
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class ProductServiceImpl(val repository: ProductRepository): ProductService {


    @Transactional
    override fun findAll(aQuery: SearchQuery): Pagination<ProductResponse>{

        val page = PageRequest.of(
            aQuery.page,
            aQuery.perPage,
            Sort.by(Sort.Direction.fromString(aQuery.direction), aQuery.sort)
        )

        val where = Optional.ofNullable(aQuery.terms)
            .filter { str -> !str.isNullOrBlank() }
            .map { terms ->
                Specification<Product> { root, _, criteriaBuilder ->
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%${terms.lowercase()}%")
                }
            }
            .orElse(null)

        val pageResult = repository.findAll(where, page)

        return Pagination(
            pageResult.number,
            pageResult.size,
            pageResult.totalElements,
            pageResult.map { ProductResponse(it) }.toList()
        )

    }

    @Transactional
    override fun findById(id: Long): Product {
        return repository.findById(id).orElseThrow(){NoSuchElementException("Product not found")}
    }

    @Transactional
    override fun create(model: Product): Product {
        return repository.save(model)
    }

    @Transactional
    override fun update(model: Product, id: Long): Product {
        if (!repository.existsById(id)) throw NoSuchElementException("Product not found")
        val dbProduct = findById(id)
        dbProduct.name = model.name
        dbProduct.amount = model.amount
        dbProduct.valueProduct = model.valueProduct
        dbProduct.description = model.description
        return repository.save(dbProduct)
    }

    @Transactional
    override fun delete(id: Long) {
        if (!repository.existsById(id)) throw NoSuchElementException("Product not found")
        val dbProduct = findById(id)
        repository.delete(dbProduct)
    }
}