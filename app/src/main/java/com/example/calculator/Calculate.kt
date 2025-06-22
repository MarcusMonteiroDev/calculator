package com.example.calculator

import net.objecthunter.exp4j.ExpressionBuilder
import java.math.BigDecimal
import java.math.RoundingMode
import net.objecthunter.exp4j.function.Function
import kotlin.math.pow
import kotlin.math.ln
import kotlin.math.sqrt


fun main() {
    val expression = "sinh(pi)"
    println (calculate(expression))

}

fun calculate (expression: String): String {
    try {
        val builder = ExpressionBuilder(expression)
            .function(atanh)
            .function(acosh)
            .function(asinh)
            .function(percent)
            .function(rootN)
            .function(factorial)

        val result = builder.build().evaluate()
        return result.toString()
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

// Função que calcula o fatorial de um número
val factorial = object: Function ("factorial", 1) {
    override fun apply (vararg args: Double): Double {
        val number = args[0]

        // Checagem de validade do argumento
        if (number < 0) {
            throw IllegalArgumentException("Factorial cannot be negative")
        }
        if (number != number.toInt().toDouble()) {
            throw IllegalArgumentException("Factorial must be an integer number")
        }

        var result = 1.0
        for (i in 1..number.toInt()) {
            result *= i
        }
        return result
    }
}

// Função que calcula a N-ésima raiz de um número
val rootN = object: Function ("rootN", 2) {
    override fun apply (vararg args: Double): Double {
        val base = args[0]
        val index = args[1]

        return base.pow(1.0 / index)
    }
}

// Função que calcula a porcentagem
val percent = object: Function ("percent", 1) {
    override fun apply (vararg args: Double): Double {
        val number = args[0]

        return number/100.0
    }
}

val asinh = object: Function ("asinh", 1) {
    override fun apply (vararg args: Double): Double {
        val number = args[0]
        val result = ln(number + sqrt (number.pow(2) + 1))

        return result
    }
}

val acosh = object: Function ("acosh", 1) {
    override fun apply (vararg args: Double): Double {
        val number = args[0]
        val result = ln(number + sqrt (number.pow(2) - 1))

        return result
    }
}

val atanh = object: Function ("atanh", 1) {
    override fun apply (vararg args: Double): Double {
        val number = args[0]
        val result = 0.5 * ln((1 + number) / (1 - number))

        return result
    }
}