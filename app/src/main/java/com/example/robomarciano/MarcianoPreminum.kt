package com.example.robomarciano

class MarcianoPremium(private val acao: Acao) : MarcianoAvancado() {
    // ação do usuário poderá ser passada como parâmetro da classe usando uma interface
    // definida na instanciação da versão premium do robô.

    var comandoSalvo: String? = null;

    override fun responder(frase: String): String {
        if ("agir" in frase.trim().lowercase()) {
//            println("aqui!")
            comandoSalvo= frase.trim().substringAfter("agir", "").trim()
            return "É pra já!"
        }
        // superclasse
        return super.responder(frase)
    }

    fun acaoUser() {
        comandoSalvo?.let {
            if (!it.isBlank()) {
                acao.executarAcao(it)
            }
            comandoSalvo = null
        }
    }

}
