package com.keithics.eteaap.api

import com.keithics.eteaap.cart.CartPages
import com.keithics.eteaap.products.ProductPages
import retrofit2.http.POST

interface Api {

    @POST("products/page")
    suspend fun getProducts(): ProductPages

    @POST("cart/page")
    suspend fun getCart(): CartPages
}