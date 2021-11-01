package com.example.primeiroapp.util

import android.graphics.Bitmap
import android.util.Base64
import java.io.ByteArrayOutputStream

fun convertToBitmapToBase64(bitmap: Bitmap) : String{

    val bitmapArray = ByteArrayOutputStream()

    bitmap.compress(Bitmap.CompressFormat.PNG, 100 , bitmapArray)

    val byteArray = bitmapArray.toByteArray()

    return Base64.encodeToString(byteArray, Base64.DEFAULT)

}