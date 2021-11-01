package com.example.primeiroapp.ui

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import com.example.primeiroapp.R
import com.example.primeiroapp.model.Usuario
import com.example.primeiroapp.util.convertStringToLocalDate
import java.io.ByteArrayOutputStream
import java.time.LocalDate
import java.util.*

const val CODE_IMAGE = 100
class CadastroUsuarioActivity : AppCompatActivity() {

    //inicializar de forma tardia, esperando o on create e depois criar esse
    lateinit var email : EditText
    lateinit var senha : EditText
    lateinit var nome : EditText
    lateinit var profissao : EditText
    lateinit var altura : EditText
    lateinit var genero : RadioGroup
    lateinit var dataNasc : EditText
    lateinit var radioF : RadioButton
    lateinit var radioM : RadioButton
    lateinit var imagemFotoPerfil : ImageView
    lateinit var trocarFotoPerfil : TextView

    var imageBitmap : Bitmap? = null

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



        imagemFotoPerfil = findViewById(R.id.imagem_perfil)

        trocarFotoPerfil = findViewById(R.id.tv_perfil)

        trocarFotoPerfil.setOnClickListener { abrirGaleria() }

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

                        var mesFinal = _mes + 1
                        var diaFinal = _dia

                        var stringMes = "$mesFinal"
                        var stringDia = "$diaFinal"

                        if(mesFinal < 10){
                            stringMes = "0$mesFinal"
                        }
                        if(diaFinal < 10) {
                            stringDia = "0$diaFinal"
                        }

                        dataNasc.setText("$stringDia/$stringMes/$_ano")
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

            //SALVANDO REGISTRO NO SHARED PREFERENCES

            val dataNascimento = convertStringToLocalDate(dataNasc.text.toString())


            val usuario = Usuario(
                    1,
                    nome.text.toString(),
                    email.text.toString(),
                    senha.text.toString(),
                    0,
                    altura.text.toString().toDouble(),
                    LocalDate.of(dataNascimento.year, dataNascimento.monthValue, dataNascimento.dayOfMonth),
                    profissao.text.toString(),
                    if (radioF.isChecked) 'F' else 'M'
//                    "foto do perfil"

            )

            //Verifica se tem um arquivo que pedidos, caso ao contrario ele cria
            val dados = getSharedPreferences("usuario", Context.MODE_PRIVATE)

            //editor do banquinho de dados
            val editor = dados.edit()

            //quando utilizarmos o put, devemos colocar como paremetro o nome da info/tag e o conteudo dela
            //Além disso, no put, deve haver o tipo que é a variavel/constante
            editor.putInt("id", usuario.id)
            editor.putString("nome", usuario.nome)
            editor.putString("email", usuario.email)
            editor.putString("senha", usuario.senha)
            editor.putInt("peso", usuario.peso)
            editor.putFloat("altura", usuario.altura.toFloat())
            editor.putString("dataNascimento", usuario.dataNascimento.toString())
            editor.putString("profissao", usuario.profissao)
            editor.putString("sexo", usuario.sexo.toString())
//            editor.putString("fotoPerfil", usuario.fotoPerfil)

            //Envia e salva os dados para o arquivo/banquinho
            editor.apply()
            Toast.makeText(this, "Perfil Salvo", Toast.LENGTH_SHORT).show()

        }
        else {
            Toast.makeText(this, "Complete as informações", Toast.LENGTH_SHORT).show()
        }


        return true
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, imagem: Intent?) {
        super.onActivityResult(requestCode, resultCode, imagem)

        //se não selecionado a imagem, volta 0
        //se retornar -1, significa que foi selecionada uma imagem

        if (requestCode == CODE_IMAGE && resultCode == -1){

            //Resuperar a imagem do stream/fluxo de bits
            val imageStream = contentResolver.openInputStream(imagem!!.data!!)

            //converter os bits em bit map
            imageBitmap = BitmapFactory.decodeStream(imageStream)

            //colocar o bitmap no imageview
            imagemFotoPerfil.setImageBitmap(imageBitmap)

        }

    }

    private fun abrirGaleria(){

        //criamos uma variavel com
        val intent = Intent(Intent.ACTION_GET_CONTENT)

        //qual o tipo de recurso que quero pegar
        intent.type = "image/*"

        //abrir a activity responsavel por exibir as imagens, na qual retornará o conteudo selecionado para o nosso app
        startActivityForResult(Intent.createChooser(intent, "Escolha uma foto"), CODE_IMAGE)
    }

    fun validarCampos() : Boolean{

        var valido = true

        if(email.text.isEmpty()){
            email.error = "Campo email deve ser preenchido"
            valido = false
        }
        if(senha.text.isEmpty()){
            senha.error = "Campo senha deve ser preenchido"
            valido = false
        }
        if (nome.text.isEmpty()){
            nome.error = "Campo nome deve ser preenchido"
            valido = false
        }
        if (profissao.text.isEmpty()){
            profissao.error = "Campo profissao deve ser preenchido"
            valido = false
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