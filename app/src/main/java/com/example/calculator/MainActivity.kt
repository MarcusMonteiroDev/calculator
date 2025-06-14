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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Display (
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

data class CalculatorButton (
    val symbolId: Int,
    val description: String,
    val onClickAction: (String) -> String
)

@Composable
fun Display (modifier: Modifier = Modifier) {
    // Cor do botão
    val color = MaterialTheme.colorScheme.secondary
    // Armazena a expressão matemática digitada
    var expression by remember { mutableStateOf("") }
    // Controla o estado de rolagem do display de texto
    val scrollState = rememberScrollState()
    // Rola suavemente o texto para manter sempre na posição final
    LaunchedEffect (expression) {
        scrollState.animateScrollTo (scrollState.maxValue)
    }

// Modifier padrão dos botões
    val baseButtonModifier: Modifier = Modifier
        .fillMaxHeight() // <-- ESSA LINHA É IMPORTANTE para que o botão ocupe toda a altura da Row.
        .padding(4.dp) // Adicionar um pequeno espaçamento entre os botões fica ótimo
        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
        .clip(RoundedCornerShape(8.dp))
        .background(color)

    val calculatorLayout = listOf(
        // Linha 1
        listOf(
            CalculatorButton(R.drawable.sin, "Seno") { it + "sin(" },
            CalculatorButton(R.drawable.cos, "Cosseno") { it + "cos(" },
            CalculatorButton(R.drawable.tan, "Tangente") { it + "tan(" },
            CalculatorButton(R.drawable.test, "Não implementado") { it }, // Botão sem ação
            CalculatorButton(R.drawable.test, "Não implementado") { it }  // Botão sem ação
        ),
        // Linha 2
        listOf(
            CalculatorButton(R.drawable.sin_1, "Arco Seno") { it + "asin(" },
            CalculatorButton(R.drawable.cos_1, "Arco Cosseno") { it + "acos(" },
            CalculatorButton(R.drawable.tan_1, "Arco Tangente") { it + "atan(" },
            CalculatorButton(R.drawable.pi, "Pi") { it + "π" },
            CalculatorButton(R.drawable.e, "Número de Euler") { it + "e" }
        ),
        // Linha 3
        listOf(
            CalculatorButton(R.drawable.sinh, "Seno Hiperbólico") { it + "sinh(" },
            CalculatorButton(R.drawable.cosh, "Cosseno Hiperbólico") { it + "cosh(" },
            CalculatorButton(R.drawable.tanh, "Tangente Hiperbólica") { it + "tanh(" },
            CalculatorButton(R.drawable.log, "Logaritmo base 10") { it + "log(" },
            CalculatorButton(R.drawable.ln, "Logaritmo Natural") { it + "ln(" }
        ),
        // Linha 4
        listOf(
            CalculatorButton(R.drawable.asinh, "Arco Seno Hiperbólico") { it + "asinh(" },
            CalculatorButton(R.drawable.acosh, "Arco Cosseno Hiperbólico") { it + "acosh(" },
            CalculatorButton(R.drawable.atanh, "Arco Tangente Hiperbólica") { it + "atanh(" },
            CalculatorButton(R.drawable.div_x, "Inverso de x") { it + "1/" },
            CalculatorButton(R.drawable.percentage, "Porcentagem") { it + "%" }
        ),
        // Linha 5
        listOf(
            CalculatorButton(R.drawable.y_sqrt_x_, "Raiz y de x") { it + "^(1/" },
            CalculatorButton(R.drawable.three__sqrt_x_, "Raiz Cúbica") { it + "^(1/3)" },
            CalculatorButton(R.drawable.sqrt_x_, "Raiz Quadrada") { it + "sqrt(" },
            CalculatorButton(R.drawable.ten_x, "Dez elevado a x") { it + "10^" },
            CalculatorButton(R.drawable.n_fatorial, "Fatorial") { it + "!" }
        ),
        // Linha 6
        listOf(
            CalculatorButton(R.drawable.e_x, "e elevado a x") { it + "e^" },
            CalculatorButton(R.drawable.x_3, "x ao cubo") { it + "^3" },
            CalculatorButton(R.drawable.x_2, "x ao quadrado") { it + "^2" },
            CalculatorButton(R.drawable.x_y, "x elevado a y") { it + "^" },
            CalculatorButton(R.drawable.test, "Não implementado") { it } // Botão sem ação
        ),
        // Linha 7
        listOf(
            CalculatorButton(R.drawable.seven, "7") { it + "7" },
            CalculatorButton(R.drawable.eight, "8") { it + "8" },
            CalculatorButton(R.drawable.nine, "9") { it + "9" },
            CalculatorButton(R.drawable.plus, "Adicionar") { it + "+" },
            CalculatorButton(R.drawable.back, "Apagar") { it.dropLast(1) } // Ação de apagar o último caractere
        ),
        // Linha 8
        listOf(
            CalculatorButton(R.drawable.four, "4") { it + "4" },
            CalculatorButton(R.drawable.five, "5") { it + "5" },
            CalculatorButton(R.drawable.six, "6") { it + "6" },
            CalculatorButton(R.drawable.minus, "Subtrair") { it + "-" },
            CalculatorButton(R.drawable.ans, "Resposta anterior") { it + "Ans" } // Assumindo que "Ans" será uma variável
        ),
        // Linha 9
        listOf(
            CalculatorButton(R.drawable.one, "1") { it + "1" },
            CalculatorButton(R.drawable.two, "2") { it + "2" },
            CalculatorButton(R.drawable.three, "3") { it + "3" },
            CalculatorButton(R.drawable.multiply, "Multiplicar") { it + "*" },
            CalculatorButton(R.drawable.m_plus, "Memória Adicionar") { it } // Ação de memória não implementada
        ),
        // Linha 10
        listOf(
            CalculatorButton(R.drawable.clear, "Limpar tudo") { "" }, // Retorna uma string vazia para limpar
            CalculatorButton(R.drawable.zero, "0") { it + "0" },
            CalculatorButton(R.drawable.equal, "Igual") { exp -> Calculate(exp) }, // Chama sua função de cálculo
            CalculatorButton(R.drawable.divide, "Dividir") { it + "/" },
            CalculatorButton(R.drawable.m_minus, "Memória Subtrair") { it } // Ação de memória não implementada
        )
    )

    // Coluna principal de sustentaçao da UI
    Column  (modifier = Modifier
        .fillMaxSize()
    ) {

        // Tela onde aparece os números da calculadora
        Box(
            modifier = Modifier
                .weight(0.15f)
                .border(3.dp, Color.Red)
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .background(MaterialTheme.colorScheme.secondary),
            contentAlignment = Alignment.BottomEnd
        ) {
            Text(
                text = expression,
                style = MaterialTheme.typography.displayLarge,
                maxLines = 1,
                softWrap = false,
                modifier = Modifier.horizontalScroll(scrollState),
            )
        }


        Spacer(modifier = Modifier.height(8.dp))

        Column (
            modifier = Modifier
                .weight(0.85f)
                //.border (3.dp, Color.Green)
                .fillMaxSize()
        ) {
            calculatorLayout.forEach { rowOfButtons ->
                Row(modifier = Modifier.weight(1f)) {
                    rowOfButtons.forEach { buttonData ->
                        Btn(
                            modifier = baseButtonModifier.weight(1f), // O modifier que criamos no Passo 1
                            symbol = painterResource(id = buttonData.symbolId),
                            contentDescription = buttonData.description,
                            onClick = {
                                expression = buttonData.onClickAction(expression)
                            }
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorTheme {
        Display()
    }
}