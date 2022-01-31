package com.dolar.mycoffee.ui.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dolar.mycoffee.R
import com.dolar.mycoffee.ui.ui.theme.Coffee

/**
 * Created by R. Mert Dolar on 27.01.2022.
 */

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){
    object Hot : BottomNavItem("Hot", R.drawable.ic_hot_coffee,"hot")
    object Iced: BottomNavItem("Iced",R.drawable.ic_ice_coffee,"iced")
}

@Composable
fun BottomNavigationBar(selectedItemRoute: (String) -> Unit) {
    val items = listOf(
        BottomNavItem.Hot,
        BottomNavItem.Iced
    )
    var selectedItem by remember { mutableStateOf("hot") }

    BottomNavigation(
        backgroundColor = Coffee,
        contentColor = Color.White
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title, modifier = Modifier.size(24.dp)) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = item.screen_route == selectedItem,
                onClick = {
                    selectedItem = item.screen_route
                    selectedItemRoute(item.screen_route)
                }
            )
        }
    }
}

//if you want to navigate from the bottom navigation you can use this function.
/*@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Hot.screen_route) {
        composable(BottomNavItem.Hot.screen_route) {
            HotScreen()
        }
        composable(BottomNavItem.Iced.screen_route) {
            IcedScreen()
        }
    }
}*/

@Composable
fun HotScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Hot",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}

@Composable
fun IcedScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Iced",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar { "Iced" }
}