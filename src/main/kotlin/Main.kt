import kotlin.properties.Delegates

//@file:JvmName("TTTT")
//import kotlin.properties.Delegates
//
//class ZZZ(var z:Int){
//    init {
//        ZZZ.a++
//    }
//    companion object{
//        var a=0
//            private set
//        fun plt(){
//            println(ZZZ.a)
//        }
//    }
//    fun b(){
//        println(ZZZ.a)
//    }
//    private fun c()= object {
//        val x="x"
//    }
//    fun d()= object {
//        val x="x"
//    }
//    fun e(){
//        val ss=c().x
//    }
//}
interface cccc{
    fun zzzz()
}
fun main(args: Array<String>) {
//    println("Hello World!")
//    // Try adding program arguments via Run/Debug configuration.
//    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
//    println("Program arguments: ${args.joinToString()}")
//    val test="test"
//    val buf:StringBuffer
//    var a by Delegates.vetoable(10){
//            p,old,new->
//        old > new
//    }
//    println(a.toString())
//    a=5
//    println(a.toString())
//    println(ZZZ.plt())
//    ZZZ(1)
//    ZZZ(1)
//    ZZZ(1)
//    println(ZZZ.a)
    var z by Delegates.vetoable(1){
        p,new,old->
        old < new
    }
    z=11
    var y by Delegates.observable(1){
        p,new,old->
        println("$new : $old")
    }
    y=10
    val zzz by lazy(LazyThreadSafetyMode.NONE){
        println("으앙 난 게을로")
        "test"
    }
    println("$zzz")
    val sss="12313 123 123 123"
    println(sss.matches(Regex("^[0-9]+$")).toString())
    object : cccc{
        override fun zzzz() {

        }
    }

    val rrr=Regex("^[0-9]+$")
    val mrst= rrr.matchEntire(sss)
    val zzzzz= mrst?.groupValues

    for(v in zzzzz?: listOf()){
        println("find : $v")
    }
}
