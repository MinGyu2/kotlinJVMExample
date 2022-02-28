package com.mqchap09.section5

fun main() {
    println("fibonacci")
    val fibonacci = generateSequence(1 to 1){
        it.second to it.first+it.second
    }.map { it.first }
    println(fibonacci.take(100).toList())
}