package com.example.primeiroapp.util

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun convertStringToLocalDate(brazilianDate: String) : LocalDate
{
    //determina qual o padrão de data do brasil
    val dateFormatterFromBrazil = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    //Passa a string recebida para um local date, considerando que ela está no formato brasileiro.
    val localDateFormat = LocalDate.parse(brazilianDate, dateFormatterFromBrazil)

    return localDateFormat
}

    fun calcularIdade(dataDeNascimento: String): Int {

        //obter data atual
        val hoje = LocalDate.now();

        //converter a data de nascimento em local date
        val arrayNascimento = dataDeNascimento.split("-").toTypedArray() //retorna um array
        val dataNascimento = LocalDate.of(arrayNascimento[0].toInt(), arrayNascimento[1].toInt(), arrayNascimento[2].toInt())

        val idade = Period.between(dataNascimento, hoje).years.toString();
        return idade.toInt()
    }

