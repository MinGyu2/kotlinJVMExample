package com.mqchap10.section3

import java.io.File
import java.io.PrintWriter

fun main() {
    val text= "테스트 입니다.\n안녕\r\n하이4"
//    val file = File("d:\\test.txt")
//    val printWriter = PrintWriter(file)
//    printWriter.println(text)
//    printWriter.close()

    File("d:\\test.txt").printWriter().use {
        it.println(text)
    }
    File("d:\\test.txt").bufferedWriter().use {
        it.write(text)
    }
}