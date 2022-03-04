package com.mqchap11.section4

import kotlin.concurrent.thread

/***
 * 한 스레드에서만 변수의 값을 읽고 쓰고
 * 다른 스레드에서 변수를 읽기만 한다면
 * volatile변수가 가장 최근에 쓰여졌다는 것을 보장함
 * 스레드 끼리 값 쓰기를 보장 안함
 */
@Volatile private var running = false
private var count = 0
fun start(){
    running = true
    thread(start = true) {
        while (running) println("${Thread.currentThread()}, count : ${count++}")
    }
}
fun main() {
    start()
    start()
    Thread.sleep(10)
    running = false
}