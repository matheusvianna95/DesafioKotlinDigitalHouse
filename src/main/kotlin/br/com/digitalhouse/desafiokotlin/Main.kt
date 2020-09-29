package br.com.digitalhouse.desafiokotlin

import java.io.ByteArrayInputStream

fun main() {
/**
 *
 * Interaja livremente com a UI ou remova os comentários do código abaixo para entrar automaticamente
 * a sequencia de comandos definida pela variável sequenciaComandos.
 *
 */
    val backupSys = System.`in`
 //   val `in` = ByteArrayInputStream(sequenciaComandos.toByteArray())
 //   System.setIn(`in`)

    val textUI = TextUI()
    textUI.start()

    System.setIn(backupSys)
}

/**
 *
 * A sequencia de comandos proposta abaixo realiza as seguintes ações:
 * * lista os comandos disponiveis
 * * registra dois professores titulares (Wagner e Jessica)
 * * registra dois professores adjuntos (Vitoria e Joao)
 * * registra dois cursos (Full Stack e Android)
 * * aloca professores no curso Full Stack (Vitoria depois Wagner) sem sucesso (titular deve preceder adjunto)
 * * aloca professores nos dois cursos (Wagner e Vitoria no Full Stack e Jessica e Joao no Android)
 * * registra cinco alunos (10001, 10002, 10003, 10004, 10005 chamados foo bar)
 * * matricula alunos 10001 e 10002 no curso Full Stack
 * * matricula alunos 10003 e 10004 no curso Android
 * * matricula aluno 10005 no curso Android sem sucesso (curso lotado)
 * * exclui aluno 10004 do curso Android
 * * matricula aluno 10005 no curso Android
 * * matricula aluno 10004 no curso Full Stack
 * * lista os cursos disponíveis
 * * matricula aluno 10004 no curso Full Stack sem sucesso (aluno já matriculado)
 * * registra um aluno sem sucesso (código deve conter apenas números)
 * * aloca professores sem sucesso (curso não cadastrado)
 * * registra um aluno sem sucesso (nome vazio)
 *
 */
val sequenciaComandos = """
    comandos
    professor
    titular
    Wagner
    Consani
    30001
    Android
    professor
    titular
    Jessica
    Correa
    30002
    Android
    professor
    adjunto
    Vitoria
    Goncalves
    40001
    10
    professor
    adjunto
    Joao
    Borges
    40002
    10
    curso
    registrar
    Full Stack
    20001
    3
    curso
    registrar
    Android
    20002
    2
    curso
    alocar
    20001
    40001
    30001
    curso
    alocar
    20001
    30001
    40001
    curso
    alocar
    20002
    30002
    40002
    aluno
    registrar
    foo
    bar
    10001
    aluno
    registrar
    foo
    bar
    10002
    aluno
    registrar
    foo
    bar
    10003
    aluno
    registrar
    foo
    bar
    10004
    aluno
    registrar
    foo
    bar
    10005
    aluno
    matricular
    10001
    20001
    aluno
    matricular
    10002
    20001
    aluno
    matricular
    10003
    20002
    aluno
    matricular
    10004
    20002
    aluno
    matricular
    10005
    20002
    aluno
    excluir
    20002
    10004
    aluno
    matricular
    10005
    20002
    aluno
    matricular
    10004
    20001
    curso
    listar
    aluno
    matricular
    10004
    20001
    aluno
    registrar
    foo
    bar
    A000B
    curso
    alocar
    20003
    30001
    40001
    aluno
    registrar

    x
""".trimIndent()
