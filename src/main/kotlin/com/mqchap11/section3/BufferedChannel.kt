package com.mqchap11.section3

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val channel = Channel<Int>(3)   // 버퍼크기를 3으로 준다.
    val sender = launch {   // 송신자
        repeat(10){
            println("$it 보내기")
            channel.send(it)    // 지속적으로 보내기 꽉 차면 못보냄
        }
    }
    delay(1000)
    sender.cancel() // 송신자의 작업 취소하기
}