package com.example.primeiroapp.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.primeiroapp.R
import com.example.primeiroapp.calcularImc
import com.example.primeiroapp.util.autenticar
import com.example.primeiroapp.util.calcularIdade
import java.time.LocalDate
import kotlin.math.log

lateinit var txtNome : TextView
lateinit var txtProfissao : TextView
lateinit var altura : TextView
lateinit var dataNascimento : TextView
lateinit var peso : TextView
lateinit var cardPesagem : CardView
//lateinit var cardNovaPesagem : CardView

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        supportActionBar!!.hide()

        dataNascimento = findViewById<TextView>(R.id.idade_dash)
        txtProfissao = findViewById<TextView>(R.id.profissao_dash)
        txtNome = findViewById<TextView>(R.id.nome_dash)
        altura = findViewById<TextView>(R.id.altura_dash)
        peso = findViewById<TextView>(R.id.peso_dash)
        cardPesagem = findViewById<CardView>(R.id.card_peso_dash)
//        cardNovaPesagem = findViewById<CardView>()

        carregarDashboard()

        cardPesagem.setOnClickListener {
            val intent = Intent(this, DataPesagemActivity::class.java)
            startActivity(intent)
        }


    }

    private fun carregarDashboard()
    {

        val dados = getSharedPreferences("usuario", Context.MODE_PRIVATE)

        txtNome.text = dados.getString("nome", "")

        txtProfissao.text = dados.getString("profissao", "")

        altura.text = dados.getFloat("altura", 0.0F).toString()

        dataNascimento.text = calcularIdade(dados.getString("dataNascimento", "")!!).toString()

        peso.text= dados.getInt("peso", 0).toString()


    }

}
