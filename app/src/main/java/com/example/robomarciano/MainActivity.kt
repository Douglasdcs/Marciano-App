package com.example.robomarciano

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val editTextInput = findViewById<TextInputEditText>(R.id.editTextInput)
        val botaoEnviar = findViewById<Button>(R.id.buttonEnviar)
        val botaoHistorico = findViewById<Button>(R.id.buttonHist)

        // Ação
        botaoEnviar.setOnClickListener {
            val textoDigitado = editTextInput.text.toString().trim()

            Historico.adicionar(textoDigitado) // salva historico

            val resposta = processarEntrada(textoDigitado)
            val intent = Intent(this, RespostaActivity::class.java)
            intent.putExtra("resposta", resposta)
            startActivity(intent)

        }

        botaoHistorico.setOnClickListener {
            val intent = Intent(this, HistoricoActivity::class.java)
            startActivity(intent)
        }
    }

    // Limpa quando volta para a main
    override fun onResume() {
        super.onResume()
        val editText = findViewById<TextInputEditText>(R.id.editTextInput)
        editText.text?.clear()
        // teclado - nao funcionou
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(editText.windowToken, 0)
    }

    fun processarEntrada(input: String): String {
        val builder = StringBuilder()

        val acao = Acao { comando ->
            when (comando.lowercase()) {
                "autodestruir" -> {
                    builder.appendLine("...Iniciando autodestruição...")
                    for (i in 3 downTo 1) {
                        builder.appendLine("$i...")
                        Thread.sleep(500)
                    }
                    builder.appendLine("XABLAU!")
                }
                "dançar" -> builder.appendLine("Marciano faz a dança do robô")
                "desconectar" -> builder.appendLine("Você quer me matar, é?")
                else -> builder.appendLine("Comando desconhecido: '$comando'")
            }
        }

        val marciano = MarcianoPremium(acao)

        val partes = input.split(" ")

        val resposta = if (partes.size == 3) {
            val operacao = partes[0].lowercase()
            val valor1 = partes[1].toDoubleOrNull()
            val valor2 = partes[2].toDoubleOrNull()

            if (valor1 != null && valor2 != null) {
                marciano.responder(operacao, valor1, valor2)
            } else {
                marciano.responder(input)
            }
        } else {
            marciano.responder(input)
        }

        builder.appendLine(resposta)

        marciano.acaoUser()

        return builder.toString().trim()
    }
}