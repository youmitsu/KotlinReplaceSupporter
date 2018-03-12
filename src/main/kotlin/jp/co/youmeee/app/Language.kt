package jp.co.youmeee.app

/**
 * 言語の情報を保持するクラス
 *
 */
data class Language(
        val name: String,  //言語名
        val extension: String //拡張子
        ){
        override fun toString() = name
}