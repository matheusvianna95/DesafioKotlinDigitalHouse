package br.com.digitalhouse.desafiokotlin

import java.util.*

data class Matricula(val aluno: Aluno, val curso: Curso) {
    val data = Date()

    override fun toString(): String = "$aluno - $curso - $data"
    override fun equals(other: Any?): Boolean =
        this === other || other is Matricula && (other.aluno == this.aluno && other.curso == this.curso)

    override fun hashCode(): Int {
        var result = aluno.hashCode()
        result = 31 * result + curso.hashCode()
        return result
    }
}