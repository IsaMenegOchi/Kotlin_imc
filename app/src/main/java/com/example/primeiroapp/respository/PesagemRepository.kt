package com.example.primeiroapp.respository

import android.content.Context
import com.example.primeiroapp.model.Pesagem

class PesagemRepository(var context: Context) {

    fun getListaPesagem(): List<Pesagem>{
        val listaPesagem = mutableListOf<Pesagem>()

        val dados = context.getSharedPreferences("usuario", Context.MODE_PRIVATE)

        val pesoString = dados.getString("pesagem", "")
        val datasString = dados.getString("data_pesagem", "")

        val pesoArray = pesoString!!.split(";").toTypedArray()
        val datasArray = datasString!!.split(";").toTypedArray()

        //lista de pesagem
        for (i in 0 until pesoArray.size){
            //como se fosse um foreach, ou seja, ele percorre o array, e vai listando os valores

            val pesagem = Pesagem(datasArray[i], pesoArray[i].trim().toInt())

            listaPesagem.add(pesagem)

        }
        return listaPesagem
    }
}