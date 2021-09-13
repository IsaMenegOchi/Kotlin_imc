package com.example.primeiroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //R de recursos
        //layout da nossa atividade
        //res de resource
        //responsavel por fazer o layout da tela

        val buttonCacular = findViewById<Button>(R.id.button_calcular)//caminho para pegar o buton
        val editTextPeso = findViewById<EditText>(R.id.edit_text_peso)
        val editTextAltura = findViewById<EditText>(R.id.edit_text_altura)
        val textViewResultado = findViewById<TextView>(R.id.text_view_resultado)
        val textViewResultadoTexto = findViewById<TextView>(R.id.text_view_resultado_texto)

        buttonCacular.setOnClickListener {
            Toast.makeText(this, "Clicou", Toast.LENGTH_SHORT).show()
            //context - onde que vai aparecer o que formos fazer, ou seja, nesse layout
            //toast - mensagem que aparece em baixo


            //prof
//            var peso = editTextPeso.text.toString().toInt()
//            var altura = editTextAltura.text.toString().toDouble()
//
//            val imc = calcularImc(peso, altura)
//            textViewResultado.text = calcularImc(editTextPeso.text.toString().toInt(), editTextAltura.text.toString().toDouble()).toString()

            textViewResultado.text = String.format("%.1f")

            var resultado = calcularImc(editTextPeso.text.toString().toInt(), editTextAltura.text.toString().toDouble()).toString()

            if (resultado <= 18.5.toString()) {
                textViewResultadoTexto.text = "Você está abaixo do peso ideal!"
            }

            else if (resultado >= 18.5.toString() && resultado <= 24.9.toString()) {
                textViewResultadoTexto.text = "Você está com peso ideal!"
            }

            else if (resultado >= 25.0.toString() && resultado <= 29.9.toString()) {
                textViewResultadoTexto.text = "Você está acima do peso ideal!"
            }

            else if (resultado >= 30.0.toString() && resultado <= 34.9.toString()) {
                textViewResultadoTexto.text = "Você está com obsedidade grau I!"
            }

            else if (resultado >= 35.0.toString() && resultado <= 39.9.toString()) {
                textViewResultadoTexto.text = "Você está com obsidade grau II!"
            }

            else {
                textViewResultadoTexto.text = "Você está co obesidade grau III!"
            }
        }
    }
}