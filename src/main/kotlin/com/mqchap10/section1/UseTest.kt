package com.mqchap10.section1

import java.io.File
import java.io.FileOutputStream
import java.io.PrintWriter

fun main() {
    PrintWriter(FileOutputStream("D:\\output.txt")).use {
        it.println("출력한니다.")
        it.println("출력한니다.2")
    }
    File("D:\\output.txt").bufferedReader().use {
        println(it.readText())
    }
    //use를 사용하면 close매소드를 호출 안해도 자동으로 close 해준다.
}