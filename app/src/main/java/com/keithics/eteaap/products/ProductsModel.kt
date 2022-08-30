package com.keithics.eteaap.products

data class Product(
    val _id: String,
    val name: String,
    val description: String,
    val image: String,
    val price: String,
    val priceCurrency: String
)

data class ProductPages(
    val docs: List<Product>,
    val totalDocs: Int,
    val page: Int
)


data class GetProductParam(
    val id: String
)