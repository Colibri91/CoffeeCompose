package com.dolar.mycoffee.ui.screen.productlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.dolar.mycoffee.common.enum.CoffeeType
import com.dolar.mycoffee.entity.CoffeeResult
import com.dolar.mycoffee.entity.coffeelist.CoffeeListResponse
import com.dolar.mycoffee.entity.coffeelist.CoffeeListResponseItem
import com.dolar.mycoffee.ui.GeneralProgressDialog
import com.dolar.mycoffee.ui.screen.main.BottomNavigationBar
import com.dolar.mycoffee.ui.theme.MyCoffeeTheme
import com.dolar.mycoffee.ui.ui.theme.Coffee
import com.dolar.mycoffee.ui.ui.theme.DarkCoffee
import com.dolar.mycoffee.ui.ui.theme.MilkyCoffee
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.compose.getViewModel

/**
 * Created by R. Mert Dolar on 6.01.2022.
 */

@Composable
fun ProductListScreen(navController: NavController) {
    ProductList(navController = navController)
}

@Composable
private fun ProductList(navController: NavController,productListViewModel: ProductListViewModel = getViewModel()) {
    val coffeeListState by productListViewModel.coffeListLiveData.collectAsState()
    val showProgress by productListViewModel.eventShowOrHideProgress.observeAsState()
    showProgress?.let { GeneralProgressDialog(it) }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(selectedItemRoute = {
                productListViewModel.getCoffeeList(CoffeeType.getValueByType(it))
            })
        }
    ) {
        when(coffeeListState){
            is CoffeeResult.Success->{
                val coffeeList = (coffeeListState as CoffeeResult.Success<CoffeeListResponse?>).data!!.toList()
                CoffeeList(coffeeList = coffeeList, navController = navController)
            }
            is CoffeeResult.Error->{
                //Show a Dialog
            }
        }
    }
}

@Composable
private fun CoffeeList(coffeeList : List<CoffeeListResponseItem?>,navController: NavController){
    LazyColumn(Modifier.background(MilkyCoffee)) {
        items(coffeeList) { coffee ->
            coffee?.let { ProductListItem(coffee = it, navController = navController) }
        }
    }
}

@Composable
private fun ProductListItem(coffee: CoffeeListResponseItem, navController: NavController) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = rememberImagePainter("https://coffee.alexflipnote.dev/random"),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop)

        Spacer(modifier = Modifier.width(8.dp))

        Column(modifier = Modifier.weight(2f)) {
            Text(text = coffee.title, fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold, color = DarkCoffee)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = coffee.ingredients.size.toString() + " ingredients", color = DarkCoffee)
        }

        Spacer(modifier = Modifier.width(8.dp))

        Button(modifier = Modifier
            .padding(6.dp)
            .weight(1f),colors = ButtonDefaults.buttonColors(backgroundColor = Coffee)
            , onClick = { navController.navigate("productdetail/${coffee.title}") }) {
            Text(text = "Detail", color = DarkCoffee)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListScreenPreview() {
    MyCoffeeTheme {
        ProductListScreen(rememberNavController())
    }
}