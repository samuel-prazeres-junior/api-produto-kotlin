package io.github.product.domain.repository

import io.github.product.domain.entity.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long>{
    fun findAll(specification: Specification<Product>, page: Pageable): Page<Product>
}