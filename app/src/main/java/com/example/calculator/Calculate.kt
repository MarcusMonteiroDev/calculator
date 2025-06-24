package com.example.calculator

import net.objecthunter.exp4j.ExpressionBuilder
import java.math.BigDecimal
import java.math.RoundingMode
import net.objecthunter.exp4j.function.Function
import kotlin.math.pow
import kotlin.math.ln
import kotlin.math.sqrt
// -------------------------------------------------------------------------------------------
// Função main() usada para testes
fun main() {
    val exp ="cosh⁻¹("
    println(exp.length)
    println ("Últimos caracteres -> ${exp.takeLast(2)}")

    delete(exp)
}
// -------------------------------------------------------------------------------------------
// Funções utilitárias para conversão ou cálculo:

// Converte a expressão na tela para uma expressão matemática válida para ser calculada
fun formatExpression (expression: String): String {
    // Substitui os elementos escritos na tela por operações que o exp4j entende
    var expressionFormated = expression
        .replace("sinh⁻¹(", "asinh(")
        .replace("cosh⁻¹(", "acosh")
        .replace("tanh⁻¹(", "atanh(")
        .replace("sin⁻¹(", "asin(")
        .replace("cos⁻¹(", "acos(")
        .replace("tan⁻¹(", "atan(")
        .replace("π", "pi")
        .replace("log(", "log10(")
        .replace("ln(", "log(")
        .replace("x", "*")

    // Caso especial para o fatorial de um número
    if ("!" in expressionFormated) {
        // Chama a função que subistitui o valor de forma adequada
        expressionFormated = substitute (expression = expressionFormated,
            oldValue = "!",
            newValue = "factorial(")
    }
    // Caso especial para a porcentagem de um número
    if ("%" in expressionFormated) {
        // Chama a função que subistitui o valor de forma adequada
        expressionFormated = substitute (expression = expressionFormated,
            oldValue = "%",
            newValue = "percent(")
    }
    // Chama a função de cálculo e retorna o resultado da expressão devidamente convertida
    return calculate(expressionFormated)
}

// Função usada para subistituir o "!" e o "%" para expressões que possam ser usadas no cálculo
// dentro do calculate(). Essa função funciona com a seguinte lógica:
// 1 - Localizar a ocorrência do elemento
// 2 - Verificar qual o número no qual o elemento está associado
// 3 - Apagar o elemento e colocar o a função correspondente no início do número e fechar com um )
fun substitute (expression: String, oldValue: String, newValue: String): String {
    // Lista de operações usada para saber quando o número no qual a operação está sendo feita acaba
    val operations = listOf ("+", "-", "*", "/",)
    // Recebe o valor da expressão
    var exp = expression

    // Laço que percorre a expressão até que todas as ocorrências do elemento a ser substituido
    // terminem
    while (oldValue in exp) {
        // Pega o index do elemento procurado
        val id = exp.indexOf(oldValue)
        // Percorre a string em sentido contrário a partir do elemento encontrado
        for (u in (id downTo 0)) {
            // Verifica se o número associado ao elemento terminou (os números terminam com
            // operações antes dele ou com um espaço vazio caso ele seja o primeiro número da tela)
            if (exp[u].toString() in operations) {
                val parte1 = exp.substring(0, u+1)
                val parte2 = exp.substring(u+1)
                exp = parte1 + newValue + parte2
                break
            }
            if (u == 0) {
                exp = newValue + exp
                break
            }
        }
        // Após a substituição ser feita, modifica a primeira ocorrência do elemento buscado para
        // um parênteses que fecha a função posicionada anteriormente
        exp = exp.replaceFirst(oldValue,")")
    }
    // Retorna a expressão devidamente formatada
    return exp
}

// Calcula a expressão matemática
fun calculate (expression: String): String {
    // Verifica se a expressão é válida
    try {
        // Declara as funções especiais que calculam operações que não estão disponíveis
        // na biblioteca exp4j por padrão
        val builder = ExpressionBuilder(expression)
            .function(atanh)
            .function(acosh)
            .function(asinh)
            .function(percent)
            .function(rootN)
            .function(factorial)

        // Calcula a expressão usando a biblioteca exp4j
        val result = builder.build().evaluate()
        // Retorna o resultado convertido para string
        return result.toString()
    }
    // Caso a expressão não seja válida, retorna um erro
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

// Função que deleta termos escritos na expressão
fun delete (expression: String): String {

    val numbers = listOf('0','1','2','3','4','5','6','7','8','9')
    val operations_4 = listOf(
        "sin(",
        "cos(",
        "tan(",
        "log(",
    )
    val operations_5 = listOf (
        "sinh(",
        "cosh(",
        "tanh(",
    )
    val operations_6 = listOf (
        "sin⁻¹(",
        "cos⁻¹(",
        "tan⁻¹(",
    )
    val operations_7 = listOf (
        "sinh⁻¹(",
        "cosh⁻¹(",
        "tanh⁻¹("
    )

    var exp = expression
    val last = exp.lastOrNull()

    if (last == null) {
        exp = ""
    }
    else {
        if (last == '(' ) {
            if (exp.takeLast(3) == "ln(") {
                exp = exp.dropLast(3)
            }
            else if (exp.takeLast(4) in operations_4) {
                exp = exp.dropLast(4)
            }
            else if (exp.takeLast(5) in operations_5) {
                exp = exp.dropLast(5)
            }
            else if (exp.takeLast(6) in operations_6) {
                exp = exp.dropLast(6)
            }
            else if (exp.takeLast(7) in operations_7) {
                exp = exp.dropLast(7)
            }
            else {
                exp = exp.dropLast(1)
            }
        }
        else {
            exp = exp.dropLast(1)
        }
    }

    return exp
}
// -------------------------------------------------------------------------------------------
// Funções extras para o cálculo de expressoes que não estão presentes no exp4j:

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
// -------------------------------------------------------------------------------------------