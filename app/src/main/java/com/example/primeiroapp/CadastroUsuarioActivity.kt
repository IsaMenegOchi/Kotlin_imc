package com.example.primeiroapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.util.*

class CadastroUsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_usuario)

        supportActionBar!!.title= "Perfil"

        //CRIAR A TELA
        val calendario = Calendar.getInstance()

        //DETERMINAR DADOS (dia, mes e ano) DO CALENDARIO
        val ano = calendario.get(Calendar.YEAR)
        val mes = calendario.get(Calendar.MONTH)

        //dia do mes é o dia mesmo, em numero
        //dia da semana é o nome do dia como segunda
        val dia = calendario.get(Calendar.DAY_OF_MONTH)

        //ABRIR O COMPONENTE DATE PICKER
        val etDataNasc = findViewById<EditText>(R.id.data_nascimento)

        etDataNasc.setOnClickListener {
            val dp = DatePickerDialog(this,
                    DatePickerDialog.OnDateSetListener {
                        //criamos a variavel que vai guardar o dia, mes e ano que clicamos
                        view, _ano, _mes, _dia -> etDataNasc.setText("$_dia/${_mes+1}/$_ano")} , ano, mes, dia)
            dp.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_cadastro, menu)
        return true
    }


}