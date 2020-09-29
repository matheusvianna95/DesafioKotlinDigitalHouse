package br.com.digitalhouse.desafiokotlin

import java.lang.Exception

class TextUI {
    private val dhManager = DigitalHouseManager()

    fun start() {
        println(
            """
            Bem vindo ao sistema de gerenciamento da Digital House!
            Entre um comando ou "comandos" para exibir a lista de comandos.
            Para encerrar o programa, entre "x".
        """.trimIndent()
        )

        while (true) {
            val comando = readLine()
            if (comando == "x") {
                println("Programa encerrado.")
                break
            }
            gerenciadorComandos(comando)
            println("\nEntre um comando ou \"comandos\" para exibir a lista de comandos.")
        }
    } // start

    private fun gerenciadorComandos(comando: String?) {
        when (comando) {
            "comandos" -> {
                println(
                    """
                    Lista de comandos:
                    "curso" para alocar professores, registrar, excluir ou listar cursos disponíveis.
                    "professor" para registrar ou excluir professores titulares ou adjuntos.
                    "aluno" para registrar, excluir ou matricular um aluno em um curso.
                """.trimIndent()
                )
            }
            "curso" -> println(comandoCurso())
            "professor" -> println(comandoProfessor())
            "aluno" -> println(comandoAluno())
            else -> println("Comando inválido.")
        } // comando
    }

    private fun comandoCurso(): String {
        println("Deseja \"alocar\" professores à um curso, \"registrar\" ou \"excluir\" um curso ou \"listar\" os cursos disponíveis?")

        when (readLine()) {
            "registrar" -> {
                println("Entre o nome do curso:")
                val nome = validarEntradaTextual(readLine()) ?: return "Nome inválido."
                println("Entre o código do curso:")
                val idCurso = validarEntradaNumerica(readLine()) ?: return "Código inválido."
                println("Entre a capacidade de alunos:")
                val capacidadeAlunos = validarEntradaNumerica(readLine()) ?: return "Capacidade inválida."
                return if (dhManager.registrarCurso(
                        nome,
                        idCurso,
                        capacidadeAlunos
                    )
                ) "Curso cadastrado com sucesso."
                else "Já existe um curso cadastrado com esse código."
            } // registrar curso

            "excluir" -> {
                println("Entre o código do curso a ser excluído:")
                val idCurso = validarEntradaNumerica(readLine()) ?: return "Curso inválido"
                return if (dhManager.excluirCurso(idCurso)) "Curso excluído com sucesso."
                else "Não existe um curso com esse código."
            } // excluir curso

            "alocar" -> {
                println("Entre o código do curso:")
                val idCurso = validarEntradaNumerica(readLine()) ?: return "Curso inválido."
                println("Entre o código do professor titular:")
                val idTitular = validarEntradaNumerica(readLine()) ?: return "Código inválido."
                println("Entre o código do professor adjunto:")
                val idAdjunto = validarEntradaNumerica(readLine()) ?: return "Código inválido."
                return dhManager.alocarProfessores(idCurso, idTitular, idAdjunto)
            } // alocar professores

            "listar" -> {
                return dhManager.listarCursos()
            }

            else -> {
                return "Entrada inválida."
            }
        }
    } // curso

    private fun comandoProfessor(): String {
        println("Deseja registrar um professor \"titular\", registrar um professor \"adjunto\" ou \"excluir\" um professor?")

        when (readLine()) {
            "titular" -> {
                println("Entre o nome do professor:")
                val nome = validarEntradaTextual(readLine()) ?: return "Nome inválido."
                println("Entre o sobrenome do professor:")
                val sobrenome = validarEntradaTextual(readLine()) ?: return "Sobrenome inválido."
                println("Entre o código do professor:")
                val idProfessor = validarEntradaNumerica(readLine()) ?: return "Código inválido."
                println("Entre a especialidade do professor:")
                val especialidade = validarEntradaTextual(readLine()) ?: return "Especialidade inválida."
                return if (dhManager.registrarProfessorTitular(
                        nome,
                        sobrenome,
                        idProfessor,
                        especialidade
                    )
                ) "Professor titular cadastrado com sucesso."
                else "Já existe um professor cadastrado com esse código."
            } // professor titular

            "adjunto" -> {
                println("Entre o nome do professor:")
                val nome = validarEntradaTextual(readLine()) ?: return "Nome inválido."
                println("Entre o sobrenome do professor:")
                val sobrenome = validarEntradaTextual(readLine()) ?: return "Sobrenome inválido"
                println("Entre o código do professor:")
                val idProfessor = validarEntradaNumerica(readLine()) ?: return "Código inválido."
                println("Entre a quantidade de horas disponíveis para monitoria:")
                val horasMonitoria = validarEntradaNumerica(readLine()) ?: return "Entrada inválida."
                return if (dhManager.registrarProfessorAdjunto(
                        nome,
                        sobrenome,
                        idProfessor,
                        horasMonitoria
                    )
                ) "Professor adjunto cadastrado com sucesso."
                else "Já existe um professor cadastrado com esse código."
            } // professor adjunto

            "excluir" -> {
                println("Entre o código do professor a ser excluído:")
                val idProfessor = validarEntradaNumerica(readLine()) ?: return "Código inválido."
                return if (dhManager.excluirProfessor(idProfessor)) "Professor excluído com sucesso."
                else "Não existe um professor com esse código."
            } // excluir professor

            else -> {
                return "Entrada inválida."
            }
        }
    } // professor

    private fun comandoAluno(): String {
        println("Deseja \"registrar\" um aluno, \"matricular\" em ou \"excluir\" um aluno de um curso?")

        when (readLine()) {
            "registrar" -> {
                println("Entre o nome do aluno:")
                val nome = validarEntradaTextual(readLine()) ?: return "Nome inválido."
                println("Entre o sobrenome:")
                val sobrenome = validarEntradaTextual(readLine()) ?: return "Sobrenome inválido."
                println("Entre o código do aluno:")
                val idAluno = validarEntradaNumerica(readLine()) ?: return "Código inválido."
                return if (dhManager.registrarAluno(
                        nome,
                        sobrenome,
                        idAluno
                    )
                ) "Aluno cadastrado com sucesso."
                else "Já existe um aluno cadastrado com esse código."
            } // registrar aluno

            "matricular" -> {
                println("Entre o código do aluno:")
                val idAluno = validarEntradaNumerica(readLine()) ?: return "Código inválido."
                println("Entre o código do curso:")
                val idCurso = validarEntradaNumerica(readLine()) ?: return "Código inválido."
                return dhManager.matricularAluno(idAluno, idCurso)
            } // matricular aluno

            "excluir" -> {
                println("Entre o código do curso:")
                val idCurso = validarEntradaNumerica(readLine()) ?: return "Código inválido."
                println("Entre o código do aluno:")
                val idAluno = validarEntradaNumerica(readLine()) ?: return "Código inválido."
                if (dhManager.listaCursos.getOrElse(idCurso) { return "Não existe curso com esse código." }
                        .excluirAluno(dhManager.listaAlunos.getOrElse(idAluno) { return "Não existe aluno com esse código." })) {
                    return "Aluno excluído com sucesso."
                } else return "Dados inválidos."
            } // excluir aluno

            else -> {
                return "Entrada inválida."
            }
        }
    } // aluno

    private fun validarEntradaNumerica(numero: String?): Int? {
        try {
            return numero?.toInt()
        } catch (ex: Exception) {
            return null
        }
    }

    private fun validarEntradaTextual(texto: String?): String? {
        return if (texto == null || texto.isEmpty() || texto.length > 35) null else texto
    }

} // TextUI
