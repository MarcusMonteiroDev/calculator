package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.ui.theme.CalculatorTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.calculator.ui.theme.Dark_Background
import com.example.calculator.ui.theme.Dark_Button_Number
import com.example.calculator.ui.theme.Dark_Display
import com.example.calculator.ui.theme.Light_Background
import com.example.calculator.ui.theme.Light_Button_Clear
import com.example.calculator.ui.theme.Light_Button_Number
import com.example.calculator.ui.theme.Light_Display

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Display(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

enum class ButtonCategory {
    NUMBER, OPERATOR, CLEAR, EQUALS
}

data class ButtonMold (
    val symbolId: Int,
    val contentDescription: String,
    val categoryButton: ButtonCategory,
    val size: Float,
    val onClickAction: (String) -> String
)

@Composable
fun Display (modifier: Modifier = Modifier) {
    // Cor do botão
    // Armazena a expressão matemática digitada
    var expression by remember { mutableStateOf("") }
    // Controla o estado de rolagem do display de texto
    val scrollState = rememberScrollState()
    // Rola suavemente o texto para manter sempre na posição final
    LaunchedEffect (expression) {
        scrollState.animateScrollTo (scrollState.maxValue)
    }

    // Verifica se o sistema está no modo escuro
    val isDarkTheme = isSystemInDarkTheme()

    // Define a cor do display e do background
    val displayColor = if (isDarkTheme) Dark_Display else Light_Display
    val backgroundColor = if (isDarkTheme) Dark_Background else Light_Background

    // Modifier padrão dos botões
    val baseButtonModifier: Modifier = Modifier
        .fillMaxSize()
        .padding(2.dp)
        .clip(RoundedCornerShape(16.dp))

    // Lista de botões
    val buttons = listOf (
        listOf (
            ButtonMold (R.drawable.trig_asinh, "Inverse Hyperbolic Sine", ButtonCategory.NUMBER, 1.0f) {it + "asinh("},
            ButtonMold (R.drawable.trig_acosh, "Inverse Hyperbolic Cosine", ButtonCategory.NUMBER, 1.0f) {it + "acosh("},
            ButtonMold (R.drawable.trig_atanh, "Inverse Hyperbolic Tangent", ButtonCategory.NUMBER, 1.0f) {it + "atanh("},
            ButtonMold (R.drawable.sym_c, "Clear", ButtonCategory.CLEAR, 0.7f) {""},
            ButtonMold (R.drawable.sym_del, "Delete", ButtonCategory.CLEAR, 0.8f) {it.dropLast(1) },
        ),
        listOf (
            ButtonMold (R.drawable.trig_sinh, "Hyperbolic Sine", ButtonCategory.NUMBER, 1.0f) {it + "sinh("},
            ButtonMold (R.drawable.trig_cosh, "Hyperbolic Cosine", ButtonCategory.NUMBER, 1.0f) {it + "cosh("},
            ButtonMold (R.drawable.trig_tanh, "Hyperbolic Tangent", ButtonCategory.NUMBER, 1.0f) {it + "tanh("},
            ButtonMold (R.drawable.sym_deg, "Angle Mode Toggle DEG", ButtonCategory.NUMBER, 0.7f) {it },
            ButtonMold (R.drawable.sym_rad, "Angle Mode Toggle RAD", ButtonCategory.NUMBER, 0.7f) {it },
        ),
        listOf (
            ButtonMold (R.drawable.trig_asin, "Inverse Sine", ButtonCategory.NUMBER, 1.0f) {it + "asin("},
            ButtonMold (R.drawable.trig_acos, "Inverse Cosine", ButtonCategory.NUMBER, 1.0f) {it + "acos("},
            ButtonMold (R.drawable.trig_atan, "Inverse Tangent", ButtonCategory.NUMBER, 1.0f) {it + "atan("},
            ButtonMold (R.drawable.opr_1_div_x, "Reciprocal", ButtonCategory.NUMBER, 0.8f) {it + "1/"},
            ButtonMold (R.drawable.opr_n_factorial, "Factorial", ButtonCategory.NUMBER, 0.8f) {it + "factorial("},
        ),
        listOf (
            ButtonMold (R.drawable.trig_sin, "Sine", ButtonCategory.NUMBER, 0.8f) {it + "sin("},
            ButtonMold (R.drawable.trig_cos, "Cosine", ButtonCategory.NUMBER, 0.8f) {it + "cos("},
            ButtonMold (R.drawable.trig_tan, "Tangent", ButtonCategory.NUMBER, 0.8f) {it + "tan("},
            ButtonMold (R.drawable.sym_pi, "Pi", ButtonCategory.NUMBER, 0.7f) {it + "pi"},
            ButtonMold (R.drawable.sym_e, "Euler's Number", ButtonCategory.NUMBER, 0.7f) {it + "e"},
        ),
        listOf (
            ButtonMold (R.drawable.opr_log, "Logarithm base 10", ButtonCategory.NUMBER, 0.8f) {it + "log10("},
            ButtonMold (R.drawable.opr_ln, "Natural Logarithm", ButtonCategory.NUMBER, 0.8f) {it + "log("},
            ButtonMold (R.drawable.opr_10_pow_x, "10 to the Power of x", ButtonCategory.NUMBER, 0.8f) {it + "10^"},
            ButtonMold (R.drawable.opr_e_pow_x, "e to the Power of x", ButtonCategory.NUMBER, 0.9f) {it + "exp("},
            ButtonMold (R.drawable.opr_percentage, "Percent", ButtonCategory.NUMBER, 0.8f) {it + "percent("},
        ),
        listOf (
            ButtonMold (R.drawable.opr_x_pow_2, "Square", ButtonCategory.NUMBER, 0.75f) {it + "^2"},
            ButtonMold (R.drawable.opr_x_pow_3, "Cube", ButtonCategory.NUMBER, 0.75f) {it + "^3"},
            ButtonMold (R.drawable.opr_x_pow_y, "x to the Power of y", ButtonCategory.NUMBER, 0.75f) {it + "^"},
            ButtonMold (R.drawable.opr_sqrt, "Square Root", ButtonCategory.NUMBER, 1.0f) {it + "sqrt("},
            ButtonMold (R.drawable.opr_sqrt_y, "y-th Root of x", ButtonCategory.NUMBER, 0.9f) {it + "rootN("},
        ),
        listOf (
            ButtonMold (R.drawable.seven, "seven", ButtonCategory.NUMBER, 0.6f) {it + "7"},
            ButtonMold (R.drawable.eight, "eight", ButtonCategory.NUMBER, 0.6f) {it + "8"},
            ButtonMold (R.drawable.nine, "nine", ButtonCategory.NUMBER, 0.6f) {it + "9"},
            ButtonMold (R.drawable.opr_divide, "division", ButtonCategory.OPERATOR, 0.8f) {it + "/"},
            ButtonMold (R.drawable.sym_open, "open parentheses", ButtonCategory.NUMBER, 0.7f) {it + "("},
        ),
        listOf (
            ButtonMold (R.drawable.four, "four", ButtonCategory.NUMBER, 0.6f) {it + "4"},
            ButtonMold (R.drawable.five, "five", ButtonCategory.NUMBER, 0.6f) {it + "5"},
            ButtonMold (R.drawable.six, "six", ButtonCategory.NUMBER, 0.6f) {it + "6"},
            ButtonMold (R.drawable.opr_multiply, "multiplication", ButtonCategory.OPERATOR, 0.9f) {it + "*"},
            ButtonMold (R.drawable.sym_close, "close parentheses", ButtonCategory.NUMBER, 0.7f) {it + ")"},
        ),
        listOf (
            ButtonMold (R.drawable.one, "one", ButtonCategory.NUMBER, 0.6f) {it + "1"},
            ButtonMold (R.drawable.two, "two", ButtonCategory.NUMBER, 0.6f) {it + "2"},
            ButtonMold (R.drawable.trhee, "trhee", ButtonCategory.NUMBER, 0.6f) {it + "3"},
            ButtonMold (R.drawable.opr_minus, "subtraction", ButtonCategory.OPERATOR, 0.8f) {it + "-"},
            ButtonMold (R.drawable.symb_change_sign, "change sign", ButtonCategory.NUMBER, 1.0f) {it },
        ),
        listOf (
            ButtonMold (R.drawable.zero, "zero", ButtonCategory.NUMBER, 0.6f) {it + "0"},
            ButtonMold (R.drawable.opr_dot, "Decimal Point", ButtonCategory.NUMBER, 1.0f) {it + "."},
            ButtonMold (R.drawable.sym_ans, "answer", ButtonCategory.NUMBER, 1.0f) {it },
            ButtonMold (R.drawable.opr_plus, "addition", ButtonCategory.OPERATOR, 1.0f) {it + "+"},
            ButtonMold (R.drawable.opr_equal, "equals", ButtonCategory.EQUALS, 0.8f) { calculate(it) },
        )
    )

    // Coluna principal de sustentaçao da UI
    Column  (modifier = Modifier
        .fillMaxSize()
        .imePadding()
        .background(backgroundColor)
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        // Tela onde aparece os números da calculadora
        Box(
            modifier = Modifier
                //.border(5.dp, Color.Red)
                .weight(0.15f)
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .background(backgroundColor),
            contentAlignment = Alignment.BottomEnd
        ) {
            Text(
                text = expression,
                style = MaterialTheme.typography.displayMedium,
                maxLines = 1,
                softWrap = false,
                modifier = Modifier.horizontalScroll(scrollState),
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Desenho dos botões
        Column (
            modifier = Modifier
                .weight(1.0f)
                .fillMaxSize()
        ) {
            buttons.forEach { row ->
                Row(
                    modifier = Modifier
                        .weight(1.0f)
                ) {
                    row.forEach { element ->

                        Btn(
                            modifier = baseButtonModifier
                                .weight(0.1f),
                            symbol = painterResource(element.symbolId),
                            categoryButton = element.categoryButton,
                            size = element.size,
                            onClick = { expression = element.onClickAction(expression) })
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    CalculatorTheme {
        Display()
    }
}