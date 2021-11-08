package com.example.primeiroapp.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.primeiroapp.R
import java.time.LocalDate
import kotlin.math.log


class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        supportActionBar!!.hide()

        val dados = getSharedPreferences("usuario", Context.MODE_PRIVATE)

        val profissao = findViewById<TextView>(R.id.profissao_dash)
        profissao.setText("${dados.getString("profissao", "")}")

        val nome = findViewById<TextView>(R.id.nome_dash)
        nome.setText("${dados.getString("nome", "")}")

////        val imc =
//        val idade = findViewById<TextView>(R.id.idade_dash)
//        idade.setText("${(dados.getString("idade", "")!!.toFloat()) - LocalDate}")
//
//        val peso = findViewById<TextView>(R.id.peso_dash)
//        peso.setText("${dados.getFloat("peso", 0.0F).toString()}")

//
        val altura = findViewById<TextView>(R.id.altura_dash)
        altura.setText("${dados.getFloat("altura", 0.0F)}")






    }


}