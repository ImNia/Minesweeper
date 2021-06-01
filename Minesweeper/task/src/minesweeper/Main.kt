package minesweeper

import kotlin.random.Random

fun main() {
    val sizeField = 9
    val field: Array<CharArray> = Array(sizeField) { CharArray(sizeField) {'.'} }

    print("How many mines do you want on the field? > ")
    val countMine = readLine()!!.toInt()

    for (i in 0 until countMine) {
        var x: Int
        var y: Int
        do {
            x = Random.nextInt(0, 9)
            y = Random.nextInt(0, 9)
        } while (field[x][y] != '.')
        field[x][y] = 'X'
    }

    for (i in 0 until sizeField) {
        println(field[i].joinToString(separator=""))
    }
}
