package org.dastanapps.opencv.android.ext

import android.graphics.Bitmap
import org.opencv.core.Size
import org.opencv.imgproc.Imgproc

/**
 *
 * "Iqbal Ahmed" created on 04/02/2022
 */


fun Bitmap.erosion(): Bitmap {
    return processMat {
        val kernel = Imgproc.getStructuringElement(Imgproc.MORPH_ELLIPSE, Size(5.0, 5.0))
        Imgproc.erode(it, it, kernel)
    }
}

fun Bitmap.dilation(): Bitmap {
    return processMat {
        val kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, Size(3.0, 3.0))
        Imgproc.dilate(it, it, kernel)
    }
}