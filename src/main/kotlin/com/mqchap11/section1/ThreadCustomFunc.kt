package com.mqchap11.section1

import java.util.concurrent.Executors

public fun thread(start:Boolean = false, isDaemon:Boolean = false, contextClassLoader: ClassLoader?=null, name:String?=null,priority:Int=-1,block:()->Unit):Thread{
    val thread= Thread(block)
    if(isDaemon)
        thread.isDaemon = true
    if(priority > 0)
        thread.priority = priority
    if(name != null)
        thread.name = name
    if(contextClassLoader != null)
        thread.contextClassLoader = contextClassLoader
    if(start)
        thread.start()
    return thread
}
fun main() {
    thread(false){
        println(Thread.currentThread())
        println(Thread.currentThread().isDaemon)
        println(Thread.currentThread().name)
        println(Thread.currentThread().priority)
    }

    /*** 스레드 풀 테스트
     * 스레드풀을 이용하면 스레드를 재활용할 수 있다.
    ***/
    val threadPool = Executors.newFixedThreadPool(2)
//    threadPool.execute{} // 에러가 발생하면 해당 스레드를 스레드풀에서 없애고 새로운 스레드 만듬
//    threadPool.submit {} // 에러가 발생하여도 해당 스레드를 재활용함
    threadPool.submit {
        println("Test : ${Thread.currentThread()}")
        Thread.sleep(1000)
    }
    threadPool.submit {
        println("Test2 : ${Thread.currentThread()}")
        Thread.sleep(500)
    }
    threadPool.submit {
        println("Test3 : ${Thread.currentThread()} ${1+2+3}")
        Thread.sleep(1000)
    }
    threadPool.submit {
        println("Test4 : ${Thread.currentThread()}")
        Thread.sleep(500)
    }
    threadPool.shutdown()
}