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

fun printFailField(field: Array<CharArray>, baseField: Array<CharArray>, sizeField: Int) {
    for (i in 0 until sizeField) {
        for (j in 0 until sizeField) {
            if (baseField[i][j] == 'X') field[i][j] = 'X'
        }
    }

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