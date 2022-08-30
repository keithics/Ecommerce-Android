package com.keithics.eteaap

sealed class Screens(val route: String) {
    object HomeScreen : Screens("home")
    object DetailScreen : Screens("detail")
    object CartScreen : Screens("cart")
}