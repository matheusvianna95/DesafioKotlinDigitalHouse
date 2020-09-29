package br.com.digitalhouse.desafiokotlin

data class Curso(
    val nome: String,
    val idCurso: Int,
    val capacidadeAlunos: Int,
) {
    val listaAlunos = mutableListOf<Aluno>()
    var professorTitular: ProfessorTitular? = null
    var professorAdjunto: ProfessorAdjunto? = null

    fun adicionarAluno(aluno: Aluno): Boolean =
        if (listaAlunos.lastIndex >= capacidadeAlunos - 1) false else listaAlunos.add(aluno)

    fun excluirAluno(aluno: Aluno): Boolean = listaAlunos.remove(aluno)

    override fun toString(): String = """
        curso: (código: $idCurso) $nome
        professores: $professorTitular e $professorAdjunto
        capacidade: ${listaAlunos.lastIndex + 1}/$capacidadeAlunos
        alunos: $listaAlunos
    """.trimIndent()

    override fun equals(other: Any?): Boolean = this === other || other is Curso && (other.idCurso == this.idCurso)
    override fun hashCode(): Int = idCurso
}