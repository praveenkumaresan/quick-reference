fun drawCircle(){
    val circle = object {
        val x= 10
        val y = 20
        val radius = x * y
    }
    val y = circle.x
    println(y)
}

//anonymous objects can also be used for implementation of interfaces
fun createRunnable(): Runnable{
    val runnable = object : Runnable {
        override fun run() {
            println("I am cool")
        }
    }
    return runnable
}


//singleton with object declaration
object Util{
    fun numberOfProcessors() = Runtime.getRuntime().availableProcessors()
}

fun main(){
    drawCircle()
    val runnable = createRunnable()
    runnable.run()
    println(Util.numberOfProcessors())
}