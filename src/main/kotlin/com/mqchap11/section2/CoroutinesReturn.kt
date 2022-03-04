package com.mqchap11.section2

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@DelicateCoroutinesApi
fun main() {
    //코루틴의 상태 저장한다.
    val job = GlobalScope.launch {
        delay(1000L)
        println("세계")
    }
    println("안녕")
    println("job.isActivity = ${job.isActive} , job.isCompleted = ${job.isCompleted}")
    Thread.sleep(2000)
    println("job.isActivity = ${job.isActive} , job.isCompleted = ${job.isCompleted}")
}