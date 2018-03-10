package jp.co.youmeee.app

import java.io.File

class SearchHandler(val path: String, val langList: Array<SourceList>) {

    fun execute(){
        val rootDir = File(path)
        val files: Array<File> = rootDir.listFiles()
        doSearch(files)
    }

    private fun doSearch(files: Array<File>){
        files.map {
            if(it.isFile){
                addToList(it)
            } else if(it.isDirectory){
                doSearch(it.listFiles())
            }
        }
    }

    private fun addToList(file: File) {
        langList.map{
            if(isTargetFile(file.name, it.language.extension)){
                it.list.add(file.name)
               // println(file.name)
            }
        }
    }

    private fun isTargetFile(fileName: String, extension: String): Boolean {
        val point = fileName.lastIndexOf(".")
        val src = if(point != -1) fileName.substring(point + 1) else ""
        return src == extension
    }
}