package jp.co.youmeee.app

import java.math.BigDecimal
import java.math.RoundingMode

class ResultLogger(val result: Result) {

    fun log() {
        logCount()
        logReplaceRate()
    }

    private fun logCount() = result.arr.forEach { it ->
        println("---------${it.language}---------")
        println("ファイル数：${it.list.size}")
    }

    private fun logReplaceRate() = println("リプレース率：${calcReplaceRate()} %")

    private fun calcReplaceRate(): Double {
        val value: Double = result.arr.filter{sl -> sl.isReplaceTarget}.map{ it.list.size / result.sizeAll.toDouble() * 100.0 }.first()
        return BigDecimal(value).setScale(1, RoundingMode.HALF_UP).toDouble()
    }

}