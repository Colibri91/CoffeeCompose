package com.dolar.mycoffee.ui.screen.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dolar.mycoffee.common.AppConstant
import com.dolar.mycoffee.ui.screen.productdetail.ProductDetailScreen
import com.dolar.mycoffee.ui.screen.productlist.ProductListScreen
import com.dolar.mycoffee.ui.screen.splash.SplashScreen
import com.dolar.mycoffee.ui.theme.MyCoffeeTheme
import kotlinx.coroutines.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyCoffeeTheme {
                Surface(color = MaterialTheme.colors.background) {
                   MainScreen()
                }
            }
        }
    }
}

@Composable
private fun MainScreen(){
    val navController = rememberNavController()
    LaunchedEffect(Dispatchers.Main){
        delay(2000)
        navController.navigate(AppConstant.PRODUCT_LIST)
    }
    NavHost(navController = navController, startDestination = AppConstant.SPLASH) {
        composable(AppConstant.SPLASH) { SplashScreen() }
        composable(AppConstant.PRODUCT_LIST) { ProductListScreen(navController) }
        composable(AppConstant.PRODUCT_DETAIL_WITH_ARGUMENTS ,arguments = listOf(navArgument("drinkName") { type = NavType.StringType },
            navArgument("description") { type = NavType.StringType },
            navArgument("ingredients") { type = NavType.StringType },
            navArgument("id") { type = NavType.StringType })) { backStackEntry ->
            ProductDetailScreen(backStackEntry.arguments?.getString("drinkName").toString(),
                backStackEntry.arguments?.getString("description").toString(),
                backStackEntry.arguments?.getString("ingredients").toString(),
                backStackEntry.arguments?.getString("id").toString())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyCoffeeTheme {
        ProductListScreen(rememberNavController())
    }
}