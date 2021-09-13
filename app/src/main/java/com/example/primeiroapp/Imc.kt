package com.example.primeiroapp

import java.text.DecimalFormat


//forma de criar uma função no kotlin
//não retorna nada

fun calcularImc(peso: Int, altura: Double) : Double{
    return peso / (altura *altura)
}