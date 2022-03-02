package com.mqchap10.section1

fun main() {
    data class Person(var name:String,var skill:String)
    val person = Person("이름","스킬")
    val a = with(person){
        name = "변경"
        skill = "스킬ㄹㄹㄹ변경"
        "변경 완료"
    }
    println("$a $person")
}