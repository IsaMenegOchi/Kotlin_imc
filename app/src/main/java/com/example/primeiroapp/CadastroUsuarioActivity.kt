package com.example.primeiroapp

import android.app.DatePickerDialog
import android.content.ClipData
import android.content.ClipData.Item
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.view.isEmpty
import java.util.*

class CadastroUsuarioActivity : AppCompatActivity() {

    //inicializar de forma tardia, esperando o on create e depois criar esse
    lateinit var email : EditText
    lateinit var senha : EditText
    lateinit var nome : EditText
    lateinit var profissao : EditText
    lateinit var altura : EditText
    lateinit var genero : RadioGroup
    lateinit var  dataNasc : EditText
    lateinit var radioF : RadioButton
    lateinit var radioM : RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_usuario)

        supportActionBar!!.title = "Perfil"

        email = findViewById(R.id.text_input_email)
        senha = findViewById(R.id.text_input_senha)
       nome = findViewById(R.id.text_input_nome)
        profissao = findViewById(R.id.text_input_profissao)
        altura = findViewById(R.id.text_input_altura)
        genero = findViewById(R.id.grupo_genero)
        radioF = findViewById(R.id.radio_fem)
        radioM = findViewById(R.id.radio_masc)
        dataNasc = findViewById(R.id.data_nascimento)



        //CRIAR A TELA
        val calendario = Calendar.getInstance()

        //DETERMINAR DADOS (dia, mes e ano) DO CALENDARIO
        val ano = calendario.get(Calendar.YEAR)
        val mes = calendario.get(Calendar.MONTH)

        //dia do mes é o dia mesmo, em numero
        //dia da semana é o nome do dia como segunda
        val dia = calendario.get(Calendar.DAY_OF_MONTH)

        //ABRIR O COMPONENTE DATE PICKER



        dataNasc.setOnClickListener {
            val dp = DatePickerDialog(this,
                    DatePickerDialog.OnDateSetListener {
                        //criamos a variavel que vai guardar o dia, mes e ano que clicamos
                        view, _ano, _mes, _dia ->
                        dataNasc.setText("$_dia/${_mes + 1}/$_ano")
                    }, ano, mes, dia)
            dp.show()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_cadastro, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{

        if(validarCampos()){

        }
        return true
    }

    fun validarCampos() : Boolean{

        var valido = false

        if(email.text.isEmpty()){
            email.error = "Campo email deve ser preenchido"
            valido = true
        }
        if(senha.text.isEmpty()){
            senha.error = "Campo senha deve ser preenchido"
            valido = true
        }
        if (nome.text.isEmpty()){
            nome.error = "Campo nome deve ser preenchido"
            valido = true
        }
        if (profissao.text.isEmpty()){
            profissao.error = "Campo profissao deve ser preenchido"
            valido = true
        }
        if(altura.text.isEmpty()){
            altura.error = "Campo altura deve ser preenchido"
            valido = false
        }
        if (dataNasc.text.isEmpty() ){
            dataNasc.error = "O campo da data de nascimento deve ser preenchido"
            valido = false
        }
        if(!radioF.isChecked && !radioM.isChecked){
            Toast.makeText(this, "Você deve selecionar um genero", Toast.LENGTH_SHORT).show()
            valido = false
        }

        return valido
    }

}