package com.keithics.eteaap.products

sealed class ProductScreens(val route: String) {
    object HomeScreen : ProductScreens("home_screen")
    object DetailScreen : ProductScreens("detail_screen")
}