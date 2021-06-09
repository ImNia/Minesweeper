package minesweeper

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    val sizeField = 9
    var field: Array<CharArray> = Array(sizeField) { CharArray(sizeField) {'.'} }
    var newField: Array<CharArray> = Array(sizeField) { CharArray(sizeField) {'.'} }
    var win = true

    print("How many mines do you want on the field? > ")
    val countMine = scanner.nextInt()

    for (i in 0 until countMine) {
        field = addMine(field)
    }
    field = addAround(field, sizeField)
    /*for (i in 0 until sizeField) {
        for (j in 0 until sizeField) {
            if (field[i][j] == 'X') newField[i][j] = '.'
            else newField[i][j] = field[i][j]
        }
    }*/

    printField(newField, sizeField)
    //printField(field, sizeField)
    while (!checkFieldWin(field, newField, sizeField)) {
        print("Set/unset mine marks or claim a cell as free: >")
        var positY = scanner.nextInt()
        var positX = scanner.nextInt()
        val act = scanner.next()
        positX--
        positY--

        if (act == "free") {
            if (positX in 0 until sizeField && positY in 0 until sizeField) {
                if (!checkMine(field, positX, positY)) {
                    newField = changeField(newField, field, positX, positY)
                } else {
                    println("You stepped on a mine and failed!")
                    win = false
                    break
                }
            }
        } else if (act == "mine") {
            when (newField[positX][positY]) {
                '.' -> newField[positX][positY] = '*'
                '*' -> newField[positX][positY] = '.'
            }
        }
        printField(newField, sizeField)
        /*println("--------------------------")
        printField(field, sizeField)*/
    }
    if (win) {
        println("Congratulations! You found all the mines!")
    } else {
        printFailField(newField, field, sizeField)
        println("You stepped on a mine and failed!")
    }
}
