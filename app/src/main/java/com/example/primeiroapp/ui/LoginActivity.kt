package com.example.primeiroapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.primeiroapp.R
import com.example.primeiroapp.util.autenticar

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

//        val novaConta = findViewById<EditText>()
        val buttonEntrar = findViewById<Button>(R.id.botao_login)

        val emailLogin = findViewById<EditText>(R.id.email_login)
        val senhaLogin = findViewById<EditText>(R.id.senha_login)

        buttonEntrar.setOnClickListener{

            val autenticou = (autenticar(emailLogin.text.toString(), senhaLogin.text.toString(), this))

            if(autenticou) {
                val intent = Intent (this, DashboardActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Usuario ou senha incorreto", Toast.LENGTH_SHORT).show()
            }
        }




    }

}