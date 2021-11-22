package com.example.primeiroapp.ui

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.primeiroapp.R
import java.util.*

//lateinit var dataNasc : EditText

class DataPesagemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_pesagem)
        supportActionBar!!.hide()
//        dataNasc = findViewById(R.id.etPesagem)
//
//        val calendario = Calendar.getInstance()
//
//        //DETERMINAR DADOS (dia, mes e ano) DO CALENDARIO
//        val ano = calendario.get(Calendar.YEAR)
//        val mes = calendario.get(Calendar.MONTH)
//
//        //dia do mes é o dia mesmo, em numero
//        //dia da semana é o nome do dia como segunda
//        val dia = calendario.get(Calendar.DAY_OF_MONTH)
//        dataNasc.setOnClickListener {
//            val dp = DatePickerDialog(this,
//                    DatePickerDialog.OnDateSetListener {
//                        //criamos a variavel que vai guardar o dia, mes e ano que clicamos
//                        view, _ano, _mes, _dia ->
//
//                        var mesFinal = _mes + 1
//                        var diaFinal = _dia
//
//                        var stringMes = "$mesFinal"
//                        var stringDia = "$diaFinal"
//
//                        if (mesFinal < 10) {
//                            stringMes = "0$mesFinal"
//                        }
//                        if (diaFinal < 10) {
//                            stringDia = "0$diaFinal"
//                        }
//
//                        dataNasc.setText("$stringDia/$stringMes/$_ano")
//                    }, ano, mes, dia)
//
//            dp.show()
//        }
    }
}