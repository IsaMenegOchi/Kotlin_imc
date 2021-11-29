package com.example.primeiroapp.ui

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.primeiroapp.R
import com.example.primeiroapp.util.dateFormatterToBrazilian
import java.time.LocalDate
import java.util.*

lateinit var dataNasc : TextView
lateinit var btnSalvarPesagem : Button
lateinit var spinnerNivel : Spinner
lateinit var etNovoPeso : EditText


class DataPesagemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_pesagem)
        supportActionBar!!.hide()

        dataNasc = findViewById(R.id.etPesagem)
        dataNasc.text = dateFormatterToBrazilian()

        btnSalvarPesagem = findViewById<Button>(R.id.btnPesagem)
        spinnerNivel = findViewById<Spinner>(R.id.spinner_levels)
        etNovoPeso = findViewById<EditText>(R.id.etNovoPeso)

        val calendario = Calendar.getInstance()

        //DETERMINAR DADOS (dia, mes e ano) DO CALENDARIO
        val ano = calendario.get(Calendar.YEAR)
        val mes = calendario.get(Calendar.MONTH)

        //dia do mes é o dia mesmo, em numero
        //dia da semana é o nome do dia como segunda
        val dia = calendario.get(Calendar.DAY_OF_MONTH)
        dataNasc.setOnClickListener {
            val dp = DatePickerDialog(this,
                    DatePickerDialog.OnDateSetListener {
                        //criamos a variavel que vai guardar o dia, mes e ano que clicamos
                        view, _ano, _mes, _dia ->

                        var mesFinal = _mes + 1
                        var diaFinal = _dia

                        var stringMes = "$mesFinal"
                        var stringDia = "$diaFinal"

                        if (mesFinal < 10) {
                            stringMes = "0$mesFinal"
                        }
                        if (diaFinal < 10) {
                            stringDia = "0$diaFinal"
                        }

                        dataNasc.setText("$stringDia/$stringMes/$_ano")
                    }, ano, mes, dia)

            dp.show()
        }

        btnSalvarPesagem.setOnClickListener {
            val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
            val editor = arquivo.edit()

            val pesagem = arquivo.getString("pesagem", "")
            val dataPesagem = arquivo.getString("data_pesagem", "")
            val nivel = arquivo.getString("nível", "")

            editor.putString("pesagem", "$pesagem; ${etNovoPeso.text.toString()}")
            editor.putString("data_pesagem", "$dataPesagem; ${LocalDate.now().toString()}")
            editor.putString("nível", "$nivel; ${spinnerNivel.selectedItemPosition.toString()}")
            editor.apply()

            Toast.makeText(this, "Pesagem salva", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }

    }
}