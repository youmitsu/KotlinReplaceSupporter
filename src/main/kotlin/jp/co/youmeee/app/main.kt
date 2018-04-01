package jp.co.youmeee.app

fun main(args: Array<String>) {
    if(args.isEmpty()) {
        println("Error: Please input an argument which is a targeted directory.")
        return
    } else if(args.size >= 2) {
        println("Error: Required only argument.")
        return
    }
    val rootDirArg: String = args[0]

    val javaList = SourceList(Language("Java", "java"), false)
    val kotlinList = SourceList(Language("Kotlin", "kt"), true)

    val handler = SearchHandler(rootDirArg, arrayOf(javaList, kotlinList), importIgnoreFiles())
    val result = handler.execute()

    val logger = ResultLogger(result)
    logger.log()
}

fun importIgnoreFiles(): Array<Regex> {
    val regex = Regex("app/build/")
    return arrayOf(regex)
}
