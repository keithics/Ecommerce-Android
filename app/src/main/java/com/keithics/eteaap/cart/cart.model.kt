package com.keithics.eteaap.cart

import com.keithics.eteaap.products.Product


data class Cart(
    val _id: String,
    val total: Int,
    val products: Product
)

data class CartPages(
    val docs: List<Cart>,
    val totalDocs: Int,
    val page: Int
)

