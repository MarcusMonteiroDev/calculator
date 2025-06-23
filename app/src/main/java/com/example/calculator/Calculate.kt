package com.example.calculator

import net.objecthunter.exp4j.ExpressionBuilder
import java.math.BigDecimal
import java.math.RoundingMode
import net.objecthunter.exp4j.function.Function
import kotlin.math.pow
import kotlin.math.ln
import kotlin.math.sqrt


fun main() {
    val expression = "5%*20"
    val a = "esse é um teste"
    println (formatExpression(expression))

}

// Converte a expressão na tela para uma expressão matemática válida para ser calculada
fun formatExpression (expression: String): String {
    var expressionFormated = expression
    val specialOperatorsList = listOf <String> (
        "sinh⁻¹(",
        "cosh⁻¹(",
        "tanh⁻¹(",
        "sin⁻¹(",
        "cos⁻¹(",
        "tan⁻¹(",
        "!",
        "π",
        "log(",
        "ln(",
        "%"
    )
    val numbers = listOf <String> ("0","1","2","3","4","5","6","7","8","9")
    val operations = listOf ('+', '-', '*', '/')

    expressionFormated = expression
        .replace("sinh⁻¹(", "asinh(")
        .replace("cosh⁻¹(", "acosh")
        .replace("tanh⁻¹(", "atanh(")
        .replace("sin⁻¹(", "asin(")
        .replace("cos⁻¹(", "acos(")
        .replace("tan⁻¹(", "atan(")
        //.replace("!", "factorial(")   // ATENÇÃO
        .replace("π", "pi")
        .replace("log(", "log10(")
        .replace("ln(", "log(")
        //.replace("%", "percent(")   // ATENÇÃO
        .replace("x", "*")

    if ("!" in expressionFormated) {
        expressionFormated = substituteFactorial (expressionFormated)
    }
    if ("%" in expressionFormated) {
        expressionFormated = substitutePercent(expressionFormated)
    }

    return calculate(expressionFormated)
}

/*
1 - Localizar a ocorrência do !
2 - Verificar qual o número no qual o ! está associado
3 - Apagar o ! e colocar o factorial( no início do número e fechar com um )
 */
fun substitutePercent (expression: String): String {
    val numbers = listOf <String> ("0","1","2","3","4","5","6","7","8","9")
    val operations = listOf ("+", "-", "*", "/","")

    var exp = expression
    val quantidade = exp.count {it == '%'}

    println ("Quantidade de ocorrências -> $quantidade\n--------------")

    for (i in 1..quantidade) {

        val id = exp.indexOf('%')

        for (u in (id downTo 0)) {
            if (exp[u].toString() in operations) {
                val parte1 = exp.substring(0, u+1)
                val parte2 = exp.substring(u+1)
                exp = parte1 + "percent(" + parte2
                break
            }
            if (u == 0) {
                exp = "percent(" + exp
                break
            }
        }

        exp = exp.replaceFirst("%",")")
    }

    println ("Expressão -> $exp")
    println("--------------------")

    return exp
}

fun substituteFactorial (expression: String): String {
    val numbers = listOf <String> ("0","1","2","3","4","5","6","7","8","9")
    val operations = listOf ("+", "-", "*", "/","")

    var exp = expression
    val quantidade = exp.count {it == '!'}

    println ("Quantidade de ocorrências -> $quantidade\n--------------")

    for (i in 1..quantidade) {

        val id = exp.indexOf('!')

        for (u in (id downTo 0)) {
            if (exp[u].toString() in operations) {
                val parte1 = exp.substring(0, u+1)
                val parte2 = exp.substring(u+1)
                exp = parte1 + "factorial(" + parte2
                break
            }
            if (u == 0) {
                exp = "factorial(" + exp
                break
            }
        }

        exp = exp.replaceFirst("!",")")
    }

    println ("Expressão -> $exp")
    println("--------------------")

    return exp
}


// Calcula a expressão matemática
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

// Formata o resultado
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

// Calcula sinh⁻¹
val asinh = object: Function ("asinh", 1) {
    override fun apply (vararg args: Double): Double {
        val number = args[0]
        val result = ln(number + sqrt (number.pow(2) + 1))

        return result
    }
}

// Calcula cosh⁻¹
val acosh = object: Function ("acosh", 1) {
    override fun apply (vararg args: Double): Double {
        val number = args[0]
        val result = ln(number + sqrt (number.pow(2) - 1))

        return result
    }
}

// Calcula tanh⁻¹
val atanh = object: Function ("atanh", 1) {
    override fun apply (vararg args: Double): Double {
        val number = args[0]
        val result = 0.5 * ln((1 + number) / (1 - number))

        return result
    }
}