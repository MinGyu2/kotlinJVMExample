package com.mqchap11.section3

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.selects.select
import kotlin.random.Random

@ExperimentalCoroutinesApi
@DelicateCoroutinesApi
fun main()= runBlocking<Unit> {
    val routine1 = GlobalScope.produce {
        delay(Random(System.currentTimeMillis()).nextLong(1000))
        send("A")
    }
    val routine2 = GlobalScope.produce{
        delay(Random(System.currentTimeMillis()).nextLong(1000))
        send("B")
    }
    val result = select<String> { //먼저 수행된 것을 받게 된다.
        routine1.onReceive{it}
        routine2.onReceive{it}
    }
    println(result)
}