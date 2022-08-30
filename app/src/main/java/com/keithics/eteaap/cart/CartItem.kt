package com.keithics.eteaap.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.keithics.eteaap.common.CircularButtons
import com.keithics.eteaap.products.Product

@OptIn(ExperimentalTextApi::class)
@Composable
fun CartItem(
    cart: Cart,
    onAddToCart: (qty: Int,productId: String, isAdd: Boolean, currentQty: Int)->Unit
) {
    val product = cart.product
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(95.dp),
        elevation = 2.dp
    ) {
        Surface() {
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
                        .clickable { }
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
                        Row(
                            Modifier
                                .padding(4.dp)
                                .fillMaxHeight(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            CircularButtons(Icons.Filled.Remove, "-", onClick = {
                                onAddToCart(-1,product._id,false, cart.qty)

                            })
                            Text(
                                text=cart.qty.toString(),
                                fontSize = 35.sp,
                                modifier = Modifier.padding(5.dp,0.dp),
                                style = LocalTextStyle.current.merge(
                                    TextStyle(
                                        lineHeight = 1.em,
                                        platformStyle = PlatformTextStyle(
                                            includeFontPadding = false
                                        ),
                                        lineHeightStyle = LineHeightStyle(
                                            alignment = LineHeightStyle.Alignment.Center,
                                            trim = LineHeightStyle.Trim.None
                                        )
                                    )
                                )
                            )
                            CircularButtons(Icons.Filled.Add, "+", onClick = {
                                onAddToCart(1,product._id,true, cart.qty)
                            })

                        }

                    }


                }
            }
        }
    }

}

