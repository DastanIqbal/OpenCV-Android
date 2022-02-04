package org.dastanapps.opencv.android.ext

import android.graphics.Bitmap
import org.opencv.imgproc.Imgproc

/**
 *
 * "Iqbal Ahmed" created on 05/02/2022
 */


fun Bitmap.threshBinary(thresh: Double = 127.0): Bitmap {
    return processMat {
        Imgproc.threshold(it, it, thresh, 255.0, Imgproc.THRESH_BINARY);
    }
}

fun Bitmap.threshBinaryInverse(thresh: Double = 127.0): Bitmap {
    return processMat {
        Imgproc.threshold(it, it, thresh, 255.0, Imgproc.THRESH_BINARY_INV);
    }
}

fun Bitmap.threshTrunc(thresh: Double = 127.0): Bitmap {
    return processMat {
        Imgproc.threshold(it, it, thresh, 255.0, Imgproc.THRESH_TRUNC);
    }
}

fun Bitmap.threshToZero(thresh: Double = 127.0): Bitmap {
    return processMat {
        Imgproc.threshold(it, it, thresh, 255.0, Imgproc.THRESH_TOZERO);
    }
}

fun Bitmap.threshToZeroInverse(thresh: Double = 127.0): Bitmap {
    return processMat {
        Imgproc.threshold(it, it, thresh, 255.0, Imgproc.THRESH_TOZERO_INV);
    }
}

fun Bitmap.adaptiveGaussian(): Bitmap {
    return processMat {
        Imgproc.cvtColor(it, it, Imgproc.COLOR_BGR2GRAY);
        Imgproc.adaptiveThreshold(
            it, it, 255.0, Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C, Imgproc
                .THRESH_BINARY, 11, 2.0
        );
    }
}

fun Bitmap.adaptiveMean(): Bitmap {
    return processMat {
        Imgproc.cvtColor(it, it, Imgproc.COLOR_BGR2GRAY);
        Imgproc.adaptiveThreshold(
            it, it, 255.0, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY, 11, 2.0
        );
    }
}