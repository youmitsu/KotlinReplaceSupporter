package jp.co.youmeee.app

import java.io.File

fun main(args: Array<String>) {
    val homeDir = System.getProperty("user.home") ?: ""
    val cd = File(".").absoluteFile.parent

    val javaList = SourceList(Language("Java", "java"), false)
    val kotlinList = SourceList(Language("Kotlin", "kt"), true)

    val ignoreFileReader = IgnoreFileReader("$homeDir/.krsignore", cd)
    ignoreFileReader.read()

    val handler = SearchHandler(cd, arrayOf(javaList, kotlinList), ignoreFileReader.files)
    handler.execute()

    val logger = ResultLogger(handler.result)
    logger.log()
}