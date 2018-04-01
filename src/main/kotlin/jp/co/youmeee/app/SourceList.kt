package jp.co.youmeee.app

import java.io.File

/**
 * 言語のlistを保持するクラス
 */
class SourceList(
        val language: Language,
        val isReplace: Boolean,
        val list: MutableList<File> = mutableListOf()) {
    fun add(file: File){
        list.add(file)
    }
}