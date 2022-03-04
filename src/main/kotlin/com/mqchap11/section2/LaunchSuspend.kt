package com.mqchap11.section2

import kotlinx.coroutines.*
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext

suspend fun doWork1():String{
    delay(1000L)
    return "안녕"
}
suspend fun doWork2():String{
    delay(1000L)
    return "하이"
}

@DelicateCoroutinesApi
private fun workInSerial(){
    GlobalScope.launch {
        val one = doWork1()
        val two = doWork2()
        println("코틀린 one : $one")
        println("코틀린 two : $two")
        println(Thread.currentThread())
    }
}

/***
 * 코틀린 async로 값을 리턴 받을 수 있음 여기서 리턴 타입은 Deferred<T>
 */
@DelicateCoroutinesApi
private fun workInParallel(){
    val one = GlobalScope.async(start = CoroutineStart.LAZY) {
        println("one 스레드 : ${Thread.currentThread()}")
        doWork1()
    }
    val two = GlobalScope.async(start = CoroutineStart.LAZY) {
        println("two 스레드 : ${Thread.currentThread()}")
        doWork2()
    }
    GlobalScope.launch {
        delay(3000L)
        val combined = "${one.await()} _ ${two.await()}" // 받을 때 까지 기다림
        println("답 : $combined")
        println("출력 스레드 : ${Thread.currentThread()}")
    }
}
@DelicateCoroutinesApi
fun main() {
    val pool = Executors.newFixedThreadPool(4)
    val myContext = pool.asCoroutineDispatcher()
    GlobalScope.launch(myContext){
        println(Thread.currentThread())
    }
    workInSerial()
    workInParallel()
    readLine()
}