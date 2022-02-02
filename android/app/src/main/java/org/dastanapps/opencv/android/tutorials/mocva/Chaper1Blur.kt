package org.dastanapps.opencv.android.tutorials.mocva

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.dastanapps.opencv.android.ext.bitmap
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
        bmp?.run {
            Image(
                bitmap = this.asImageBitmap(),
                contentDescription = null,
                modifier = Modifier.size(400.dp)
            )
        } ?: Text("No Image Found", modifier = Modifier.padding(16.dp).fillMaxWidth())
    }
}