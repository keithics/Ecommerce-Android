package com.keithics.eteaap

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.keithics.eteaap.cart.CartView
import com.keithics.eteaap.products.ProductList
import com.keithics.eteaap.products.ProductView


@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController,
        startDestination = Screens.HomeScreen.route,
    ) {
        composable(
            route = Screens.HomeScreen.route
        ) {

            ProductList(
                navController,
                onNavigateToDetail = { productId: String ->
                    navController.navigate(Screens.DetailScreen.route + "/" + productId)
                })
        }

        composable(
            route = Screens.DetailScreen.route + "/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) { backStackEntry ->
            ProductView(
                navController,
                productId = backStackEntry.arguments?.getString("productId")
            )

        }

        composable(
            route = Screens.CartScreen.route
        ) { _ ->
            CartView(navController = navController)

        }

    }
}