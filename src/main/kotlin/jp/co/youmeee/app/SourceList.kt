package jp.co.youmeee.app

/**
 * 言語のlistを保持するクラス
 */
class SourceList(
        val language: Language,
        val list: MutableList<String> = mutableListOf()
)