package com.keithics.eteaap.cart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keithics.eteaap.api.Api
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(private val apiService: Api) : ViewModel() {
    val cartInit =  CartPages(
        docs = listOf(),
        page = 0,
        totalDocs = 0,
        totalQty = 0,
        total = 0.00,
        totalPrice = "$0.00"
    )
    var cartPages: CartPages by mutableStateOf(cartInit)

    var errorMessage: String by mutableStateOf("")
    var cartTotal: Int by mutableStateOf(0)
    var currentProductId: String by mutableStateOf("")
    var showDeleteCart: Boolean by mutableStateOf(false)
    var showCheckout: Boolean by mutableStateOf(false)
    var isPaying: Boolean by mutableStateOf(false)
    var isDonePayment: Boolean by mutableStateOf(false)

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

    fun onChangeCurrentProductId(newProductId: String) {
        currentProductId = newProductId
    }

    fun onChangeShowDeleteCart(show: Boolean) {
        showDeleteCart = show
    }

    fun onChangeisPaying(_isPaying: Boolean) {
        isPaying = _isPaying
    }


    fun checkout() {
        viewModelScope.launch {
            try {
                apiService.checkout()
                showCheckout = false
                isPaying = true
                delay(5000L)
                isPaying = false
                showDone()
                cartPages = cartInit
                cartTotal = 0
            } catch (e: Exception) {
                isPaying = false
                showCheckout = false
            }
        }

    }

    fun showDone() {
        viewModelScope.launch {
            try {
                delay(500L)
                isDonePayment = true
                delay(3000L)
                isDonePayment = false
            } catch (e: Exception) {
                isPaying = false
                showCheckout = false
            }
        }

    }

    fun onChangeShowCheckout(show: Boolean) {
        showCheckout = show
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