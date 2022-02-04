package org.dastanapps.opencv.android.ext

import android.graphics.Bitmap
import org.opencv.android.Utils
import org.opencv.core.CvType
import org.opencv.core.Mat
import org.opencv.core.Size
import org.opencv.imgproc.Imgproc

/**
 *
 * "Iqbal Ahmed" created on 04/02/2022
 */


inline fun Bitmap.processMat(block: (Mat) -> Unit): Bitmap {
    val src = Mat(height, width, CvType.CV_8UC4)
    Utils.bitmapToMat(this, src)

    block(src)

    val processedImg = Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888)
    Utils.matToBitmap(src, processedImg)
    return processedImg
}

fun Bitmap.blur(kSize: Double = 9.0): Bitmap {
    return processMat {
        Imgproc.blur(it, it, Size(kSize, kSize))
    }
}


fun Bitmap.gaussianBlur(kSize: Double = 9.0): Bitmap {
    return processMat {
        Imgproc.GaussianBlur(it, it, Size(kSize, kSize), 0.0)
    }
}

fun Bitmap.medianBlur(kSize: Int = 3): Bitmap {
    return processMat {
        Imgproc.medianBlur(it, it, kSize)
    }
}

fun Bitmap.sharpenImage(): Bitmap {
    return processMat {
        val kernel = Mat(3, 3, CvType.CV_16SC1)
        kernel.put(0, 0, 0.0, -1.0, 0.0, -1.0, 5.0, -1.0, 0.0, -1.0, 0.0)

        Imgproc.filter2D(it, it, it.depth(), kernel);
    }
}