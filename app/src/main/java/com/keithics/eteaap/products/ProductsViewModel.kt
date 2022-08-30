package com.keithics.eteaap.products

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
class ProductViewModel @Inject constructor(private val apiService: Api) : ViewModel() {
    var productPages: ProductPages by mutableStateOf(
        ProductPages(
            docs = listOf(),
            page = 0,
            totalDocs = 0
        )
    )

    var product: Product by mutableStateOf(
        Product(
            name = "",
            description = "",
            priceCurrency = "",
            price = "",
            _id = "",
            image = ""
        )
    )

    var currentProductId: String by mutableStateOf("")

    var errorMessage: String by mutableStateOf("")

    fun productList() {
        viewModelScope.launch {
            try {
                productPages = apiService.getProducts()
            } catch (e: Exception) {
                print(e.message)
                errorMessage = e.message.toString()
            }
        }
    }

    fun product() {
        viewModelScope.launch {
            try {
                product = apiService.getProduct(currentProductId)
            } catch (e: Exception) {
                print(e.message)
                errorMessage = e.message.toString()
            }
        }
    }
}