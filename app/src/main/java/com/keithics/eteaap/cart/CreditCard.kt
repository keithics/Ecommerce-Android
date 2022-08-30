package com.keithics.eteaap.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.steliospapamichail.creditcardmasker.viewtransformations.CardNumberMask
import com.steliospapamichail.creditcardmasker.viewtransformations.ExpirationDateMask

@Composable
fun CreditCard() {
    var number by remember { mutableStateOf("") }
    var expiration: String by remember { mutableStateOf("") }
    Column {
        OutlinedTextField(
            value = number,
            visualTransformation = CardNumberMask("-"),
            onValueChange = {
                if (it.length <= 16) number = it
            }, label = { Text("Card number") }
        )

        OutlinedTextField(
            value = expiration,
            visualTransformation = ExpirationDateMask(),
            onValueChange = {
                if (it.length <= 4) expiration = it
            }, label = { Text("Expiration") }
        )

    }

}