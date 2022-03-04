package com.mqchap11.section1

class SimpleThread:Thread(){
    override fun run() {
        println("현재 스레드: ${currentThread()}")
    }
}
class SimpleRunnable:Runnable{
    override fun run() {
        println("현재 러너블: ${Thread.currentThread()}")
    }
}
fun main() {
    val thread = SimpleThread()
    val runnable = SimpleRunnable()

    thread.start()
    Thread(runnable).start()
    Thread{
        println("현재 스레드: ${Thread.currentThread()}")
    }.start()
    object:Thread(){
        override fun run() {
            println("현재 스레드: ${currentThread()}")
        }
    }.start()
    Thread(object:Runnable{
        override fun run() {
            println("현재 러너블: ${Thread.currentThread()}")
        }
    }).start()
}