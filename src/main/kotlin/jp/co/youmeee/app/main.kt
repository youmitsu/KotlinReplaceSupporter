package jp.co.youmeee.app

fun main(args: Array<String>) {
    println(System.getProperty("user.dir"))
    val rootDirArg: String = args[0]
    if(rootDirArg.isEmpty()) return

    val javaList = SourceList(Language("Java", "java"))
    val kotlinList = SourceList(Language("Kotlin", "kt"))

    val handler = SearchHandler(rootDirArg, arrayOf(javaList, kotlinList))
    handler.execute()
    val sizeAll = (javaList.list.size + kotlinList.list.size).toDouble()
//    println(javaList.list.size)
//    println(kotlinList.list.size)
    println("------Java------")
    println("ファイル数: ${javaList.list.size}")
    println("------Kotlin------")
    println("ファイル数: ${kotlinList.list.size}")
    println("リプレース率: ${kotlinList.list.size / sizeAll * 100.0} %")
}

