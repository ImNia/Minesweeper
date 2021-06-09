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

fun checkMine(baseField: Array<CharArray>, positX: Int, positY: Int) : Boolean {
    return baseField[positX][positY] == 'X'
}
fun changeField(field: Array<CharArray>, baseField: Array<CharArray>,
                positX: Int, positY: Int): Array<CharArray> {
    var newField: Array<CharArray> = field
    when (baseField[positX][positY]) {
        '1', '2', '3', '4', '5', '6', '7', '8' -> newField[positX][positY] = baseField[positX][positY]
        '.' -> {
            newField[positX][positY] = '/'
            for (i in -1..1) {
                for (j in -1..1) {
                    if (positX + i in 0..8 && positY + j in 0..8 &&
                        (newField[positX + i][positY + j] == '.'  || newField[positX + i][positY + j] == '*'))
                        newField = changeField(newField, baseField, positX + i, positY + j)
                }
            }
        }
    }
    return newField
}

fun checkFieldHasPlace(field: Array<CharArray>, newField: Array<CharArray>, sizeField: Int) : Boolean {
    for (i in 0 until sizeField) {
        for (j in 0 until sizeField) {
            if (field[i][j] == newField[i][j] || field[i][j] != newField[i][j] && newField[i][j] == '.' && field[i][j] == 'X'
                || field[i][j] != newField[i][j] && newField[i][j] == '*' && field[i][j] == 'X'
                || field[i][j] != newField[i][j] && newField[i][j] == '/' && field[i][j] == '.') continue
            else return false
        }
    }
    return true
}

fun checkFieldWin(field: Array<CharArray>, newField: Array<CharArray>, size: Int) : Boolean {
    for (i in 0 until size) {
        for (j in 0 until size) {
            if (field[i][j] != newField[i][j])
                if (newField[i][j] == '.' && field[i][j] == 'X' ||
                    newField[i][j] == '*' && field[i][j] != 'X') return checkFieldHasPlace(field, newField, size)
        }
    }

    return true
}