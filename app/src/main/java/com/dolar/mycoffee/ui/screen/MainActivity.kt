package com.dolar.mycoffee.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dolar.mycoffee.ui.screen.productdetail.ProductDetailScreen
import com.dolar.mycoffee.ui.screen.productlist.ProductListScreen
import com.dolar.mycoffee.ui.screen.splash.SplashScreen
import com.dolar.mycoffee.ui.theme.MyCoffeeTheme
import kotlinx.coroutines.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            GlobalScope.launch(Dispatchers.Main) {
                delay(2000)
                navController.navigate("productlist")
            }

            MyCoffeeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    NavHost(navController = navController, startDestination = "splash") {
                        composable("splash") { SplashScreen() }
                        composable("productlist") { ProductListScreen(navController) }
                        composable("productdetail/{drinkName}/",arguments = listOf(navArgument("drinkName") { type = NavType.StringType })) { backStackEntry ->
                            ProductDetailScreen(backStackEntry.arguments?.getString("drinkName").toString(),navController)
                        }
                    }
                }
            }
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