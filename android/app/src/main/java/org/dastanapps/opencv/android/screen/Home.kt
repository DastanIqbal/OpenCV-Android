package org.dastanapps.opencv.android.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import org.dastanapps.opencv.android.navigation.NavGraph
import org.dastanapps.opencv.android.ui.MyAppBar
import org.dastanapps.opencv.android.ui.theme.Typography
import org.dastanapps.opencv.android.vm.SourceMedium

/**
 *
 * "Iqbal Ahmed" created on 30/01/2022
 */


@Composable
fun Home(list: List<SourceMedium>, click: (String) -> Unit) {
    val context = LocalContext.current
    MyAppBar("OpenCV Tutorials") {
        LazyColumn(Modifier.fillMaxSize().padding(16.dp)) {
            items(items = list, itemContent = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(0.dp)
                        .clickable {
                            click.invoke(
                                NavGraph.Chapters.withArgs(
                                    it.name,
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