package com.keithics.eteaap.products

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.keithics.ecommerce.common.topbar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProductView(navController: NavController, productId: String?) {

    Scaffold(
        topBar = {
            topbar(
                navController
            )
        }
    ) {
        Text("as")
    }

}

