package com.keithics.eteaap

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.keithics.eteaap.products.ProductList
import com.keithics.eteaap.products.ProductScreens
import com.keithics.eteaap.products.ProductView


@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController,
        startDestination = ProductScreens.HomeScreen.route,
    ) {
        composable(
            route = ProductScreens.HomeScreen.route
        ) {

            ProductList(
                navController,
                onNavigateToDetail = { productId: String ->
                    navController.navigate(ProductScreens.DetailScreen.route + "/" + productId)
                })
        }
        composable(
            route = ProductScreens.DetailScreen.route + "/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) { backStackEntry ->
            ProductView(
                navController,
                productId = backStackEntry.arguments?.getString("productId")
            )

        }

    }
}