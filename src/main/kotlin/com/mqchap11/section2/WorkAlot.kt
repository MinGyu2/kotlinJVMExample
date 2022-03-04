package com.mqchap11.section2

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main(){
    val time = measureTimeMillis {
        runBlocking {
            val jobs = List(100_000){
                launch {
                    delay(1000L)
//                    print(".")
                }
            }
            repeat(100_000){
                launch {
                    delay(1000L)
//                    print("#")
                }
            }
            repeat(100_000){
                launch {
                    delay(1000L)
//                    print("#")
                }
            }
            println("안녕")
        }
    }
    println()
    println("끝 걸린시간 : $time")
}