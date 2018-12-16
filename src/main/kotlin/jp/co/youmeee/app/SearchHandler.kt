package jp.co.youmeee.app

import java.io.File

class SearchHandler(
        private val path: String,
        private val langList: Array<SourceList>,
        private val ignoreDirList: List<File>) {

    lateinit var result: Result

    fun execute() {
        var sizeAll = 0
        val rootDir = File(path)
        rootDir.walkTopDown()
                .filter {
                    isNotIgnoreFile(it)
                }.forEach { file ->
                    langList.map { langList ->
                        if(isTargetFile(file, langList.language.extension)){
                            langList.add(file)
                            println(file)
                            sizeAll++
                        }
                    }
                }
        result = Result(langList, sizeAll)
    }

    private fun isTargetFile(file: File, extension: String): Boolean = file.extension == extension

    /**
     * 対象外ファイルを無視する
     */
    private fun isNotIgnoreFile(file: File): Boolean = ignoreDirList.none {
        file.startsWith(it)
    }
}