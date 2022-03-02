package com.test.mq

import java.util.Objects
import kotlin.reflect.KClass

//import java.math.BigInteger
//class Box<out T:A>(val tt:T){
//    fun g():T{
//        return tt
//    }
////    fun a(z:T){
////        tt = z
////    }
//}
//open class A()
//class B():A(){
//    fun test(){}
//}
//class Test{
//    fun factorial(v:BigInteger):BigInteger{
//        return if(v<= BigInteger.ONE) BigInteger("1") else v*this.factorial(v-BigInteger.ONE)
//    }
//    fun fibonacci(count:BigInteger):BigInteger{
//        return if(count<= BigInteger.TWO) BigInteger.ONE else fibonacci(count)+fibonacci(count - BigInteger.ONE)
//    }
//}
//fun factorial(v:Int):Int{
//    return if(v<=1) 1 else v*factorial(v-1)
//}
//fun <T> test(a:T, z:(T)->T) where T:Number{
//    println(z(a))
//}
//fun vvv(b:Box<A>){
//}
//
//class test<in T,out U>(t:T,u:U){
////    val tt:T=t
//    val uu:U=u
//    fun setT(t:T){
//    }
//    fun getU():U{
//        return uu
//    }
//}
//fun sss(v:test<*,*>){
////    v.setT(1)
//    val a=v.uu
//}
//fun <T> aa(a:Class<T>){
//    for(k in a.methods)
//        println(k)
//}
//inline fun <reified T> bb(){
//    println(T::class.java)
//    println(T::class)
//    for(k in T::class.java.methods){
//        println(k)
//    }
////    print(T::class.isFinal)
//}
data class Minq(val data:String,val l:()->Int)
fun <T> ttt(a:Class<T>){
    for(b in a.methods) println(b)
}
inline fun <reified T> test2(){
    for(b in T::class.java.methods){
        println(b)
    }
}
fun main(){
//    val iaa= BigInteger("12")
//    iaa.times(iaa)
////    val a = readLine()?.toInt() ?: 1
////    val re= factorial(a)
////    println("안녕 ! : $re ${Test().factorial(BigInteger(a.toString()))} ${Test().fibonacci(BigInteger(a.toString()))}")
//    test(23.3,{it*2})
//
//    val a:Box<A> = Box<B>(B())
//    vvv(Box<B>(B()))
//    aa(B::class.java)

//    val d = Minq("test") { 1 * 2 * 3 }
//    val a=10
//    val f:()->String = object : Function0<String>{
//        override fun invoke(): String {
//            return "test"
//        }
//    }
//    val f2:()->String= {"test"}

//    ttt(Minq::class.java)
//    test2<Minq>()
//    readLine()!!.toIntOrNull()?:0
    val test:StringBuilder= StringBuilder("테스트입니다.")
    println("$test : ${test.length}")
    test.append('\b')
    test.append('\b')
    test.append('\b')
    test.append("\uAC00")
    println("$test : ${test.length}")
    var s="테스트2입니다."
    println("$s : ${s.length}")
    s += "\b"
    println("$s : ${s.length}")
}