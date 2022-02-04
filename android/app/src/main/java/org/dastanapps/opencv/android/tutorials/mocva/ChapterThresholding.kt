package org.dastanapps.opencv.android.tutorials.mocva

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.dastanapps.opencv.android.ext.*
import org.dastanapps.opencv.android.navigation.imageUri
import org.dastanapps.opencv.android.ui.MyAppBarBackArrow

/**
 *
 * "Iqbal Ahmed" created on 04/02/2022
 */

@Composable
fun Chapter1Thresholding(
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
            val bitmap = bmp ?: loadImageAssets(context, IMG_THRESHOLD_GRADIENT)
            val bitmap2 = bmp ?: loadImageAssets(context, IMG_THRESHOLD_SUDUKU)
            BinaryRow(bitmap)
            BinaryInverseRow(bitmap)
            TruncRow(bitmap)
            ToZeroRow(bitmap)
            ToZeroInverseRow(bitmap)
            AdaptiveMeanRow(bitmap2)
            AdaptiveGaussianRow(bitmap2)
        }
    }
}


@Composable
fun BinaryRow(bitmap: Bitmap, imageSize: Dp = 150.dp) {
    HeaderRow(right = "Binary Image")
    ImageOpsRow(bitmap, imageSize) {
        Image(
            bitmap = bitmap.threshBinary().asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
    }
}

@Composable
fun BinaryInverseRow(bitmap: Bitmap, imageSize: Dp = 150.dp) {
    HeaderRow(right = "Binary Inverse Image")
    ImageOpsRow(bitmap, imageSize) {
        Image(
            bitmap = bitmap.threshBinaryInverse().asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
    }
}

@Composable
fun TruncRow(bitmap: Bitmap, imageSize: Dp = 150.dp) {
    HeaderRow(right = "Trunc Image")
    ImageOpsRow(bitmap, imageSize) {
        Image(
            bitmap = bitmap.threshTrunc().asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
    }
}

@Composable
fun ToZeroRow(bitmap: Bitmap, imageSize: Dp = 150.dp) {
    HeaderRow(right = "To Zero Image")
    ImageOpsRow(bitmap, imageSize) {
        Image(
            bitmap = bitmap.threshToZero().asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
    }
}

@Composable
fun ToZeroInverseRow(bitmap: Bitmap, imageSize: Dp = 150.dp) {
    HeaderRow(right = "To Zero Inverse Image")
    ImageOpsRow(bitmap, imageSize) {
        Image(
            bitmap = bitmap.threshToZeroInverse().asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
    }
}

@Composable
fun AdaptiveMeanRow(bitmap: Bitmap, imageSize: Dp = 150.dp) {
    HeaderRow(right = "Adaptive Mean Image")
    ImageOpsRow(bitmap, imageSize) {
        Image(
            bitmap = bitmap.adaptiveMean().asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
    }
}

@Composable
fun AdaptiveGaussianRow(bitmap: Bitmap, imageSize: Dp = 150.dp) {
    HeaderRow(right = "Adaptive Gaussian Image")
    ImageOpsRow(bitmap, imageSize) {
        Image(
            bitmap = bitmap.adaptiveGaussian().asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
    }
}



