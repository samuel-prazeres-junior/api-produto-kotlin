package io.github.product.api.controller.dto

import io.github.product.domain.entity.Product

data class ProductResponse(
    val id:Long,
    val name: String,
    val description: String,
    val valueProduct: Double,
    val amount: Int
) {
    constructor(entity: Product): this(
        id = entity.id,
        name = entity.name,
        description = entity.description,
        valueProduct = entity.valueProduct,
        amount = entity.amount
    )
}