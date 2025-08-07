package com.example.robomarciano

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class HistoricoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.historico_activity)
        Toast.makeText(this, "cvsdcv", Toast.LENGTH_LONG).show()

        val lista = findViewById<ListView>(R.id.listaHistorico)

        val comandosFormatados = Historico.listar().map {
            if (it.isBlank()) "[Mensagem vazia]" else it
        }

        val adapter = ArrayAdapter(this, R.layout.list_item, R.id.textItem, comandosFormatados)
        lista.adapter = adapter

        val botaoVoltar = findViewById<Button>(R.id.buttonEnviar)
        botaoVoltar.setOnClickListener {
            finish()
        }
    }
}
