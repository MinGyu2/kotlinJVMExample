package com.mqchap10.section1

import kotlin.contracts.contract

fun lambdaReturn():(Int)->Unit{
    var result= 100;// 외부변수
    return {x->
        result *= x
        println("$result + $x") // 클로저 외부변수 캡처해서 사용함
    }
}
fun main() {
    val z= lambdaReturn()
    z(2)
    val s = ""
    val z2 = s.let{
        "바보"
        1
    }.apply {
    }.inc()
    println(z2)
}