package ru.mirea.digital_kotlin.teor_test.t16
/*
Для проверки корректности номера банковских карт используется алгоритм Луна. Реализуйте функцию расширения `isValidCCNumber(): Boolean` для класса `String` с использованием этого алгоритма. Все символы, не являющиеся цифрами (в т.ч. пробелы) игнорируются.

Цифры проверяемой последовательности нумеруются справа налево.
Цифры, оказавшиеся на нечётных местах, остаются без изменений.
Цифры, стоящие на чётных местах, умножаются на 2.
Если в результате такого умножения возникает число больше 9, оно заменяется суммой цифр получившегося произведения — однозначным числом, то есть цифрой.
Все полученные в результате преобразования цифры складываются. Если сумма кратна 10, то исходные данные верны.
Пример корректного номера карты: "4561 2612 1234 5467"
*/


fun main(args: Array<String>) {
    val str = "23erdf32rer43tr2345465"
    val str2 = "2365 3814 3042 4311"
    val str3 = "4561 2612 1234 5467"
    println(str.isValidCCNumber())
    println(str2.isValidCCNumber())
    println(str3.isValidCCNumber())

    val strings = arrayOf("foo", "bar", null, "", 123)
    for (s in strings){
        s?.let { print ("$it ") }
    }
}

fun String.isValidCCNumber(): Boolean {
    val cleanedNumber = this.replace("[^\\d]".toRegex(),"")

    var sum = 0
    val reversedDigits = cleanedNumber.reversed()

    for ((index, digitChar) in reversedDigits.withIndex()) {
        val digit = digitChar.toString().toInt()

        if (index % 2 == 1) {
            val doubledDigit = digit * 2
            sum += if (doubledDigit > 9) doubledDigit - 9 else doubledDigit
        } else {
            sum += digit
        }
    }

    return sum % 10 == 0
}