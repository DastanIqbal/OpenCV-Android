package org.dastanapps.opencv.android.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import org.dastanapps.opencv.android.ui.MyAppBarBackArrow
import org.dastanapps.opencv.android.ui.theme.Typography
import org.dastanapps.opencv.android.vm.Tutorial

/**
 *
 * "Iqbal Ahmed" created on 30/01/2022
 */


@Composable
fun ShowTutorial(name: String, tutorial: Tutorial, navHostController: NavHostController) {
    val context = LocalContext.current
    MyAppBarBackArrow(
        title = name,
        navgationIcon = {
            navHostController.navigateUp()
        }
    ) {
        Text(
            text = tutorial.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            fontSize = Typography.body1.fontSize,
            style = TextStyle(color = Color.Black),
        )
    }
}