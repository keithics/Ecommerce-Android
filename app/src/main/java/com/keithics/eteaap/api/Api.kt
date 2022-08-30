package com.keithics.eteaap.api

import com.keithics.eteaap.cart.AddToCartParams
import com.keithics.eteaap.cart.Cart
import com.keithics.eteaap.cart.CartPages
import com.keithics.eteaap.cart.CartTotal
import com.keithics.eteaap.products.ProductPages
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {

    @POST("products/page")
    suspend fun getProducts(): ProductPages

    @POST("cart/page")
    suspend fun getCart(): CartPages

    @POST("cart/add")
    suspend fun addToCart(@Body Object: AddToCartParams): CartPages

    @POST("cart/total")
    suspend fun getCartTotal(): CartTotal

}