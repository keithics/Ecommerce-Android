package com.keithics.eteaap.cart

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.keithics.ecommerce.common.topbar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CartView(navController: NavController) {

    Scaffold(
        topBar = {
            topbar(
                navController
            )
        }
    ) {
        CartList(navController = navController)
    }

}

