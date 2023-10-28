//Задача 1.
//Создать программу, выполняющую следующий функционал:
//- запрашивается количество строк и столбцов для двумерного массива
//- вводится необходимое количество трехзначных чисел (числа могут повторяться)
//- подсчитывается количество различных цифр в полученном массиве
//- на консоль выводится двумерный массив из введенных чисел и количество различных цифр используемых в данном массиве
//Например, для массива
//100   951   101   950
//519   999   155   501
//510   911   144   554
//выведется результат: В массиве использовано 5 различных цифр
import java.util.HashSet

fun main() {
    val rows = readNumber( "Введите количество строк ")
    val columns = readNumber( "Введите количество столбцов ")

    val matrix = Array(rows) { Array(columns) {0}}

    for (i in 0 until rows) {
        for (j in 0 until columns) {
            matrix[i][j] = readNumber("Введите элемент ", 100, 999)
        }
    }

    val uniqueDigits = countiqueDigits(matrix)

    printMatrix(matrix)
    print("В массиве использовано $uniqueDigits различных цифр")
}

fun readNumber(prompt: String): Int{
    print(prompt)
    return readLine()!!.toInt()
}

fun readNumber(prompt: String, minValue: Int, maxValue: Int):Int{
    var number: Int
    do {
        number = readNumber(prompt)
    }while (number < minValue || number > maxValue)
    return number
}

fun countiqueDigits(matrix: Array<Array<Int>>):Int{
    val digits = HashSet<Int>()
    var count = 0

    for (row in matrix) {
        for (number in row){
            val hundresDigit = number / 100
            val tensDigit = (number % 100) / 10
            val onesDigit = number % 10

            digits.add(hundresDigit)
            digits.add(tensDigit)
            digits.add(onesDigit)
        }
    }
    return digits.size
}

fun printMatrix(matrix: Array<Array<Int>>){
    for (row in matrix){
        for (number in row) {
            print("$number\t")
        }
        println()
    }
}