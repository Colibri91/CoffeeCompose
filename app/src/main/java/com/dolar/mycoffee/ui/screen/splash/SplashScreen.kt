package com.dolar.mycoffee.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.dolar.mycoffee.R
import com.dolar.mycoffee.ui.theme.MyCoffeeTheme

/**
 * Created by R. Mert Dolar on 6.01.2022.
 */

@Composable
fun SplashScreen() {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Center) {
        Image(
            painter = painterResource(R.drawable.ic_coffee_bean),
            contentDescription = "Contact profile picture",
            modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds
        )

        Column {
            //CircularProgressIndicator()
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.splash_anim))
            LottieAnimation(composition = composition,iterations = LottieConstants.IterateForever,modifier = Modifier
                .width(200.dp)
                .height(200.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SplashScreenPreview() {
    MyCoffeeTheme {
        SplashScreen()
    }
}