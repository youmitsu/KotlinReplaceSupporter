package jp.co.youmeee.app

import java.io.File

class SearchHandler(
        private val path: String,
        private val langList: Array<SourceList>,
        private val ignoreDirList: MutableList<File>) {

    var sizeAll: Int = 0

    fun execute() {
        val rootDir = File(path)
        rootDir.walkTopDown().forEach { file ->
            langList.map { langList ->
                if(!isIgnoreFile(file) && isTargetFile(file, langList.language.extension)){
                    langList.add(file)
                    println(file)
                    sizeAll++
                }
            }
        }
    }

    private fun isTargetFile(file: File, extension: String): Boolean = file.extension == extension

    /**
     * 対象外ファイルを無視する
     */
    private fun isIgnoreFile(file: File): Boolean = ignoreDirList.contains(file)
}