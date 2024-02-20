package io.github.product.service

import io.github.product.api.controller.dto.Pagination
import io.github.product.api.controller.dto.ProductResponse
import io.github.product.api.controller.dto.SearchQuery

interface Crud<T, ID> {
    fun findAll(aQuery: SearchQuery): Pagination<ProductResponse>
    fun findById(id: ID): T
    fun create(model: T): T
    fun update(model: T, id: ID): T
    fun delete(id: ID)
}