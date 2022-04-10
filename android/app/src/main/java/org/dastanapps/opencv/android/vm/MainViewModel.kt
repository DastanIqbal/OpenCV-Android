package org.dastanapps.opencv.android.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel

/**
 *
 * "Iqbal Ahmed" created on 30/01/2022
 */


data class SourceMedium(
    val id: Int,
    val type: String,
    val name: String
)

data class Chapter(
    val id: Int,
    val name: String
)

data class Tutorial(val id: Int, val name: String)

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val TAG = this::class.java.simpleName

    val sources = arrayListOf(
        SourceMedium(
            100,
            "book",
            "Mastering OpenCV Android Application Programming"
        )
    )

    val chapters = hashMapOf<Int, List<Chapter>>().apply {
        put(
            100, arrayListOf(
                Chapter(
                    110,
                    "Applying Effects to Images"
                ),
                Chapter(
                    120,
                    "Detecting Basic Features in Images"
                ),
                Chapter(
                    130,
                    "Detecting Objects"
                ),
                Chapter(
                    140,
                    "Drilling Deeper into Object Detection - Using Cascade Classifiers"
                ),
                Chapter(
                    150,
                    "Tracking Objects in Videos"
                ),
                Chapter(
                    160,
                    "Working with Image Alignment and Stitching"
                ),
                Chapter(
                    170,
                    "Bringing Your Apps to Life with OpenCV Machine Learning"
                ),
                Chapter(
                    180,
                    "Developing a Document Scanning App"
                )
            )
        )
    }

    val tutorials = hashMapOf<Int, List<Tutorial>>().apply {
        put(
            110, arrayListOf(
                Tutorial(111, "Blur"),
                Tutorial(112, "Morphological Operations"),
                Tutorial(113, "Thresholding")
            )
        )
        put(
            120, arrayListOf(
                Tutorial(121, "Edge and Corner Detection"),
                Tutorial(122, "Hough Transformations"),
                Tutorial(123, "Contours"),
                Tutorial(124, "Project - Detecting Sudoku Puzzle")
            )
        )
        put(
            130, arrayListOf(
                Tutorial(131, "SIFT - Scale Invariant Feature Transform"),
                Tutorial(132, "Matching features and detecting objects"),
                Tutorial(133, "SURF - Speed Up Robust Features"),
                Tutorial(134, "oFAST - Oriented FAST and rBRIEF - Rotated BRIEF"),
                Tutorial(135, "BRISK - Binary Robust Invariant Scalable Keypoints"),
                Tutorial(136, "FREAK - Fast Retina Keypoint")
            )
        )
        put(
            140, arrayListOf(
                Tutorial(141, "An introduction to cascade classifiers"),
                Tutorial(142, "Face detection using the cascade classifier"),
                Tutorial(143, "HOG descriptors"),
                Tutorial(144, "Project – Happy Camera")
            )
        )
        put(
            150, arrayListOf(
                Tutorial(151, "Optical flow"),
                Tutorial(152, "Image Pyramids"),
                Tutorial(153, "Basic 2D transformations"),
                Tutorial(154, "Global motion estimation"),
                Tutorial(155,"The Kanade-Lucas-Tomasi tracker")
            )
        )
        put(
            160, arrayListOf(
                Tutorial(161, "Image stitching"),
            )
        )
        put(
            170, arrayListOf(
                Tutorial(171, "Optical Character Recognition"),
                Tutorial(172, "Solving a Sudoku puzzle"),
            )
        )
    }

    fun tutorial(chapterId: Int, tutorialId: Int) =
        tutorials[chapterId]?.filter {
            it.id == tutorialId
        }?.toList()
}