package org.dastanapps.opencv.android

import android.content.Context
import android.widget.Toast

/**
 *
 * "Iqbal Ahmed" created on 30/01/2022
 */


fun toast(
    context: Context,
    msg: String
) {
    Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
}