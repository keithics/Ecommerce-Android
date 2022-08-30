package com.keithics.eteaap.cart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keithics.eteaap.api.Api
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(private val apiService: Api) : ViewModel() {
    var cartPages: CartPages by mutableStateOf(CartPages(docs = listOf(), page = 0, totalDocs = 0,totalQty=0, total = 0.00 , totalPrice = "$0.00"))
    var errorMessage: String by mutableStateOf("")
    var cartTotal: Int by mutableStateOf(0)
    var currentProductId: String by mutableStateOf("")

    fun cartList() {
        viewModelScope.launch {
            try {
                cartPages = apiService.getCart()
                cartTotal = cartPages.totalQty
            } catch (e: Exception) {
                print(e.message)
                errorMessage = e.message.toString()
            }
        }
    }

    fun onChangeCurrentProductId(newProductId: String){
        currentProductId = newProductId
    }

    fun addToCart(product: String, qty: Int) {
        viewModelScope.launch {
            try {
                val addToCartParams = AddToCartParams(product, qty)
                cartPages = apiService.addToCart(addToCartParams)
                cartTotal = cartPages.totalQty
            } catch (e: Exception) {
                print(e.message)
                errorMessage = e.message.toString()
            }
        }
    }
}