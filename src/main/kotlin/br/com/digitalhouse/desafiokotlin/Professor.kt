package br.com.digitalhouse.desafiokotlin

abstract class Professor(val nome: String, val sobrenome: String, var idProfessor: Int) {
    var tempoCasa: Int = 0

    override fun toString(): String = "(código: $idProfessor) $nome $sobrenome"
    override fun equals(other: Any?): Boolean =
        this === other || other is Professor && (other.idProfessor == this.idProfessor)

    override fun hashCode(): Int = idProfessor
}