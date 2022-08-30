package com.keithics.ecommerce.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.keithics.eteaap.cart.CartViewModel

@Composable
fun topbar(
    navController: NavController
) {
    val cartViewModel: CartViewModel = hiltViewModel();

    LaunchedEffect(Unit) {
        cartViewModel.cartList();
    }

    TopAppBar(
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(4.dp)
                .fillMaxSize(),
        ) {
            Text(
                text = "Ecommerce Android App",
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
                color = Color.White

            )
            IconButton(
                onClick = { },

                ) {
                BadgedBox(badge = {
                    Badge {
                        Text(
                            cartViewModel.cartPages.totalDocs.toString()
                        )
                    }
                }) {
                    Icon(
                        Icons.Filled.ShoppingCart,
                        contentDescription = "Cart",
                        tint = Color.White
                    )
                }

            }


        }

    }
}

