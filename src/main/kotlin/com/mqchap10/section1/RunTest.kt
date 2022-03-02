package com.mqchap10.section1

fun main() {
    data class Person(var name:String,var skill:String)
    var person = Person("이름","스킬")
    //run함수를 익명함수 처럼 사용하기
    val a = run {
        println("런 안에서 사용중 입니다.")
        "test a"
    }
    println(a)
    val b= person.run {
        name = "변경"
        "test b"
    }
    println("$b $person")
    // run 리턴은 람다함수의 마직막줄에 있는 것이다.
}