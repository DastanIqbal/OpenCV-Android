package org.dastanapps.opencv.android.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.dastanapps.opencv.android.navigation.NavGraph
import org.dastanapps.opencv.android.ui.MyAppBarBackArrow
import org.dastanapps.opencv.android.ui.theme.Typography
import org.dastanapps.opencv.android.vm.Tutorial

/**
 *
 * "Iqbal Ahmed" created on 30/01/2022
 */


@Composable
fun Tutorials(
    name: String,
    chapterId: Int,
    list: List<Tutorial>,
    navHostController: NavHostController,
    click: (String) -> Unit
) {
    MyAppBarBackArrow(
        title = name,
        navgationIcon = {
            navHostController.navigateUp()
        }
    ) {
        LazyColumn(Modifier.fillMaxSize().padding(16.dp)) {
            items(items = list, itemContent = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp)
                        .clickable {
                            click.invoke(
                                NavGraph.ShowTutorial.withArgs(
                                    it.name,
                                    chapterId.toString(),
                                    it.id.toString()
                                )
                            )
                        }
                ) {
                    Text(
                        text = it.name,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        fontSize = Typography.body1.fontSize,
                        style = TextStyle(color = Color.Black),
                    )
                    Divider(color = Color.Gray, thickness = 0.5.dp)
                }
            })
        }
    }
}