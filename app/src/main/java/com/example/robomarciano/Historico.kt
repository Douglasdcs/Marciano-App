package com.example.robomarciano

object Historico {
    private val comandos = mutableListOf<String>()

    fun adicionar(comando: String) {
        comandos.add(comando)
    }

    fun listar(): List<String> = comandos.toList()
}