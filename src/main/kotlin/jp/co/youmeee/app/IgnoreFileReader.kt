package jp.co.youmeee.app

import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader

class IgnoreFileReader(ignoreFilePath: String, private val cd: String) {

    private var fileReader: FileReader? = null
    var files: List<File> = mutableListOf()

    init {
        try {
            fileReader = FileReader(ignoreFilePath)
        } catch(e: FileNotFoundException) {
        }
    }

    fun read() {
        fileReader?.let {
            val filesStr = it.readLines()
            files = filesStr.map {
                File("$cd/$it")
            }
        }
    }
}