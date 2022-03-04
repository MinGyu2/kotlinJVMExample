package com.mqchap11.section3

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val channel = Channel<Int>()
    launch {
        for(x in 1 .. 5) channel.send(x*x)
    }
    repeat(5){
        println(channel.receive())
    }
    println("끝!")

    // 채널 닫기 이용
    val channel2 = Channel<Int>()
    launch {
        for(x in 1..5) channel2.send(x)
        channel2.close()
    }
    for(e in channel2) println(e)
}