package com.mqchap09.section5

import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

fun main() {

    val primes= generateSequence(2 to generateSequence(3){ it + 2}){
        val curseq = it.second.iterator()
        val nextPrime = curseq.next()
        nextPrime to curseq.asSequence().filter { it % nextPrime != 0 }
    }.map{it.first}

//    println("답: ${primes.take(10).toList()}")
//    println("답: ${primes.take(30).toList()}")
//    println("${primes.iterator().next()}")

//    val test = generateSequence(1){it+1}.filter { it%2 != 0 }.filter { it%3 !=0 }
//    val tt= measureTimeMillis {
//        test.take(20000000).toList()
//    }
//    val tt2= measureTimeMillis{
//        run {
//            test.forEachIndexed{
//                idx,i->
//                if(idx == 20000000) return@run
//            }
//        }
//    }
//    println(tt2)
//    println("시간 : "+measureTimeMillis {
//        println(primes.take(17000).toList().last())
//    })
//    println("시간: ${measureTimeMillis {
//        run{
//            primes.forEachIndexed { index, i ->
//                if(index == 17000){
//                    println("$index : $i")
//                    return@run
//                }
//            }
//        }
//    }}")


    Runtime.getRuntime().gc()
    val useMemory = Runtime.getRuntime().totalMemory()- Runtime.getRuntime().freeMemory()
    println("$useMemory byte")
//    test.forEach {
//        println(it)
//    }
    
    // This sequence can be consumed only once. 에러 발생함
//    val test2 = generateSequence { 10 }
//    println("${test2.take(10).toList()}")
//    test2.forEach {
//        println(it)
//    }
}