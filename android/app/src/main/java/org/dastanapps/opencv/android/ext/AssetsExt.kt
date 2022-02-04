package org.dastanapps.opencv.android.ext

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory

/**
 *
 * "Iqbal Ahmed" created on 04/02/2022
 */


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