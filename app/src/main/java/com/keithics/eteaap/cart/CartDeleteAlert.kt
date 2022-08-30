package com.keithics.eteaap.cart

import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.keithics.eteaap.common.SimpleButton

@Composable
fun CartDeleteAlert() {
    val cartViewModel: CartViewModel = hiltViewModel()
    val productId = cartViewModel.currentProductId

    if (cartViewModel.showDeleteCart) {
        AlertDialog(
            title = { Text("Delete Item.") },
            text = { Text("Are you sure to delete the item?") },
            confirmButton = {
                SimpleButton(
                    text = "Delete",
                    textColor = Color.White,
                    buttonColor = MaterialTheme.colors.primary,
                    onClick = {
                        cartViewModel.addToCart(productId, -1)
                        cartViewModel.onChangeShowDeleteCart(false)
                    })
            },
            dismissButton = {
                SimpleButton(
                    text = "Dismiss",
                    textColor = Color.White,
                    buttonColor = Color.Gray,
                    onClick = {
                        cartViewModel.onChangeShowDeleteCart(false)
                    })
            },
            onDismissRequest = {
                cartViewModel.onChangeShowDeleteCart(false)
            },
        )
    }

}