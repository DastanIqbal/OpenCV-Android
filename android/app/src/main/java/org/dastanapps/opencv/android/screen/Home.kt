package org.dastanapps.opencv.android.screen

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import org.dastanapps.opencv.android.navigation.NavGraph
import org.dastanapps.opencv.android.navigation.imageUri
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
    val uriImage = remember { mutableStateOf<Uri?>(null) }

    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
//            uriImage.value = uri
            imageUri = uri
        }
    MyAppBar("OpenCV Tutorials") {
        Column {
            Row(modifier = Modifier.padding(8.dp)) {
                Button(
                    onClick = {
                        launcher.launch("image/*")
                    },
                    modifier = Modifier.wrapContentWidth(),
                    content = {
                        Text("Pick Image")
                    })
                Button(
                    onClick = {

                    },
                    modifier = Modifier.wrapContentWidth().padding(start = 8.dp),
                    content = {
                        Text("Pick Video")
                    })
            }
            LazyColumn(Modifier.fillMaxSize().padding(16.dp)) {
                items(items = list, itemContent = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
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
}