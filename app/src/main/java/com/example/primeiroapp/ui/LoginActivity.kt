package com.example.primeiroapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.primeiroapp.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar!!.hide()

        val tvHello = findViewById<TextView>(R.id.criar_conta)

        tvHello.setOnClickListener {
            val abrirCadastroUsuarioActivity = Intent(this, CadastroUsuarioActivity::class.java)
            startActivity(abrirCadastroUsuarioActivity)
        }




    }
}