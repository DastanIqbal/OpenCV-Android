package org.dastanapps.opencv.android.ext

import android.content.Context
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore

/**
 *
 * "Iqbal Ahmed" created on 02/02/2022
 */


fun bitmap(context: Context, uri: Uri?): Bitmap? {
    if (uri == null || uri == Uri.EMPTY) return null
    return if (Build.VERSION.SDK_INT < 28) {
        MediaStore.Images
            .Media.getBitmap(context.contentResolver, uri)

    } else {
        val source = ImageDecoder
            .createSource(context.contentResolver, uri)
        ImageDecoder.decodeBitmap(source)
    }
}