package io.github.product.api

import io.github.product.api.controller.dto.Pagination
import io.github.product.api.controller.dto.ProductRequest
import io.github.product.api.controller.dto.ProductResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*


@RequestMapping("/api/product")
@Tag(name = "Products")
interface ProductAPI {

    @PostMapping
    @Operation(summary = "Create a new Product")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "201", description = "Created successfully"),
            ApiResponse(responseCode = "422", description = "A validation error was thrown"),
            ApiResponse(responseCode = "500", description = "An internal server error was thrown")
        ]
    )
    fun create(@RequestBody dto: ProductRequest): ProductResponse


    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    @Operation(summary = "List all Product")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Product retrieved"),
        ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
    ])
    fun list(
        @RequestParam(name = "search", required = false, defaultValue = "") search: String,
        @RequestParam(name = "page", required = false, defaultValue = "0") page: Int,
        @RequestParam(name = "perPage", required = false, defaultValue = "10") perPage: Int,
        @RequestParam(name = "sort", required = false, defaultValue = "name") sort: String,
        @RequestParam(name = "dir", required = false, defaultValue = "asc") direction: String
    ): Pagination<ProductResponse>

    @GetMapping(value = ["{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    @Operation(summary = "Get a Product by it's identifier")
    @ApiResponses(
        value = [ApiResponse(
            responseCode = "200",
            description = "Product retrieved"
        ), ApiResponse(
            responseCode = "404",
            description = "Product was not found"
        ), ApiResponse(responseCode = "500", description = "An internal server error was thrown")]
    )
    fun getById(@PathVariable id: Long): ProductResponse

    @PutMapping(
        value = ["{id}"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @Operation(summary = "Update a Product by it's identifier")
    @ApiResponses(
        value = [ApiResponse(
            responseCode = "200",
            description = "Product updated"
        ), ApiResponse(
            responseCode = "404",
            description = "Product was not found"
        ), ApiResponse(
            responseCode = "422",
            description = "A validation error was thrown"
        ), ApiResponse(responseCode = "500", description = "An internal server error was thrown")]
    )
    fun updateById(@PathVariable id: Long, @RequestBody dto: ProductRequest): ProductResponse

    @DeleteMapping(value = ["{id}"])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a Product by it's identifier")
    @ApiResponses(
        value = [ApiResponse(
            responseCode = "204",
            description = "Product deleted"
        ), ApiResponse(
            responseCode = "500",
            description = "An internal server error was thrown"
        )]
    )
    fun deleteById(@PathVariable id: Long)
}