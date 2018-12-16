package jp.co.youmeee.app

import java.io.File
import java.io.FileReader

class IgnoreFileReader(ignoreFilePath: String, private val cd: String): FileReader(ignoreFilePath) {

    var files: List<File> = mutableListOf()

    override fun read(): Int {
        val filesStr = readLines()
        files = filesStr.map {
            File("$cd/$it")
        }
        return if (files.isEmpty()) -1 else 1
    }
}