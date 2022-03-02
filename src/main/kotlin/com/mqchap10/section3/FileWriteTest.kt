package com.mqchap10.section3

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

fun main() {
    val path = "d:\\hello.txt"
    val text = "입력입니다.\n안녕하세요"
    try {
        Files.write(Paths.get(path),text.toByteArray(),StandardOpenOption.CREATE)
    }catch (e:IOException){

    }
}