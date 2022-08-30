package com.keithics.eteaap.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import com.keithics.eteaap.common.SimpleButton

@Composable
fun CartCheckoutAlert() {
    val cartViewModel: CartViewModel = hiltViewModel()
    val isPaying = cartViewModel.isPaying
    val isDonePayment = cartViewModel.isDonePayment

    if (cartViewModel.showCheckout) {
        AlertDialog(
            properties = DialogProperties(),
            title = {},
            text = {
                CreditCard()
            },
            confirmButton = {
                SimpleButton(
                    text = "Pay Now!",
                    textColor = Color.White,
                    buttonColor = Color.Magenta,
                    onClick = {
                        cartViewModel.onChangeShowCheckout(false)
                        cartViewModel.checkout()
                    })
            },
            dismissButton = {
                SimpleButton(
                    text = "Cancel",
                    textColor = Color.White,
                    buttonColor = Color.Gray,
                    onClick = {
                        cartViewModel.onChangeShowCheckout(false)
                    })
            },
            onDismissRequest = {
                cartViewModel.onChangeShowCheckout(false)
            },
        )

    } else if (isPaying) {
        Dialog(
            onDismissRequest = { },
            DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(350.dp)
                    .background(White, shape = RoundedCornerShape(12.dp))
            ) {
                Paying()
            }

        }
    } else if (isDonePayment) {
        Dialog(
            onDismissRequest = { },
            DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(200.dp)
                    .background(White, shape = RoundedCornerShape(12.dp))
            ) {
                PayingDone()
            }

        }
    } else {

    }


}

