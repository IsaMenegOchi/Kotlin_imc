package com.example.primeiroapp.util

import android.content.Context
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

//context = contexto que chamou a activity
fun autenticar (email: String, senha: String, context: Context) : Boolean {

    val arquivo = context.getSharedPreferences("usuario", Context.MODE_PRIVATE)

    //a primeira string é
        return (email == arquivo.getString("email", "") && senha == arquivo.getString("senha", ""))

    //outro modo de fazer
//    if(email = arquivo.getString("email", "") && senha = arquivo.getString("senha", "")){
//        return true
//    }
//    else{
//        return false
////    }

}

