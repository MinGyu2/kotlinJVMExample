package com.mqchap10.section2

data class Person(var name:String?=null,var job:Job?=null)
data class Job(var category: String?=null,var position:String?=null)

inline fun person(block:Person.()->Unit):Person=Person().apply(block)
fun Person.job(block:Job.()->Unit){
    job = Job().apply(block)
}
fun main() {
    val person = person {
        name = "테스트"
        job { 
            category = "안녕"
            position = "나의 포지션"
        }
    }
    println(person)
    val rrr:Int.()->Int = {this*1000}
    val a = 11
    println(a.rrr())
}