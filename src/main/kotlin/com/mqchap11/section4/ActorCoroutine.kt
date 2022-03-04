package com.mqchap11.section4

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.actor


sealed class CounterMsg{
    object IncCounter: CounterMsg() // counter 를 증가하기 위한 단방향 메시지 
    class GetCounter(val response: CompletableDeferred<Int>) : CounterMsg()  // 응답 채널의 요청
}

// 새로운 counter actor 을 위한 함수
@ObsoleteCoroutinesApi
@DelicateCoroutinesApi
fun CoroutineScope.counterActor() = actor<CounterMsg>(newSingleThreadContext("single")) {
    var counter = 0 // actor 의 상태로 공유되지 않음
    for(msg in channel){ // 들어오는 메세지 처리 // 계속 기다리나?
        when(msg){
            is CounterMsg.IncCounter -> counter++
            is CounterMsg.GetCounter -> msg.response.complete(counter)
        }
    }
}
@DelicateCoroutinesApi
@ExperimentalCoroutinesApi
@ObsoleteCoroutinesApi
fun main() = runBlocking<Unit> {
    data class Task(val desc:String)
    val me = actor<Task>(newSingleThreadContext("single1")) {
        while (!isClosedForReceive){
            println(receive().desc.repeat(10))
        }
    }
    me.send(Task("안녕"))
    me.close()

    val counter = counterActor()
    massiveRun {
        counter.send(CounterMsg.IncCounter)
    }
//    GlobalScope.launch {
//        counter.send(CounterMsg.IncCounter)
//    }
//    GlobalScope.launch {
//        counter.send(CounterMsg.IncCounter)
//    }
    val response = CompletableDeferred<Int>()
    counter.send(CounterMsg.GetCounter(response))
    println("카운터 = ${response.await()}")
    counter.close()
}