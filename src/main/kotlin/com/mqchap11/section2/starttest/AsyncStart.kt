package com.mqchap11.section2.starttest

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


suspend fun doWork1():String{
    delay(1000L)
    return "Work1"
}
suspend fun doWork2():String{
    delay(2000L)
    return "Work2"
}

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY){ doWork1() }
        val two = async(start = CoroutineStart.LAZY){ doWork2() }
        //                     1초 기다리고       2초        기다림 = 총 3초가 걸림
        println("AWAIT : ${one.await()} + ${two.await()}")
    }
    println("time : $time")
}