package com.keithics.eteaap.cart

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.keithics.eteaap.common.SimpleButton
import com.keithics.eteaap.products.Screens

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CartList(
    navController: NavController
) {
    val cartViewModel: CartViewModel = hiltViewModel();
    val showAlert = remember { mutableStateOf(false) }
    val productId = cartViewModel.currentProductId;

    LaunchedEffect(Unit) {
        cartViewModel.cartList()
    }

    if (showAlert.value) {
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
                        showAlert.value = false
                    })
            },
            dismissButton = {
                SimpleButton(
                    text = "Dismiss",
                    textColor = Color.White,
                    buttonColor = Color.Gray,
                    onClick = { showAlert.value = false })
            },
            onDismissRequest = { showAlert.value = false },
        )
    }
    if (cartViewModel.cartPages.totalDocs == 0) {
        CartEmpty(navController)
    } else {
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            LazyColumn(
                contentPadding = PaddingValues(4.dp),
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)

            ) {
                itemsIndexed(
                    items = cartViewModel.cartPages.docs,
                )
                { _, item ->
                    CartItem(cart = item, onAddToCart = { qty, productId, isAdd, currentQty ->
                        if (!isAdd && currentQty <= 1) {
                            showAlert.value = true
                            cartViewModel.onChangeCurrentProductId(productId)
                        } else {
                            cartViewModel.addToCart(productId, qty)
                        }

                    })

                }
            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
            )
            Row(
                modifier = Modifier
                    .background(MaterialTheme.colors.secondaryVariant)
                    .height(80.dp)
                    .fillMaxWidth()
            ) {
                CartBottomBar(cart = cartViewModel.cartPages)
            }
        }


    }

}

