package com.mqchap11.section3

import kotlinx.coroutines.*

@DelicateCoroutinesApi
fun main():Unit = runBlocking {
    val jobs = ArrayList<Job>()
    jobs += launch(Dispatchers.Unconfined) { // main 스레드풀 사용안함
        println("Unconfined : ${Thread.currentThread()}")
    }
    jobs += launch(coroutineContext){ // main
        println("coroutineContext : ${Thread.currentThread()}")
    }
    jobs += launch{ // main
        println("main runBlocking : ${Thread.currentThread()}")
    }
    jobs += launch(Dispatchers.Default){ // 원래 있는 스레드
        println("Dispatchers.Default : ${Thread.currentThread()}")
    }
    jobs += launch(Dispatchers.IO){ // 원래 있는 스레드
        println("Dispatchers.IO : ${Thread.currentThread()}")
    }
    jobs += launch(newSingleThreadContext("MyThread")){
        println("My Thread : ${Thread.currentThread()}")
    }
    jobs += launch(newSingleThreadContext("MyThread2")){
        println("My Thread2 : ${Thread.currentThread()}")
    }
    jobs.forEach{ it.join() }
    println("main")
    println()
    println()

    val job = GlobalScope.launch {
        try{
            repeat(1000){i->
                println("sleep : $i")
                delay(500)
            }
        }finally {
            withContext(NonCancellable){
                delay(1000L)
                println("Bye!!!!!")
            }
        }

    }
    delay(1400L)
    job.cancelAndJoin()
    println("?main quit!")
    println()
    println()

    val start = System.currentTimeMillis()
    val job2 = GlobalScope.launch {
        var nextTime = start
        var i = 0
        while(isActive){//(i < 5){
            if(System.currentTimeMillis() >= nextTime){
                println("잠잔다 ${i++}")
                nextTime += 500L
            }
        }
    }
    delay(1400L)
    println("취소")
    job2.cancelAndJoin()
    println()
    println()

    try{
        withTimeout(1300L){
            repeat(1000){
                println("자는중2 : $it")
                delay(500L)
            }
        }
    }catch (e:TimeoutCancellationException){
        println("타임아웃 : $e")
    }
    println("마지막 줄")
}