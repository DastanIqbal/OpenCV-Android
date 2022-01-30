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
    }

    fun tutorial(chapterId: Int, tutorialId: Int) =
        tutorials[chapterId]?.filter {
            it.id == tutorialId
        }?.toList()
}