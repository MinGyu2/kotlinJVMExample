package com.mqchap11.section3

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

@ExperimentalCoroutinesApi
fun CoroutineScope.producer():ReceiveChannel<Int> = produce { // 생산자를 위한 함수
    var total = 0
    for(x in 1..5){
        total +=x
        send(total)
    }
}

@ExperimentalCoroutinesApi
fun main() = runBlocking<Unit>{
    val result = producer() // 값 생산
    result.consumeEach { println(it) } // 소비자 루틴 구성
}