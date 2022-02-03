package org.dastanapps.opencv.android.tutorials.mocva

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.dastanapps.opencv.android.ext.bitmap
import org.dastanapps.opencv.android.navigation.imageUri
import org.dastanapps.opencv.android.ui.MyAppBarBackArrow
import org.opencv.android.Utils
import org.opencv.core.CvType
import org.opencv.core.Mat
import org.opencv.core.Size
import org.opencv.imgproc.Imgproc

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
        bmp?.run {
            val src = Mat(height, width, CvType.CV_8UC4)
            Utils.bitmapToMat(this, src)
            Imgproc.blur(src, src, Size(3.0, 3.0))
            val processedImg = Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888)
            Utils.matToBitmap(src, processedImg)
            Column(
                modifier = Modifier.verticalScroll(state = scrollState)
            ) {
                Text(
                    "Original Image",
                    modifier = Modifier.padding(4.dp),
                    fontWeight = FontWeight.Bold
                )
                Image(
                    bitmap = this@run.asImageBitmap(),
                    contentDescription = null,
//                    modifier = Modifier.size(400.dp)
                )
                Text("Blur Image", modifier = Modifier.padding(4.dp), fontWeight = FontWeight.Bold)
                Image(
                    bitmap = processedImg.asImageBitmap(),
                    contentDescription = null,
//                    modifier = Modifier.size(400.dp)
                )

            }
        } ?: Text("No Image Found", modifier = Modifier.padding(16.dp).fillMaxWidth())
    }
}