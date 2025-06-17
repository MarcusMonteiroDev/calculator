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
import com.example.calculator.ui.theme.Dark_Button_Number
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

/*
PLANO
1 - Separar a construção do layout para que ele seja montado automaticamente da seguinte forma:
    - Criar um modifier padrão a ser adotado em todos os botões;
    - Criar uma lista de botões que será iterada para que cada linha se desenhe na tela
        - Para isso funcionar deve-se fazer uma lista maior que irá representar cada linha e, dentro
        dessa lista maior, várias listas menores que representam os botões daquela linha
        - O layout será desenhado iterando sobre a lista principal (responsável pela formação das
        linhas) e sobre a lista menor (responsável pela geração dos botões individuais).
2 - Adicionar a lógica aritimética para cada botão:
    - Cada botão deverá ser caáz de receber uma função que será usada para manipular a lógica
    do cálculo (usar funções de ordem superior (HOF))
*/

enum class ButtonCategory {
    NUMBER, OPERATOR, CLEAR, EQUALS
}

data class ButtonMold (
    val symbolId: Int,
    val contentDescription: String,
    val type: ButtonCategory,
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

    // Modifier padrão dos botões
    val baseButtonModifier: Modifier = Modifier
        .fillMaxSize()
        .padding(2.dp) // Adicionar um pequeno espaçamento entre os botões fica ótimo
        //.shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
        .clip(RoundedCornerShape(8.dp))

    // Lista de botões
    val buttons = listOf (
        listOf (
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ),
        listOf (
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ),
        listOf (
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
        ),
        listOf (
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
        ),
        listOf (
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
        ),
        listOf (
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
        ),
        listOf (
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
        ),
        listOf (
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
        ),
        listOf (
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
        ),
        listOf (
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
            ButtonMold (R.drawable.test, "test", ButtonCategory.NUMBER) {it },
        )
    )


    // Coluna principal de sustentaçao da UI
    Column  (modifier = Modifier
        .fillMaxSize()
        .background(Light_Background)
    ) {

        // Tela onde aparece os números da calculadora
        Box(
            modifier = Modifier
                .weight(0.2f)
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .background(Light_Display),
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

        // Desenho dos botões
        Column (
            modifier = Modifier
                .weight(1.0f)
                .fillMaxSize()
                .border(2.dp, Color.Red)
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
                            categoryButton = Color.Red,
                            onClick = { expression = element.onClickAction(expression) })
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