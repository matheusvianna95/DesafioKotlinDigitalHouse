package br.com.digitalhouse.desafiokotlin

class ProfessorTitular(
    nome: String,
    sobrenome: String,
    idProfessor: Int,
    val especialidade: String
) : Professor(nome, sobrenome, idProfessor)