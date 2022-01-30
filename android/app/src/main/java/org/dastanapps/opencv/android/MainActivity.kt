package org.dastanapps.opencv.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import org.dastanapps.opencv.android.navigation.Navigation
import org.dastanapps.opencv.android.screen.Home
import org.dastanapps.opencv.android.ui.theme.LearnOpenCVAndroidTheme
import org.dastanapps.opencv.android.vm.MainViewModel
import org.dastanapps.opencv.android.vm.SourceMedium
import org.opencv.android.InstallCallbackInterface
import org.opencv.android.LoaderCallbackInterface
import org.opencv.android.OpenCVLoader

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnOpenCVAndroidTheme {
                val navController = rememberNavController()
                Navigation(navController, viewModel)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION, this, object : LoaderCallbackInterface {
            override fun onManagerConnected(status: Int) {
                Log.d("OpenCV", "Status:$status")
                when (status) {
                    LoaderCallbackInterface.SUCCESS -> {

                    }
                    else -> {

                    }
                }
            }

            override fun onPackageInstall(operation: Int, callback: InstallCallbackInterface?) {
                Log.d("OpenCV", "Operation:$operation")
            }

        })
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LearnOpenCVAndroidTheme {
        Home(
            arrayListOf(
                SourceMedium(0, "book", "Mastering OpenCV Android Application Programming")
            )
        ) {}
    }
}