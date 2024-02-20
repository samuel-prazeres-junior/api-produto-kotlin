package io.github.product.api.controller.dto

data class SearchQuery(
    val page: Int,
    val perPage: Int,
    val terms: String,
    val sort: String,
    val direction: String
) {
}