package com.keithics.eteaap.cart

import com.keithics.eteaap.products.Product


data class Cart(
    val _id: String,
    val qty: Int,
    val product: Product
)

data class CartPages(
    val docs: List<Cart>,
    val totalDocs: Int,
    val page: Int,
    val totalQty: Int,
    val total: Double,
    val totalPrice: String
)

data class CartTotal(
    val total: Int
)

data class AddToCartParams(
    val product: String,
    val qty: Int
)

