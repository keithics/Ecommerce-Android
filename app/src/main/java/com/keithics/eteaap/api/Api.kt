package com.keithics.eteaap.api

import com.keithics.eteaap.cart.AddToCartParams
import com.keithics.eteaap.cart.CartPages
import com.keithics.eteaap.cart.CartTotal
import com.keithics.eteaap.products.Product
import com.keithics.eteaap.products.ProductPages
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Api {

    @POST("products/page")
    suspend fun getProducts(): ProductPages

    @GET("products/{id}")
    suspend fun getProduct(@Path("id") id: String): Product

    @POST("cart/page")
    suspend fun getCart(): CartPages

    @POST("cart/add")
    suspend fun addToCart(@Body Object: AddToCartParams): CartPages

    @POST("cart/checkout")
    suspend fun checkout()

    @POST("cart/total")
    suspend fun getCartTotal(): CartTotal

}