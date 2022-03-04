package com.mqchap11.section4

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

val mutex = Mutex()
var counters = 0
@DelicateCoroutinesApi
fun main() = runBlocking<Unit>{
    massiveRun {
        mutex.withLock { counters++ } // 임계구역(critical section) 동시성이 안 일어남 오직 하나의 루틴만 접근 가능하다.
    }
    println("카운터 : $counters")
}