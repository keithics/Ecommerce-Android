package com.keithics.eteaap.products

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.keithics.eteaap.cart.CartViewModel

@Composable
fun ProductItem(
    product: Product,
    onNavigateToDetail: (String) -> Unit
) {
    val cartViewModel: CartViewModel = hiltViewModel()
    val toast = Toast.makeText(LocalContext.current, "Cart Added", Toast.LENGTH_SHORT)
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(125.dp), shape = RoundedCornerShape(2.dp),
        elevation = 0.dp
    ) {
        Surface {

            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {

                Image(
                    painter = rememberImagePainter(
                        data = product.image,
                    ),
                    contentDescription = product.name,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.3f)
                        .clickable { onNavigateToDetail(product._id) }
                )


                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp, 4.dp, 4.dp, 8.dp)
                        .fillMaxHeight()
                        .weight(0.7f)

                ) {
                    Text(
                        text = product.name,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        maxLines = 2,
                        text = product.description,
                        style = MaterialTheme.typography.subtitle1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Row(
                        Modifier
                            .padding(4.dp)
                            .fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = product.priceCurrency,
                            style = MaterialTheme.typography.subtitle1,
                            fontWeight = FontWeight.Bold,
                            overflow = TextOverflow.Ellipsis
                        )
                        Button(
                            shape = RoundedCornerShape(1.dp),
                            onClick = {
                                cartViewModel.addToCart(product._id, 1)
                                toast.show()
                            },
                        )
                        {
                            Text(text = "Add to Cart")
                        }
                    }


                }
            }
        }
    }

}
