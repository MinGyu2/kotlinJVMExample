package com.mqchap10.section1

fun main() {
    data class Person(var name:String,var skill:String)
    val person = Person("변경전","변경전 스킬")
    val a = person.apply {  // this 생략 가능
        name = "변경후1"
        this.skill = "변경후 스킬"
    }
    println("변경후 : $a $person")
    // also 랑 return 타입은 같지만 also는 it을 생략할 수 없고 apply는 this를 생략할 수 있다.
}