package org.dastanapps.opencv.android.ext

import android.graphics.Bitmap
import org.opencv.core.CvType
import org.opencv.core.Mat
import org.opencv.imgproc.Imgproc

/**
 *
 * "Iqbal Ahmed" created on 05/02/2022
 */

fun Bitmap.threshold(const: Int, thresh: Double = 127.0): Bitmap {
    val srcGray = Mat(height, width, CvType.CV_8UC1)
    return processMat {
        Imgproc.cvtColor(it, srcGray, Imgproc.COLOR_BGR2GRAY)
        Imgproc.threshold(srcGray, srcGray, thresh, 255.0, const)
        Imgproc.cvtColor(srcGray, it, Imgproc.COLOR_GRAY2RGBA, 4)
    }
}

fun Bitmap.threshBinary(thresh: Double = 127.0): Bitmap {
    return threshold(Imgproc.THRESH_BINARY, thresh)
}

fun Bitmap.threshBinaryInverse(thresh: Double = 127.0): Bitmap {
    return threshold(Imgproc.THRESH_BINARY_INV, thresh)
}

fun Bitmap.threshTrunc(thresh: Double = 127.0): Bitmap {
    return threshold(Imgproc.THRESH_TRUNC, thresh)
}

fun Bitmap.threshToZero(thresh: Double = 127.0): Bitmap {
    return threshold(Imgproc.THRESH_TOZERO, thresh)
}

fun Bitmap.threshToZeroInverse(thresh: Double = 127.0): Bitmap {
    return threshold(Imgproc.THRESH_TOZERO_INV, thresh)
}

fun Bitmap.adaptiveGaussian(): Bitmap {
    val srcGray = Mat(height, width, CvType.CV_8UC1)
    return processMat {
        Imgproc.cvtColor(it, srcGray, Imgproc.COLOR_BGR2GRAY);
        Imgproc.adaptiveThreshold(
            srcGray, srcGray, 255.0, Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C, Imgproc.THRESH_BINARY, 11, 2.0
        )
        Imgproc.cvtColor(srcGray, it, Imgproc.COLOR_GRAY2RGBA, 4);
    }
}

fun Bitmap.adaptiveMean(): Bitmap {
    val srcGray = Mat(height, width, CvType.CV_8UC1)
    return processMat {
        Imgproc.cvtColor(it, srcGray, Imgproc.COLOR_BGR2GRAY);
        Imgproc.adaptiveThreshold(
            srcGray, srcGray, 255.0, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY, 11, 2.0
        )
        Imgproc.cvtColor(srcGray, it, Imgproc.COLOR_GRAY2RGBA, 4);
    }
}