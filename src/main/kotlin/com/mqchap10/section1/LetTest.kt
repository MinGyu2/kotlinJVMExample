package com.mqchap10.section1

fun main() {
    val t=10
    val s = t.let {
        String.format("%d 안녕 ${it*100}",it*100)
    }
    println(s)
}