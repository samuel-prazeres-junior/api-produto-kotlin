package io.github.product.api.controller.dto

import io.github.product.domain.entity.Product

data class ProductRequest (
    val id:Long,
    val name: String,
    val description: String,
    val valueProduct: Double,
    val amount: Int
) {
    fun toModel(): Product{
        return Product(id, name, description, valueProduct, amount)
    }
}