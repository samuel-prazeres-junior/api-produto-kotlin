package io.github.product.api.controller

import io.github.product.api.ProductAPI
import io.github.product.api.controller.dto.Pagination
import io.github.product.api.controller.dto.ProductRequest
import io.github.product.api.controller.dto.ProductResponse
import io.github.product.api.controller.dto.SearchQuery
import io.github.product.service.ProductService
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(val service: ProductService): ProductAPI {

    override fun create(dto: ProductRequest): ProductResponse {
        return ProductResponse(service.create(dto.toModel()))
    }

    override fun list(
        search: String,
        page: Int,
        perPage: Int,
        sort: String,
        direction: String
    ): Pagination<ProductResponse> {
        return service.findAll(SearchQuery(page, perPage, search, sort, direction))
    }

    override fun getById(id: Long): ProductResponse {
        return ProductResponse(service.findById(id))
    }

    override fun updateById(id: Long, dto: ProductRequest): ProductResponse {
        return ProductResponse(service.update(dto.toModel(), id))
    }

    override fun deleteById(id: Long) {
        service.delete(id)
    }
}