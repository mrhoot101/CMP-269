package Exercise_1

data class Laptop(val brand: String, val ramGB: Int) {
}

fun Int.toLehmanGigabytes(): String = "$this GB (Lehman Standard)"

fun main(args: Array<String>) {
    val laptop1: Laptop = Laptop("Moises", 27)
    val laptop2: Laptop = Laptop("Denise", 30)

    println(laptop1.ramGB.toLehmanGigabytes())
    println(laptop2.ramGB.toLehmanGigabytes())
}