package com.dolar.mycoffee.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

/**
 * Created by R. Mert Dolar on 7.01.2022.
 */

@Composable
fun GeneralProgressDialog(isVisible : Boolean = true) {
    if (isVisible) {
        Dialog(onDismissRequest = { /*onDismissListener*/ },
            DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Box(
                contentAlignment= Alignment.Center,
                modifier = Modifier
                    .size(100.dp)
                    .background(Transparent, shape = RoundedCornerShape(12.dp))
            ) {
                Column {
                    //CircularProgressIndicator()
                    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(com.dolar.mycoffee.R.raw.splash_anim))
                    LottieAnimation(composition = composition,iterations = LottieConstants.IterateForever,modifier = Modifier
                        .width(100.dp)
                        .height(100.dp))
                }
            }
        }
    }
}