package io.github.product.domain.entity

import jakarta.persistence.*

@Entity(name = "tb_product")
class Product (

    @Id
    @Column
    var id: Long,
    @Column(nullable = false, length = 50)
    var name: String,

    @Column(length = 255)
    var description: String,

    @Column(nullable = false)
    var valueProduct: Double,

    @Column(nullable = false)
    var amount: Int
)