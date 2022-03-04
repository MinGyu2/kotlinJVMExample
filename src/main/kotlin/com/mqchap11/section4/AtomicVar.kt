package com.mqchap11.section4

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

/***
 * 원자변수 이용하기 -> 매우 빠름 => 코드가 기계어로 변환되었을 때 단일 명령어로 처리하여서 굉장히 빠르다.
 */
var counter = 0 // 병행 처리 중 문제가 발생할 수 있음
var counterAtomic = AtomicInteger(0)// 원자 변수로 초기화
@DelicateCoroutinesApi
suspend fun massiveRun(action:suspend ()->Unit){
    val n = 1000
    val m = 1000
    val time = measureTimeMillis {
        val jobs = List(n){
            GlobalScope.launch {
                repeat(m){ action() }
            }
        }
        jobs.forEach { it.join() }
    }
    println("${m*n} action 걸린 시간 : $time")
}
@DelicateCoroutinesApi
fun main() = runBlocking<Unit> {
    massiveRun {
        //counter++   //증강 연산에서 무결성 문제가 발생할 수 있다. 즉 기계어로 변환하여 증가하는 동안 counter 변수가 안변한 다는 무결성을 보장 못한다.
                    //기계어로 변환되었을 때 증가하는 부분이 단일 명령어가 아니어서 무결성을 보장못한다.
        counterAtomic.incrementAndGet() // 원자변수의 멤버 메서드를 사용하여 증가시킨다.
                                        // 단일 기계어 명령으로 변환되어서 무결성을 보장한다.
    }
    println("카운터 : $counter")
    println("Atomic 카운터 : ${counterAtomic.get()}")
}