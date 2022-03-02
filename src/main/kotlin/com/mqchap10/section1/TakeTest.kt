package com.mqchap10.section1

import kotlin.system.measureTimeMillis

fun main() {
    data class Person(var name:String,var skill:String)
    val person = Person("이름","스킬")
    val a = person.takeIf {
        it.name = "변경1"
        true
    }
    println(a)
    val b = person.takeIf {
        false
    }
    println(b)


    val a2 = person.takeUnless {
        it.name = "변경2"
        false
    }
    println(a2)
    val b2 = person.takeUnless {
        true
    }
    println(b2)
}