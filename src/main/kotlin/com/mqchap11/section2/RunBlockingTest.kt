package com.mqchap11.section2

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    launch { // 백그라운드로 코루틴 실행함
        delay(500L)
        println("세계 : ${Thread.currentThread()}")
    }
    launch {
        delay(500L)
        println("세계2 : ${Thread.currentThread()}")
    }
    val job = launch(Dispatchers.Default){
        delay(2000L)
        println(Thread.currentThread())
    }
    job.join()
    println("안녕 : ${Thread.currentThread()}") // 즉시 실행 됨
    // delay 안해도 코루틴 끝날때 까지 기다림
}