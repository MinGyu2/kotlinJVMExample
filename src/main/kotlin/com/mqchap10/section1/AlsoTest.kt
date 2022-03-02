package com.mqchap10.section1

fun main() {
    data class Person(var name:String,var age:Int)
    val person = Person("test1",12)
    println("변경전 : $person")
    val a = person.let {
        it.name = "변경"
        it.age = 13
        "성공함"
    }
    println("변경후 : $a $person")

    val b = person.also {
        it.name = "변경2"
        it.age = 14
    }
    println("변경후 : $b $person")
    // let 과 also 의 차이는 return 값에 따라 다르다.
}