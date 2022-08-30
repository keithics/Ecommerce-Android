package com.keithics.eteaap.products

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.keithics.ecommerce.common.topbar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProductList(
    navController: NavController,
    onNavigateToDetail: (String) -> Unit
) {
    val productViewModel: ProductViewModel = hiltViewModel()

    LaunchedEffect(Unit) {
        productViewModel.productList()
    }

    Scaffold(
        topBar = {
            topbar(
                navController
            )
        }
    ) {
        LazyColumn {
            itemsIndexed(
                items = productViewModel.productPages.docs
            )
            { _, item ->
                ProductItem(product = item, onNavigateToDetail)
                Divider(color = Color.LightGray)
            }


        }

    }

}

