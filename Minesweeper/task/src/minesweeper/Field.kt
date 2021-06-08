package minesweeper

fun printField(field: Array<CharArray>, sizeField: Int) {
    print(" |")
    for (i in 1..sizeField) print(i)
    println("|")
    for (i in 0..sizeField) {
        if (i == 1) print("|-")
        else if (i == sizeField) print("-|")
        else print("-")
    }
    println()
    for (i in 0 until sizeField) {
        print("${i+1}|")
        print(field[i].joinToString(separator=""))
        println("|")
    }
    for (i in 0..sizeField) {
        if (i == 1) print("|-")
        else if (i == sizeField) print("-|")
        else print("-")
    }
    println()
}

fun checkField(field: Array<CharArray>, newField: Array<CharArray>, size: Int) : Boolean {
    for (i in 0 until size) {
        for (j in 0 until size) {
            if (field[i][j] != newField[i][j])
                if (newField[i][j] == '.' && field[i][j] == 'X' ||
                    newField[i][j] == '*' && field[i][j] != 'X') return false
        }
    }
    return true
}