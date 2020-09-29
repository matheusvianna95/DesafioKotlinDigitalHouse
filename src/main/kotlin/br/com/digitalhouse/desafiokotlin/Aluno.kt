package br.com.digitalhouse.desafiokotlin

data class Aluno(val nome: String, val sobrenome: String, val idAluno: Int) {
    override fun toString(): String = "(id: $idAluno) $nome $sobrenome"
    override fun equals(other: Any?): Boolean = this === other || other is Aluno && (other.idAluno == this.idAluno)
    override fun hashCode(): Int = idAluno
}
