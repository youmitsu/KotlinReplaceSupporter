package jp.co.youmeee.app

class ResultLogger(val result: Result) {

    fun log() {
        logCount()
        logReplaceRate()
    }

    private fun logCount() = result.arr.map { sl ->
        println("---------${sl.language}---------")
        println("ファイル数：${sl.list.size}")
    }

    private fun logReplaceRate() = println("リプレース率：${calcReplaceRate()}%")

    private fun calcReplaceRate(): Double = result.arr.filter { sl -> sl.isReplace }.size / result.sizeAll.toDouble() * 100.0
}