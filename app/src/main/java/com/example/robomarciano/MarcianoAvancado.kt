package com.example.robomarciano

open class MarcianoAvancado : Marciano() {

    // Sobrecarga
    fun responder(operacao: String, valor1: Double, valor2: Double): String {
        // operacao = "some", "subtraia", "multiplique", "divida"
        val result = when (operacao.trim().lowercase()) {
            "some" -> valor1 + valor2
            "subtraia" -> valor1 - valor2
            "multiplique" -> valor1 * valor2
            "divida" -> {
                if (valor2 == 0.0)
                    return "Não posso dividir por zero"
                else valor1 / valor2
            }
            else -> return "Essa eu não sei"
        }
        return "Essa eu sei -> $result"
    }
}
