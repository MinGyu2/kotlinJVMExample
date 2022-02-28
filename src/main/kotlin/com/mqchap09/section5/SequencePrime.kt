package com.mqchap09.section5

import kotlin.system.measureTimeMillis

fun main() {
    val primes= generateSequence(2 to generateSequence(3){ it + 2}){
        val curseq = it.second.iterator()
        val nextPrime = curseq.next()
        nextPrime to curseq.asSequence().filter { it % nextPrime != 0 }
    }.map{it.first}
    val ttt= generateSequence { 12 }
    println("답: ${primes.take(10).toList()}")
    println("test:${ttt.take(20).toList() }")

    val test2= generateSequence(1){it+1}
//    println("${test2.take(10).toList()}")
    val tttt= test2.iterator()
    tttt.asSequence()

    val time = measureTimeMillis {
        println(tttt.next())
        println(tttt.next())
        println(tttt.next())
    }
    println(time)
}