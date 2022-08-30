package com.keithics.eteaap.products

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.keithics.ecommerce.common.topbar
import com.keithics.eteaap.Screens
import com.keithics.eteaap.cart.CartViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProductView(navController: NavController, productId: String?) {

    val productViewModel: ProductViewModel = hiltViewModel()
    val cartViewModel: CartViewModel = hiltViewModel()
    val product = productViewModel.product
    productViewModel.currentProductId = productId!!
    val toast = Toast.makeText(LocalContext.current, "Cart Added", Toast.LENGTH_SHORT)

    LaunchedEffect(Unit) {
        productViewModel.product()
    }

    Scaffold(
        topBar = {
            topbar(
                navController
            )
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp, 0.dp, 16.dp, 2.dp)
                .verticalScroll(rememberScrollState())

        ) {
            Image(
                painter = rememberImagePainter(
                    data = product.image,
                ),
                contentDescription = product.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clickable {
                        navController.navigate(
                            Screens.DetailScreen.route + "/" + productId
                        )
                    }


            )

            Text(
                text = product.name,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = product.priceCurrency,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Button(
                shape = RoundedCornerShape(1.dp),
                onClick = {
                    cartViewModel.addToCart(product._id, 1)
                    navController.navigate(Screens.CartScreen.route)
                    toast.show()

                },
            )
            {
                Text(text = "Add to Cart")
            }
            Text(
                text = product.description,
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }

}

