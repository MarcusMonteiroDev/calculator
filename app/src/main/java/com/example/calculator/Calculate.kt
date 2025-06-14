package com.example.calculator

import net.objecthunter.exp4j.ExpressionBuilder
import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    val expression = "cos(5*pi)"

    println (Calculate(expression))
}

fun Calculate (expression: String): String {
    try {
        val result = ExpressionBuilder(expression).build().evaluate()
        return formatResult(result)
    }
    catch (e: Exception) {
        return "Error"
    }
}

fun formatResult (number: Double): String {
    val bigDecimal = BigDecimal(number)
    val result = bigDecimal
        .setScale (12, RoundingMode.HALF_UP)
        .stripTrailingZeros()

    return result.toString()
}