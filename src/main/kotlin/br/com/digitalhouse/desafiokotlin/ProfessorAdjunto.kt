package br.com.digitalhouse.desafiokotlin

class ProfessorAdjunto(
    nome: String,
    sobrenome: String,
    idProfessor: Int,
    var horasMonitoria: Int
) : Professor(nome, sobrenome, idProfessor)