package com.mqchap11.section2


val fibonacciSeq = sequence{
    var a = 0
    var b = 1
    yield(1)
    while (true){
        yield(a+b)
        val temp = a+b
        a = b
        b = temp
    }
}
fun main(){
    val saved = fibonacciSeq.iterator()
    println("${saved.next()} ${saved.next()} ${saved.next()}")
}