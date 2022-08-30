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
    var cartPages: CartPages by mutableStateOf(CartPages(docs = listOf(), page = 0, totalDocs = 0))
    var errorMessage: String by mutableStateOf("")

    fun cartList() {
        viewModelScope.launch {

            try {
                cartPages = apiService.getCart()
            } catch (e: Exception) {
                print(e.message)
                errorMessage = e.message.toString()
            }
        }
    }
}