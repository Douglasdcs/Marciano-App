package com.example.robomarciano

open class Marciano : MarcianoInterface {

    override fun responder(frase: String): String{

        val texto = frase.trim() // contante para guardar valor sem espaço

        if (texto.isEmpty()) {
            return "Não me incomode"
        }

        val isPergunta = texto.contains("?")

        val hasPalavraEmCaps = texto.split("\\s+".toRegex()).any { palavra ->
            palavra.length > 1 && palavra == palavra.uppercase()
        } // Faz um split em espaços em branco e verifica se tem palavras em maíúsculo (Considera apenas len > 1)

        val hasEu = texto.contains("EU", ignoreCase = true)

        return when {
            hasEu -> "A responsabilidade é sua"
            isPergunta && hasPalavraEmCaps -> "Relaxa, eu sei o que estou fazendo!"
            isPergunta -> "Certamente"
            hasPalavraEmCaps -> "Opa! Calma aí!"
            else -> "Tudo bem, como quiser"
        }
    }
}