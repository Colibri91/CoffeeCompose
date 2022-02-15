package com.dolar.mycoffee.ui.screen.productdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.dolar.mycoffee.R
import com.dolar.mycoffee.entity.coffeelist.Coffee
import com.dolar.mycoffee.entity.coffeelist.CoffeeEntity
import com.dolar.mycoffee.ui.theme.MyCoffeeTheme
import com.dolar.mycoffee.ui.ui.theme.MilkyCoffee
import org.koin.androidx.compose.getViewModel

/**
 * Created by R. Mert Dolar on 6.01.2022.
 */

@Composable
fun ProductDetailScreen(drinkName: String, description: String, ingredients: String,id : String,productDetailViewModel: ProductDetailViewModel = getViewModel()) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MilkyCoffee), horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box() {

            Image(
                painter = rememberImagePainter("https://coffee.alexflipnote.dev/random"),
                contentDescription = "Contact profile picture",
                modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = R.drawable.ic_favorite),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    .size(48.dp)
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .clickable {
                        productDetailViewModel.addCoffeeToFavoriteList(CoffeeEntity(id.toInt(),drinkName,description,ingredients))
                    }, contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = drinkName, fontSize = 44.sp, modifier = Modifier.padding(8.dp, 0.dp))
            Spacer(modifier = Modifier.height(4.dp))
            Text(modifier = Modifier.padding(8.dp, 0.dp), text = "Description : $description")
            Spacer(modifier = Modifier.height(4.dp))
            Text(modifier = Modifier.padding(8.dp, 0.dp), text = "Ingredients : $ingredients")
        }

        Spacer(modifier = Modifier.width(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailScreenPreview() {
    MyCoffeeTheme {
        ProductDetailScreen(drinkName = "Coffee Name", "Description", "Ingredients","")
    }
}