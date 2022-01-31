package com.dolar.mycoffee.ui.screen.productdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.dolar.mycoffee.ui.theme.MyCoffeeTheme

/**
 * Created by R. Mert Dolar on 6.01.2022.
 */

@Composable
fun ProductDetailScreen(msg: String, navController: NavController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = rememberImagePainter("https://coffee.alexflipnote.dev/random"),
            contentDescription = "Contact profile picture",
            modifier = Modifier.fillMaxWidth()
                ,contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = msg, fontSize = 44.sp, modifier = Modifier.padding(8.dp,0.dp))
            Spacer(modifier = Modifier.height(4.dp))
            Text(modifier = Modifier.padding(8.dp,0.dp),text = "Lorem Ipsum, dizgi ve baskı endüstrisinde kullanılan mıgır metinlerdir. Lorem Ipsum, adı bilinmeyen bir matbaacının bir hurufat numune kitabı oluşturmak üzere bir yazı galerisini alarak karıştırdığı 1500'lerden beri endüstri standardı sahte metinler olarak kullanılmıştır. Beşyüz yıl boyunca varlığını sürdürmekle kalmamış, aynı zamanda pek değişmeden elektronik dizgiye de sıçramıştır. 1960'larda Lorem Ipsum pasajları da içeren Letraset yapraklarının yayınlanması ile ve yakın zamanda Aldus PageMaker gibi Lorem Ipsum sürümleri içeren masaüstü yayıncılık yazılımları ile popüler olmuştur.")
        }

        Spacer(modifier = Modifier.width(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailScreenPreview() {
    MyCoffeeTheme {
        ProductDetailScreen(msg = "Mert Dolar", rememberNavController())
    }
}