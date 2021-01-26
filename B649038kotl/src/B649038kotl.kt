fun p03hello(){
    println("Hello")
}
//Hello

//Part 4 – Variables
fun p04variables() {
    val userName = "Florian"
    var age = 28

    println("Hello, world! My name is $userName. I am $age years old. In 2 years, I'll be ${age + 2}.")
}
//Hello, world! My name is Florian. I am 28 years old. In 2 years, I'll be 30.

//Part 5 – Basic Types
fun p05types() {
    val exampleString = "\"Florian\nWalther\""
    val exampleRawString = """ "Florian
Walther" """
    print(exampleRawString)

    val exampleNumber: Double
    exampleNumber = 2_000_000.12
    println(exampleNumber)
    val exampleLong: Long = exampleNumber.toLong()

    val exampleChar = '?'
    val exampleInt: Int = exampleChar.toInt()
    val i = 3
    println(i)

    val exampleBoolean = false
}
//"Florian
//Walther" 2000000.12
//3

//Part 6 – Arithmetic Operators
fun p06arithmetic(){
        var a = 5
        val b = 3.0

        println("a = " + a + " b = " + b)

        println("a + b = ${a + b}")
        println("a - b = ${a - b}")
        println("a * b = ${a * b}")
        println("a / b = ${a / b}")
        println("a % b = ${a % b}")

        println("(2 + 2) * 3 = ${(2 + 2) * 3}")

        println("-a = ${-a}")

        a += 2
        println("a += 2: $a")

        println("a++: ${a++}")
        println("++a: ${++a}")

        a -= 2
        println("a -= 2: $a")

        println("a--: ${a--}")
        println("--a: ${--a}")

        a *= 2
        println("a *= 2: $a")

        a /= 2
        println("a /= 2: $a")

        a %= 2
        println("a %= 2: $a")
        println((8/6).toInt())
}
//a--: 7
//--a: 5
//a *= 2: 10
//a /= 2: 5
//a %= 2: 1
//1

//Part 7 – REPL
fun p07repl(){

}

//Part 8 – Comments
fun p08comment(){
//
/*


 */
}

//Part 9 – Arrays
fun p09arrays(){
    val names = arrayOf("John", "Jack", "Janny")

    println("number of elements: ${names.size}")

    println("first element: ${names[0]}")

    println("last element: ${names[names.size-1]}")

    println("1 & 2 : ${names.slice(1..2)}")


}
//number of elements: 3
//first element: John
//last element: Janny
//1 & 2 : [Jack, Janny]

//Part 10 – For-Loop & Ranges
fun p10loop(){
    var units = arrayOf("1", "2", "3")
    units.reverse()
    println(units[0])
    for(i in units) print("${i} " + " - ")
    println()
    for(i in 3..8) print( "" + i + " ")
    println()
    for(i in 11 until 15) print("" + i + " ")
    println()
    for(i in 6L downTo 1) print("" + i + " ")
    println()
    for(i in 'a'..'z') print(i)
}
//3
//3  - 2  - 1  -
//3 4 5 6 7 8
//11 12 13 14
//6 5 4 3 2 1
//abcdefghijklmnopqrstuvwxyz


//Part 11 – Comparison & Logical Operators
fun p11logic(){
    println("2 > 1 is ${2 > 1}")
    println("2 < 1 is ${2 < 1}")
    println("1 >= 1 is ${1 >= 1}")

    println("1 == 1 is ${1 == 1}")
    println("1 == 2 is ${1 == 2}")
    println("1 != 2 is ${1 != 2}")

    println("!(2 > 1) is ${!(2 > 1)}")

    println("true && false = ${true && false}")
    println("true || false = ${true || false}")

    val condition = (2 > 1) || (3 > 2) && (2 > 3)
    println(condition)
}
//2 > 1 is true
//2 < 1 is false
//1 >= 1 is true
//1 == 1 is true
//1 == 2 is false
//1 != 2 is true
//!(2 > 1) is false
//true && false = false
//true || false = true
//true


//Part 12 – While-Loop & Labels
fun p12while(){
    var i = 0

    outer@ do{
        print("" + i++)
        for(j in 1..3){
            println(j)
            break@outer
        }
    }while (i<5)

}
//1
//0

//Part 13 – If Else
fun p13if(){
    for (i in -2..10){
        val prefix = if (i == 1){
            "*"
        }else if (i !in 4..7){
            "+"
        }else {
            print("-")
            ">"
        }
        println("$prefix $i")
    }
}
//+ -2
//+ -1
//+ 0
//* 1
//+ 2
//+ 3
//-> 4
//-> 5
//-> 6
//-> 7
//+ 8
//+ 9
//+ 10

//Part 14 – When
fun p14when(){

}

//Part 15 – Function Parameters
fun p15param(){

}

//Part 16 – Function Return Values
fun p16return(){

}

//Part 17 – Single-Expression Functions
fun p17alfa(){

}

//Part 18 – Function Overloading
fun p18func(){

}

//Part 19 – Default & Named Arguments
fun p19default(){

}

//Part 20 – Vararg & Spread Operator
fun p20var(){

}

//Part 21 – Top-Level Variables & Const Val
fun p21const(){

}

//Part 22 – What Are Classes/OOP?
fun p22classes(){

}

//Part 23 – Simple Class
fun p23class(){

}

//Part 24 – Init Blocks
fun p24block(){

}

fun p25(){

}

fun p26(){

}

fun p27(){

}



fun main() {

    when(14) {
        3 -> p03hello()
        4 -> p04variables()
        5 -> p05types()
        6 -> p06arithmetic()
        7 -> p07repl()
        8 -> p08comment()
        9 -> p09arrays()
        10 -> p10loop()
        11 -> p11logic()
        12 -> p12while()
        13 -> p13if()
        14 -> p14when()
        15 -> p15param()
        16 -> p16return()
        17 -> p17alfa()
        18 -> p18func()
        19 -> p19default()
        20 -> p20var()
        21 -> p21const()
        22 -> p22classes()
        23 -> p23class()
        24 -> p24block()
        25 -> p25()
        26 -> p26()
        27 -> p27()
        else -> print("")
    }

//    println(greeting)
}

