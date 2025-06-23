package com.example.calculator

enum class ButtonCategory {
    NUMBER, OPERATOR, CLEAR, EQUALS
}

data class ButtonMold (
    val symbolId: Int,
    val screenSymbol: String,
    val contentDescription: String,
    val categoryButton: ButtonCategory,
    val size: Float,
    val onClickAction: (String) -> String
)

// Lista de botões padronizada
val buttons = listOf(
    // Linha 1 (Topo)
    listOf(
        ButtonMold(
            symbolId = R.drawable.trig_asinh,
            screenSymbol = "teste",
            contentDescription = "Inverse Hyperbolic Sine",
            categoryButton = ButtonCategory.NUMBER,
            size = 1.0f,
            onClickAction = { it + "sinh⁻¹(" }
        ),
        ButtonMold(
            symbolId = R.drawable.trig_acosh,
            screenSymbol = "teste",
            contentDescription = "Inverse Hyperbolic Cosine",
            categoryButton = ButtonCategory.NUMBER,
            size = 1.0f,
            onClickAction = { it + "cosh⁻¹(" }
        ),
        ButtonMold(
            symbolId = R.drawable.trig_atanh,
            screenSymbol = "teste",
            contentDescription = "Inverse Hyperbolic Tangent",
            categoryButton = ButtonCategory.NUMBER,
            size = 1.0f,
            onClickAction = { it + "tanh⁻¹(" }
        ),
        ButtonMold(
            symbolId = R.drawable.sym_c,
            screenSymbol = "teste",
            contentDescription = "Clear",
            categoryButton = ButtonCategory.CLEAR,
            size = 0.7f,
            onClickAction = { "" }
        ),
        ButtonMold(
            symbolId = R.drawable.sym_del,
            screenSymbol = "teste",
            contentDescription = "Delete",
            categoryButton = ButtonCategory.CLEAR,
            size = 0.8f,
            onClickAction = { it.dropLast(10) }
        ),
    ),
    // Linha 2
    listOf(
        ButtonMold(
            symbolId = R.drawable.trig_sinh,
            screenSymbol = "teste",
            contentDescription = "Hyperbolic Sine",
            categoryButton = ButtonCategory.NUMBER,
            size = 1.0f,
            onClickAction = { it + "sinh(" }
        ),
        ButtonMold(
            symbolId = R.drawable.trig_cosh,
            screenSymbol = "teste",
            contentDescription = "Hyperbolic Cosine",
            categoryButton = ButtonCategory.NUMBER,
            size = 1.0f,
            onClickAction = { it + "cosh(" }
        ),
        ButtonMold(
            symbolId = R.drawable.trig_tanh,
            screenSymbol = "teste",
            contentDescription = "Hyperbolic Tangent",
            categoryButton = ButtonCategory.NUMBER,
            size = 1.0f,
            onClickAction = { it + "tanh(" }
        ),
        ButtonMold(
            symbolId = R.drawable.sym_deg,
            screenSymbol = "teste",
            contentDescription = "Angle Mode Toggle DEG",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.7f,
            onClickAction = { it }
        ),
        ButtonMold(
            symbolId = R.drawable.sym_rad,
            screenSymbol = "teste",
            contentDescription = "Angle Mode Toggle RAD",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.7f,
            onClickAction = { it }
        ),
    ),
    // Linha 3
    listOf(
        ButtonMold(
            symbolId = R.drawable.trig_asin,
            screenSymbol = "teste",
            contentDescription = "Inverse Sine",
            categoryButton = ButtonCategory.NUMBER,
            size = 1.0f,
            onClickAction = { it + "sin⁻¹(" }
        ),
        ButtonMold(
            symbolId = R.drawable.trig_acos,
            screenSymbol = "teste",
            contentDescription = "Inverse Cosine",
            categoryButton = ButtonCategory.NUMBER,
            size = 1.0f,
            onClickAction = { it + "cos⁻¹(" }
        ),
        ButtonMold(
            symbolId = R.drawable.trig_atan,
            screenSymbol = "teste",
            contentDescription = "Inverse Tangent",
            categoryButton = ButtonCategory.NUMBER,
            size = 1.0f,
            onClickAction = { it + "tan⁻¹(" }
        ),
        ButtonMold(
            symbolId = R.drawable.opr_1_div_x,
            screenSymbol = "teste",
            contentDescription = "Reciprocal",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.8f,
            onClickAction = { it + "1/" }
        ),
        ButtonMold(
            symbolId = R.drawable.opr_n_factorial,
            screenSymbol = "teste",
            contentDescription = "Factorial",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.8f,
            onClickAction = { it + "!" }
        ),
    ),
    // Linha 4
    listOf(
        ButtonMold(
            symbolId = R.drawable.trig_sin,
            screenSymbol = "teste",
            contentDescription = "Sine",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.8f,
            onClickAction = { it + "sin(" }
        ),
        ButtonMold(
            symbolId = R.drawable.trig_cos,
            screenSymbol = "teste",
            contentDescription = "Cosine",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.8f,
            onClickAction = { it + "cos(" }
        ),
        ButtonMold(
            symbolId = R.drawable.trig_tan,
            screenSymbol = "teste",
            contentDescription = "Tangent",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.8f,
            onClickAction = { it + "tan(" }
        ),
        ButtonMold(
            symbolId = R.drawable.sym_pi,
            screenSymbol = "teste",
            contentDescription = "Pi",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.7f,
            onClickAction = { it + "π" }
        ),
        ButtonMold(
            symbolId = R.drawable.sym_e,
            screenSymbol = "teste",
            contentDescription = "Euler's Number",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.7f,
            onClickAction = { it + "e" }
        ),
    ),
    // Linha 5
    listOf(
        ButtonMold(
            symbolId = R.drawable.opr_log,
            screenSymbol = "teste",
            contentDescription = "Logarithm Base 10",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.8f,
            onClickAction = { it + "log(" }
        ),
        ButtonMold(
            symbolId = R.drawable.opr_ln,
            screenSymbol = "teste",
            contentDescription = "Natural Logarithm",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.8f,
            onClickAction = { it + "ln(" }
        ),
        ButtonMold(
            symbolId = R.drawable.opr_10_pow_x,
            screenSymbol = "teste",
            contentDescription = "10 to the Power of x",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.8f,
            onClickAction = { it + "10^" }
        ),
        ButtonMold(
            symbolId = R.drawable.opr_e_pow_x,
            screenSymbol = "teste",
            contentDescription = "e to the Power of x",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.9f,
            onClickAction = { it + "e^" }
        ),
        ButtonMold(
            symbolId = R.drawable.opr_percentage,
            screenSymbol = "teste",
            contentDescription = "Percent",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.8f,
            onClickAction = { it + "%" }
        ),
    ),
    // Linha 6
    listOf(
        ButtonMold(
            symbolId = R.drawable.opr_x_pow_2,
            screenSymbol = "teste",
            contentDescription = "Square",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.75f,
            onClickAction = { it + "^2" }
        ),
        ButtonMold(
            symbolId = R.drawable.opr_x_pow_3,
            screenSymbol = "teste",
            contentDescription = "Cube",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.75f,
            onClickAction = { it + "^3" }
        ),
        ButtonMold(
            symbolId = R.drawable.opr_x_pow_y,
            screenSymbol = "teste",
            contentDescription = "x to the Power of y",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.75f,
            onClickAction = { it + "^" }
        ),
        ButtonMold(
            symbolId = R.drawable.opr_sqrt,
            screenSymbol = "teste",
            contentDescription = "Square Root",
            categoryButton = ButtonCategory.NUMBER,
            size = 1.0f,
            onClickAction = { it + "√" }
        ),
        ButtonMold(
            symbolId = R.drawable.opr_sqrt_y,
            screenSymbol = "teste",
            contentDescription = "y-th Root of x",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.9f,
            onClickAction = { it + "rootN(" }
        ),
    ),
    // Linha 7
    listOf(
        ButtonMold(
            symbolId = R.drawable.seven,
            screenSymbol = "teste",
            contentDescription = "Seven",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.6f,
            onClickAction = { it + "7" }
        ),
        ButtonMold(
            symbolId = R.drawable.eight,
            screenSymbol = "teste",
            contentDescription = "Eight",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.6f,
            onClickAction = { it + "8" }
        ),
        ButtonMold(
            symbolId = R.drawable.nine,
            screenSymbol = "teste",
            contentDescription = "Nine",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.6f,
            onClickAction = { it + "9" }
        ),
        ButtonMold(
            symbolId = R.drawable.opr_divide,
            screenSymbol = "teste",
            contentDescription = "Division",
            categoryButton = ButtonCategory.OPERATOR,
            size = 0.8f,
            onClickAction = { it + "/" }
        ),
        ButtonMold(
            symbolId = R.drawable.sym_open,
            screenSymbol = "teste",
            contentDescription = "Open Parentheses",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.7f,
            onClickAction = { it + "(" }
        ),
    ),
    // Linha 8
    listOf(
        ButtonMold(
            symbolId = R.drawable.four,
            screenSymbol = "teste",
            contentDescription = "Four",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.6f,
            onClickAction = { it + "4" }
        ),
        ButtonMold(
            symbolId = R.drawable.five,
            screenSymbol = "teste",
            contentDescription = "Five",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.6f,
            onClickAction = { it + "5" }
        ),
        ButtonMold(
            symbolId = R.drawable.six,
            screenSymbol = "teste",
            contentDescription = "Six",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.6f,
            onClickAction = { it + "6" }
        ),
        ButtonMold(
            symbolId = R.drawable.opr_multiply,
            screenSymbol = "teste",
            contentDescription = "Multiplication",
            categoryButton = ButtonCategory.OPERATOR,
            size = 0.9f,
            onClickAction = { it + "x" }
        ),
        ButtonMold(
            symbolId = R.drawable.sym_close,
            screenSymbol = "teste",
            contentDescription = "Close Parentheses",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.7f,
            onClickAction = { it + ")" }
        ),
    ),
    // Linha 9
    listOf(
        ButtonMold(
            symbolId = R.drawable.one,
            screenSymbol = "teste",
            contentDescription = "One",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.6f,
            onClickAction = { it + "1" }
        ),
        ButtonMold(
            symbolId = R.drawable.two,
            screenSymbol = "teste",
            contentDescription = "Two",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.6f,
            onClickAction = { it + "2" }
        ),
        ButtonMold(
            // Corrigido: R.drawable.trhee -> R.drawable.three
            symbolId = R.drawable.three,
            screenSymbol = "teste",
            contentDescription = "Three",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.6f,
            onClickAction = { it + "3" }
        ),
        ButtonMold(
            symbolId = R.drawable.opr_minus,
            screenSymbol = "teste",
            contentDescription = "Subtraction",
            categoryButton = ButtonCategory.OPERATOR,
            size = 0.8f,
            onClickAction = { it + "-" }
        ),
        ButtonMold(
            symbolId = R.drawable.symb_change_sign,
            screenSymbol = "teste",
            contentDescription = "Change Sign",
            categoryButton = ButtonCategory.NUMBER,
            size = 1.0f,
            onClickAction = { it /* Lógica de troca de sinal aqui */ }
        ),
    ),
    // Linha 10 (Base)
    listOf(
        ButtonMold(
            symbolId = R.drawable.zero,
            screenSymbol = "teste",
            contentDescription = "Zero",
            categoryButton = ButtonCategory.NUMBER,
            size = 0.6f,
            onClickAction = { it + "0" }
        ),
        ButtonMold(
            symbolId = R.drawable.opr_dot,
            screenSymbol = "teste",
            contentDescription = "Decimal Point",
            categoryButton = ButtonCategory.NUMBER,
            size = 1.0f,
            onClickAction = { it + "." }
        ),
        ButtonMold(
            symbolId = R.drawable.sym_ans,
            screenSymbol = "teste",
            contentDescription = "Answer",
            categoryButton = ButtonCategory.NUMBER,
            size = 1.0f,
            onClickAction = { it /* Lógica para inserir a última resposta aqui */ }
        ),
        ButtonMold(
            symbolId = R.drawable.opr_plus,
            screenSymbol = "teste",
            contentDescription = "Addition",
            categoryButton = ButtonCategory.OPERATOR,
            size = 1.0f,
            onClickAction = { it + "+" }
        ),
        ButtonMold(
            symbolId = R.drawable.opr_equal,
            screenSymbol = "teste",
            contentDescription = "Equals",
            categoryButton = ButtonCategory.EQUALS,
            size = 0.8f,
            onClickAction = { formatExpression(it) }
        ),
    )
)