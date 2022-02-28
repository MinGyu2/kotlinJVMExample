package com.mqchap09.section5

import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

fun main() {
    val listTest= (1..1_000_000).toList()
    println(measureNanoTime {
        listTest.map { it+1 }.filter{it%100 == 0}
    })
    println(measureNanoTime {
        listTest.asSequence().map { it+1 }.filter{it%100 == 0}.toMutableList()
    })
}