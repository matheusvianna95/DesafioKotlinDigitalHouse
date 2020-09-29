package br.com.digitalhouse.desafiokotlin

import java.lang.StringBuilder

class DigitalHouseManager {
    val listaAlunos = mutableMapOf<Int, Aluno>()
    val listaProfessores = mutableMapOf<Int, Professor>()
    val listaCursos = mutableMapOf<Int, Curso>()
    val listaMatriculas = mutableListOf<Matricula>()

    fun registrarCurso(nome: String, idCurso: Int, capacidadeAlunos: Int): Boolean =
        listaCursos.putIfAbsent(idCurso, Curso(nome, idCurso, capacidadeAlunos)) == null

    fun excluirCurso(idCurso: Int): Boolean = listaCursos.remove(idCurso) != null

    fun listarCursos(): String {
        val str = StringBuilder().append("\n")
        listaCursos.forEach { str.append("\n${it.value}\n") }
        return str.toString()
    }

    fun registrarProfessorAdjunto(nome: String, sobrenome: String, idProf: Int, horasMonitoria: Int): Boolean =
        listaProfessores.putIfAbsent(idProf, ProfessorAdjunto(nome, sobrenome, idProf, horasMonitoria)) == null

    fun registrarProfessorTitular(nome: String, sobrenome: String, idProf: Int, especialidade: String): Boolean =
        listaProfessores.putIfAbsent(idProf, ProfessorTitular(nome, sobrenome, idProf, especialidade)) == null

    fun excluirProfessor(idProf: Int): Boolean = listaCursos.remove(idProf) != null

    fun registrarAluno(nome: String, sobrenome: String, idAluno: Int): Boolean =
        listaAlunos.putIfAbsent(idAluno, Aluno(nome, sobrenome, idAluno)) == null

    fun matricularAluno(idAluno: Int, idCurso: Int): String {
        val aluno = listaAlunos.getOrElse(idAluno) { return "Aluno não encontrado." }
        val curso = listaCursos.getOrElse(idCurso) { return "Curso não encontrado" }
        val matricula = Matricula(aluno, curso)
        if (listaMatriculas.contains(matricula)) return "Aluno já matriculado."
        if (!curso.adicionarAluno(aluno)) return "Não há mais vagas no curso."
        else listaMatriculas.add(matricula)
        return "Matrícula realizada com suceso."
    }

    fun alocarProfessores(idCurso: Int, idTitular: Int, idAdjunto: Int): String {
        val titular = listaProfessores.getOrElse(idTitular) { return "Professor titular não encontrado." }
        val adjunto = listaProfessores.getOrElse(idAdjunto) { return "Professor adjunto não encontrado." }
        val curso = listaCursos.getOrElse(idCurso) { return "Curso não encontrado." }
        if (titular !is ProfessorTitular || adjunto !is ProfessorAdjunto) return "Divergência nos dados dos professores."
        curso.professorTitular = titular
        curso.professorAdjunto = adjunto
        return "Professores alocados com sucesso."
    }

}
