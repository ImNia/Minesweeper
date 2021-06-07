package minesweeper

import kotlin.random.Random

fun addAround(field: Array<CharArray>, sizeField: Int): Array<CharArray> {
    for (x in 0 until sizeField) {
        for (y in 0 until sizeField) {
            if (field[x][y] != 'X') {

                for (i in -1..1) {
                    for (j in -1..1) {
                        if (x + i in 0 until sizeField && y + j in 0 until sizeField && field[x + i][y + j] == 'X') {
                            when (field[x][y]) {
                                '.' -> field[x][y] = '1'
                                '1' -> field[x][y] = '2'
                                '2' -> field[x][y] = '3'
                                '3' -> field[x][y] = '4'
                                '4' -> field[x][y] = '5'
                                '5' -> field[x][y] = '6'
                                '6' -> field[x][y] = '7'
                                '7' -> field[x][y] = '8'
                                '8' -> field[x][y] = '9'
                            }
                        }
                    }
                }

            }
        }
    }
    return field
}

fun addMine(field: Array<CharArray>): Array<CharArray> {
    var x: Int
    var y: Int
    do {
        x = Random.nextInt(0, 9)
        y = Random.nextInt(0, 9)
    } while (field[x][y] != '.')
    field[x][y] = 'X'
    return field
}

fun main() {
    val sizeField = 9
    var field: Array<CharArray> = Array(sizeField) { CharArray(sizeField) {'.'} }

    print("How many mines do you want on the field? > ")
    val countMine = readLine()!!.toInt()

    for (i in 0 until countMine) {
        field = addMine(field)
    }
    field = addAround(field, sizeField)

    for (i in 0 until sizeField) {
        println(field[i].joinToString(separator=""))
    }
}
