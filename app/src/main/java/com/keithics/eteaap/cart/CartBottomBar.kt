package com.keithics.eteaap.cart

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.keithics.eteaap.Screens
import com.keithics.eteaap.common.SimpleButton

@Composable
fun CartBottomBar(cart: CartPages, navController: NavController) {
    val cartViewModel: CartViewModel = hiltViewModel()

    Row(
        modifier = Modifier
            .padding(12.dp, 4.dp)
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = "Total", color = Color.White)
            Text(
                text = cart.totalPrice,
                color = Color.White,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
            )

        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            SimpleButton(
                text = "Shop More",
                textColor = Color.White,
                buttonColor = MaterialTheme.colors.secondary
            ) {
                navController.navigate(Screens.HomeScreen.route)
            }
            SimpleButton(text = "Checkout", textColor = Color.White, buttonColor = Color.DarkGray) {
                cartViewModel.onChangeShowCheckout(true)
            }
        }

    }
}