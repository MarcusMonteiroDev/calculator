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
        .clip(RoundedCornerShape(12.dp))

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
        .imePadding()
        .background(backgroundColor)
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        // Tela onde aparece os números da calculadora
        Box(
            modifier = Modifier
                .border(5.dp, Color.Red)
                .weight(0.2f)
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .background(backgroundColor),
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