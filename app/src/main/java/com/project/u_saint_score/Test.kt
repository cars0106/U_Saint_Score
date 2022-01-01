package com.project.u_saint_score

val data4: Int by lazy {
    println("in lazy......")
    10
}

fun main() {
    println("hello world")

    println(data4 + 10)
    println(data4 + 10)

    val data1: Array<Int> = Array(3, { 0 })
    data1[0] = 10
    data1[1] = 20
    data1.set(2, 30)

    println(
        """
            array size : ${data1.size}
            array data : ${data1[0]}, ${data1[1]}, ${data1.get(2)}
        """.trimIndent()
    )
}

