package org.dastanapps.opencv.android.ext

import android.graphics.Bitmap
import org.opencv.android.Utils
import org.opencv.core.*
import org.opencv.imgproc.Imgproc
import java.util.*


/**
 *
 * "Iqbal Ahmed" created on 10/04/2022
 */


fun Bitmap.DifferenceOfGaussian(): Bitmap {

    val tempBitmap: Bitmap = this.copy(Bitmap.Config.ARGB_8888, true)

    val originalMat = Mat(tempBitmap.height, tempBitmap.width, CvType.CV_8U)
    Utils.bitmapToMat(this, originalMat)

    val currentBitmap = this.copy(Bitmap.Config.ARGB_8888, false)

    val grayMat = Mat()
    val blur1 = Mat()
    val blur2 = Mat()

    //Converting image to grayscale
    Imgproc.cvtColor(originalMat, grayMat, Imgproc.COLOR_BGR2GRAY)

    //Blur Image
    Imgproc.GaussianBlur(grayMat, blur1, Size(15.0, 15.0), 5.0)
    Imgproc.GaussianBlur(grayMat, blur2, Size(21.0, 21.0), 5.0)

    //Difference of 2 Blur
    val DoG = Mat()
    Core.absdiff(blur1, blur2, DoG)

    //Inverse Binary Thresholding
    Core.multiply(DoG, Scalar(100.0), DoG)
    Imgproc.threshold(DoG, DoG, 50.0, 255.0, Imgproc.THRESH_BINARY_INV)

    //Convert Mat to Bitmap
    Utils.matToBitmap(DoG, currentBitmap)
    return currentBitmap
}

fun Bitmap.Canny(): Bitmap {
    val originalMat = Mat(height, width, CvType.CV_8U)
    Utils.bitmapToMat(this, originalMat)

    val currentBitmap = this.copy(Bitmap.Config.ARGB_8888, false)

    val grayMat = Mat()
    val cannyEdges = Mat()

    Imgproc.cvtColor(originalMat, grayMat, Imgproc.COLOR_BGR2GRAY)
    Imgproc.Canny(grayMat, cannyEdges, 10.0, 100.0)

    Utils.matToBitmap(cannyEdges, currentBitmap)
    return currentBitmap
}

fun Bitmap.Soble(): Bitmap {
    val originalMat = Mat(height, width, CvType.CV_8U)
    Utils.bitmapToMat(this, originalMat)

    val currentBitmap = this.copy(Bitmap.Config.ARGB_8888, false)
    val grayMat = Mat()
    val sobel = Mat() //Mat to store the result

    //Mat to store gradient and absolute gradient respectively
    val grad_x = Mat()
    val abs_grad_x = Mat()
    val grad_y = Mat()
    val abs_grad_y = Mat()

    Imgproc.cvtColor(originalMat, grayMat, Imgproc.COLOR_BGR2GRAY)

    //Calculating gradient in horizontal direction
    Imgproc.Sobel(grayMat, grad_x, CvType.CV_16S, 1, 0, 3, 1.0, 0.0)

    //Calculating gradient in vertical direction
    Imgproc.Sobel(grayMat, grad_y, CvType.CV_16S, 0, 1, 3, 1.0, 0.0)

    //Calculating absolute value of gradients in both the direction
    Core.convertScaleAbs(grad_x, abs_grad_x);
    Core.convertScaleAbs(grad_y, abs_grad_y);

    Core.addWeighted(abs_grad_x, 0.5, abs_grad_y, 0.5, 1.0, sobel);

    Utils.matToBitmap(sobel, currentBitmap)
    return currentBitmap
}

fun Bitmap.HarrisCorner(): Bitmap {
    val originalMat = Mat(height, width, CvType.CV_8U)
    Utils.bitmapToMat(this, originalMat)

    val currentBitmap = this.copy(Bitmap.Config.ARGB_8888, false)

    val grayMat = Mat()
    Imgproc.cvtColor(originalMat, grayMat, Imgproc.COLOR_BGR2GRAY)

    val corners = Mat()

    val tempDst = Mat()

    //finding corners
    Imgproc.cornerHarris(grayMat, tempDst, 2, 3, 0.04)

    //Normalizing harris corner's output
    val tempDstNorm = Mat()
    Core.normalize(tempDst, tempDstNorm, 0.0, 255.0, Core.NORM_MINMAX)
    Core.convertScaleAbs(tempDstNorm, corners)

    //Drawing corners on a new image
    val r = Random();
    repeat(tempDstNorm.cols()) { i ->
        repeat(tempDstNorm.rows()) { j ->
            val value = tempDstNorm.get(j, i);
            if (value[0] > 150)
                Imgproc.circle(
                    corners,
                    Point(i.toDouble(), j.toDouble()),
                    5,
                    Scalar(r.nextInt(255).toDouble()),
                    2
                )
        }
    }


    Utils.matToBitmap(corners, currentBitmap)
    return currentBitmap
}