package com.example.primeiroapp.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import java.io.ByteArrayOutputStream

fun convertToBitmapToBase64(bitmap: Bitmap) : String{

    val bitmapArray = ByteArrayOutputStream()

    bitmap.compress(Bitmap.CompressFormat.PNG, 100 , bitmapArray)

    val byteArray = bitmapArray.toByteArray()

    return Base64.encodeToString(byteArray, Base64.DEFAULT)

}

fun convertBase64ToBitmap(base64image: String) : Bitmap{

    //converter o base 64 em bit
    val imageBit = Base64.decode(base64image, Base64.DEFAULT)
    return  BitmapFactory.decodeByteArray(imageBit, 0, imageBit.size)
}