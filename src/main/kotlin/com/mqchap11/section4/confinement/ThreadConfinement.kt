package com.mqchap11.section4.confinement

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis

/***
 * 스레즈 가두기
 */
@DelicateCoroutinesApi
val couterContext = newSingleThreadContext("CounterContext")    // 단일 스레드 문맥을 선언
var counter = 0

@DelicateCoroutinesApi
suspend fun massiveRun(context:CoroutineContext, action:suspend ()->Unit){
    val n = 1000
    val m = 1000
    val time = measureTimeMillis {
        val jobs = List(n){
            GlobalScope.launch(context) {
                repeat(m) { action() }
            }
        }
        jobs.forEach { it.join() }
    }
    println("${m*n} action 걸린시간 : $time")
}
@DelicateCoroutinesApi
suspend fun massiveRun2(action:suspend ()->Unit){
    val n = 1000
    val m = 1000
    val time = measureTimeMillis {
        val jobs = List(n){
            GlobalScope.launch{
                repeat(m) { action() }
            }
        }
        jobs.forEach { it.join() }
    }
    println("${m*n} action 걸린시간 : $time")
}
@DelicateCoroutinesApi
fun main() = runBlocking<Unit> {
    massiveRun(couterContext){
        counter++
    }
    massiveRun2{
        withContext(couterContext){
            counter++
        }
    }
    println("카운터 : $counter")
}
/***
 * Atomic 변수가 스레드 가두기 보다 더 빠르다고 했는데
 * 스레드 가두기로 하나의 스레드에서 코루틴을 사용하여 카운터 하였을 때가 더 빠르다.
 * withContext를 사용하면 느림
 */

