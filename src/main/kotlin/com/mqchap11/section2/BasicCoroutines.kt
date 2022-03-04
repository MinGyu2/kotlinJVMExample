package com.mqchap11.section2

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

suspend fun test(){
    println("suspend(중단)가능한 함수 입니다.")
}
class Test constructor(var a:Int){
    operator fun plus(b:Test):Int{
        return a+b.a
    }
}
//@DelicateCoroutinesApi
fun main(){
    runBlocking { // main 스레드에서 동작 한다.
        launch {
            delay(1000)
            test()
            println("코루틴 : ${Thread.currentThread()}")
        }
        GlobalScope.launch {
            delay(5000)
            println("코루틴2 : ${Thread.currentThread()}")
        }
        test()
        println(Thread.currentThread())
    }
    println("안녕")
    println("하이루")
    val t:Test = Test(10)
    println("${t + Test(30)}")
    Thread.sleep(4000)
}