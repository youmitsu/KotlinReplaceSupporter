package jp.co.youmeee.app

fun main(args: Array<String>) {
    if(args.isEmpty()) {
        println("Error: Please input an argument which is a targeted directory.")
        return
    } else if(args.size >= 2) {
        println("Error: Required one argument.")
        return
    }
    val rootDirArg: String = args[0]

    //TODO: SourceListクラスでラップする必要ない説
    val javaList = SourceList(Language("Java", "java"))
    val kotlinList = SourceList(Language("Kotlin", "kt"))

    //TODO: 無視するディレクトリを読み込む、無視する処理必要
    val handler = SearchHandler(rootDirArg, arrayOf(javaList, kotlinList))
    handler.execute()

    //TODO: Loggerクラス作る
    println("------${javaList.language}------")
    println("ファイル数: ${javaList.list.size}")
    println("------${kotlinList.language}------")
    println("ファイル数: ${kotlinList.list.size}")
    println("リプレース率: ${kotlinList.list.size / handler.sizeAll.toDouble() * 100.0} %")
}

