package org.dastanapps.opencv.android.tutorials.mocva

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import org.dastanapps.opencv.android.ext.*
import org.dastanapps.opencv.android.navigation.imageUri
import org.dastanapps.opencv.android.ui.MyAppBarBackArrow

/**
 *
 * "Iqbal Ahmed" created on 01/02/2022
 */

@Composable
fun Chapter1Blur(
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
            modifier = Modifier.verticalScroll(state = scrollState).padding(bottom = 16.dp)
        ) {
            BlurRow(bmp ?: loadGaussianNoiseImage(context))
            GaussianBlurRow(bmp ?: loadGaussianNoiseImage(context))
            MedianBlurRow(bmp ?: loadSaltNPapperImage(context))
            EmbossImageRow(bmp ?: loadGeeksForGeeksImage(context))
            SharpenImageRow(bmp ?: loadSquirelImage(context))
            UnSharpenImageRow(bmp ?: loadSquirelImage(context))
            RidgeDetect1ImageRow(bmp ?: loadSquirelImage(context))
            RidgeDetect2ImageRow(bmp ?: loadSquirelImage(context))
        }
    }
}

@Composable
fun EmbossImageRow(bitmap: Bitmap, imageSize: Dp = 150.dp) {
    HeaderRow(right = "Emboss (Custom Kernel)")
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            bitmap = bitmap.asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
        Image(
            bitmap = bitmap.emboss().asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
    }
}

@Composable
fun RidgeDetect2ImageRow(bitmap: Bitmap, imageSize: Dp = 150.dp) {
    HeaderRow(right = "Ridge Detection 2 (Custom Kernel)")
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            bitmap = bitmap.asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
        Image(
            bitmap = bitmap.ridgeDetection2().asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
    }
}

@Composable
fun RidgeDetect1ImageRow(bitmap: Bitmap, imageSize: Dp = 150.dp) {
    HeaderRow(right = "Ridge Detection 1 (Custom Kernel)")
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            bitmap = bitmap.asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
        Image(
            bitmap = bitmap.ridgeDetection1().asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
    }
}

@Composable
fun UnSharpenImageRow(bitmap: Bitmap, imageSize: Dp = 150.dp) {
    HeaderRow(right = "UnSharpen Image(Custom Kernel)")
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            bitmap = bitmap.asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
        Image(
            bitmap = bitmap.gaussianBlur(5.0).unSharpeMask().asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
    }
}

@Composable
fun SharpenImageRow(bitmap: Bitmap, imageSize: Dp = 150.dp) {
    HeaderRow(right = "Sharpen Image(Custom Kernel)")
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            bitmap = bitmap.asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
        Image(
            bitmap = bitmap.sharpenImage().asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
    }
}

@Composable
fun MedianBlurRow(bitmap: Bitmap, imageSize: Dp = 150.dp) {
    HeaderRow(right = "Median Blur Image")
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            bitmap = bitmap.asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
        Image(
            bitmap = bitmap.medianBlur().asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
    }
}

@Composable
fun GaussianBlurRow(bitmap: Bitmap, imageSize: Dp = 150.dp) {
    HeaderRow(right = "Gaussian Blur Image")
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            bitmap = bitmap.asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
        Image(
            bitmap = bitmap.gaussianBlur().asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
    }
}

@Composable
fun BlurRow(bitmap: Bitmap, imageSize: Dp = 150.dp) {
    HeaderRow(right = "Blur Image")
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            bitmap = bitmap.asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
        Image(
            bitmap = bitmap.blur().asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
    }
}

@Composable
fun HeaderRow(left: String = "Original Image", right: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            left,
            modifier = Modifier.padding(4.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Text(
            right,
            modifier = Modifier.padding(8.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}