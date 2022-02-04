package org.dastanapps.opencv.android.ext

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory

/**
 *
 * "Iqbal Ahmed" created on 04/02/2022
 */

const val IMG_THRESHOLD_GRADIENT = "threshold-gradient.png"
const val IMG_THRESHOLD_SUDUKU = "threshold-suduku.png"

fun loadImageAssets(context: Context, fileName: String): Bitmap {
    val inputStream = context.assets.open(fileName)
    val bitmap = BitmapFactory.decodeStream(inputStream)
    inputStream.close()
    return bitmap
}

fun loadGaussianNoiseImage(context: Context): Bitmap {
    return loadImageAssets(context, "gaussian-noise.png")
}

fun loadSaltNPapperImage(context: Context): Bitmap {
    return loadImageAssets(context, "salt-and-pepper.png")
}

fun loadSquirelImage(context: Context): Bitmap {
    return loadImageAssets(context, "squirel.png")
}

fun loadGeeksForGeeksImage(context: Context): Bitmap {
    return loadImageAssets(context, "geeksforgeeks.png")
}

fun loadErosionImage(context: Context): Bitmap {
    return loadImageAssets(context, "erosion.jpg")
}

fun loadDilationImage(context: Context): Bitmap {
    return loadImageAssets(context, "dilation.jpg")
}