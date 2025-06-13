package com.example.calculator

import net.objecthunter.exp4j.ExpressionBuilder

fun main() {
    println (Calculate("pi*2-4"))
}

fun Calculate (expression: String): String {
    try {
        val result = ExpressionBuilder(expression).build().evaluate()
        return result.toString()
    }
    catch (e: Exception) {
        return "Error"
    }
}