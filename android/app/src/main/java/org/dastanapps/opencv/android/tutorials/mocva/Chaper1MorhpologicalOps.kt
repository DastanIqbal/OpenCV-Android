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
fun Chaper1MorphologicalOps(
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
            DilationRow(bmp ?: loadDilationImage(context))
            ErosionRow(bmp ?: loadErosionImage(context))
        }
    }
}


@Composable
fun DilationRow(bitmap: Bitmap, imageSize: Dp = 150.dp) {
    HeaderRow(right = "Dilation Image")
    ImageOpsRow(bitmap, imageSize) {
        Image(
            bitmap = bitmap.dilation().asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
    }
}

@Composable
fun ErosionRow(bitmap: Bitmap, imageSize: Dp = 150.dp) {
    HeaderRow(right = "Erosion Image")
    ImageOpsRow(bitmap, imageSize) {
        Image(
            bitmap = bitmap.erosion().asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
    }
}

