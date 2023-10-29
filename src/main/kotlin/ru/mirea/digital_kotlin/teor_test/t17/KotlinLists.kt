package ru.mirea.digital_kotlin.teor_test.t17

import ru.mirea.digital_kotlin.teor_test.t16.isValidCCNumber

fun main(args: Array<String>) {
    val numbers = listOf("one", "two", "three", "four")
    println("Number of elements: ${numbers.size}")
    println("Third element: ${numbers.get(2)}")
    println("Fourth element: ${numbers[3]}")
    println("Index of element \"two\" ${numbers.indexOf("two")}")
}