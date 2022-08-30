package com.keithics.eteaap.cart

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.keithics.eteaap.common.SimpleButton
import com.keithics.eteaap.products.Screens

@Composable
fun CartEmpty(navController: NavController) {
    Column(
    verticalArrangement = Arrangement.SpaceAround,
    modifier = Modifier
    .padding(4.dp, 4.dp, 4.dp, 8.dp)
    .fillMaxHeight()
    ) {
        Column() {
            Text(text = "No Cart Items", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                SimpleButton(text = "Back to Product List", textColor = Color.White, buttonColor = MaterialTheme.colors.primary, onClick = {
                    navController.navigate(Screens.HomeScreen.route)
                })
            }

        }

    }
}