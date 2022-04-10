package org.dastanapps.opencv.android.tutorials.mocva.chapter2

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.dastanapps.opencv.android.ext.*
import org.dastanapps.opencv.android.navigation.imageUri
import org.dastanapps.opencv.android.tutorials.mocva.HeaderRow
import org.dastanapps.opencv.android.tutorials.mocva.ImageOpsRow
import org.dastanapps.opencv.android.ui.MyAppBarBackArrow

/**
 *
 * "Iqbal Ahmed" created on 10/04/2022
 */

@Composable
fun EdgeCornerDetection(
    name: String,
    navHostController: NavHostController
) {
    val context = LocalContext.current
    val bmp = bitmap(context, imageUri)

    MyAppBarBackArrow(
        title = name,
        navgationIcon = {
            navHostController.navigateUp()
        }
    ) {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(state = scrollState)
                .padding(top = 16.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val lennaBmp = bmp ?: loadImageAssets(LocalContext.current, "Lenna.png")
            DifferenceOfGaussianRow(lennaBmp)
            CannyRow(lennaBmp)
            SobelRow(lennaBmp)
            HarrisCornerRow(lennaBmp)
        }
    }
}

@Composable
fun DifferenceOfGaussianRow(lennaBmp: Bitmap) {
    HeaderRow(right = "Difference of Gaussian")
    ImageOpsRow(
        bitmap = lennaBmp,
        imageSize = 150.dp
    ) {
        Image(
            bitmap = lennaBmp.DifferenceOfGaussian().asImageBitmap(),
            contentDescription = "Lenna DoG",
            modifier = Modifier.size(150.dp)
        )
    }
}

@Composable
fun CannyRow(lennaBmp: Bitmap) {
    HeaderRow(right = "Canny")
    ImageOpsRow(
        bitmap = lennaBmp,
        imageSize = 150.dp
    ) {
        Image(
            bitmap = lennaBmp.Canny().asImageBitmap(),
            contentDescription = "Lenna DoG",
            modifier = Modifier.size(150.dp)
        )
    }
}

@Composable
fun SobelRow(lennaBmp: Bitmap) {
    HeaderRow(right = "Sobel")
    ImageOpsRow(
        bitmap = lennaBmp,
        imageSize = 150.dp
    ) {
        Image(
            bitmap = lennaBmp.Soble().asImageBitmap(),
            contentDescription = "Lenna DoG",
            modifier = Modifier.size(150.dp)
        )
    }
}

@Composable
fun HarrisCornerRow(lennaBmp: Bitmap) {
    HeaderRow(right = "Harris Corner")
    ImageOpsRow(
        bitmap = lennaBmp,
        imageSize = 150.dp
    ) {
        Image(
            bitmap = lennaBmp.HarrisCorner().asImageBitmap(),
            contentDescription = "Lenna DoG",
            modifier = Modifier.size(150.dp)
        )
    }
}
