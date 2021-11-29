package com.example.primeiroapp

import android.content.Context
import java.text.DecimalFormat


fun calcularImc(context: Context) : Double {
    //Context - contexto da aplicação
    val arquivo = context.getSharedPreferences("usuario", Context.MODE_PRIVATE)

    val peso = arquivo.getString("pesagem", "")!!.split(";").toTypedArray()
    val pesoAtual = peso.lastIndex.toInt()

    val altura = arquivo.getFloat("altura", 0.0F)

    return (pesoAtual / (altura * altura)).toDouble()
}

fun calcularNcd(): Double{
    val teste = 2.0
    return teste
}