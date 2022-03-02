package com.mqchap10.section3

import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileReader
import java.io.IOException
import java.io.InputStreamReader

fun main() {
    val path = "d:\\test.txt"
    try{
        val read = FileReader(path)
        println(read.readText())
    }catch (e:IOException){
        println(e.message)
    }
    println()
    println()

    BufferedReader(InputStreamReader(FileInputStream(File(path)))).useLines {
        it.forEach { println(it) }
    }
    File(path).bufferedReader().use {
        it.lineSequence().forEach {
            println("test : $it")
        }
    }
    val br = BufferedReader(InputStreamReader(File(path).inputStream()))
    try{
        var line = br.readLine()
        while (line != null){
            println(line)
            line = br.readLine()
        }
    }catch (e:IOException){

    }finally {
        br.close()
    }


    val sb = StringBuilder()
    File(path).bufferedReader().useLines { lines->
        lines.forEach { sb.append(it) }
    }
    println(sb)

    System.`in`.bufferedReader().useLines { lines->
        lines.forEach { sb.append("$it\n") }
    }
    File(path).copyTo(File("d:\\copy.txt"))
    println(sb)
}