package com.keithics.eteaap.cart

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CartList(
    navController: NavController
) {
    val cartViewModel: CartViewModel = hiltViewModel()

    LaunchedEffect(Unit) {
        cartViewModel.cartList()
    }

    CartDeleteAlert()
    CartCheckoutAlert()
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
                            cartViewModel.onChangeShowDeleteCart(true)
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
                    .background(MaterialTheme.colors.primary)
                    .height(80.dp)
                    .fillMaxWidth()
            ) {
                CartBottomBar(cart = cartViewModel.cartPages, navController)
            }
        }


    }

}

