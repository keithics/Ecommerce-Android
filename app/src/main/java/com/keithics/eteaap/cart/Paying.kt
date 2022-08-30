package com.keithics.eteaap.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.keithics.eteaap.R

@Composable
fun Paying() {
    Column(
        modifier = Modifier.height(350.dp)
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
        val progress by animateLottieCompositionAsState(composition)
        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever,

            )
    }

}