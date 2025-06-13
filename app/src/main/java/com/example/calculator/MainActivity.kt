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


@Composable
fun Display (modifier: Modifier = Modifier) {

    // Armazena a expressão matemática digitada
    var expression by remember { mutableStateOf("") }
    // Controla o estado de rolagem do display de texto
    val scrollState = rememberScrollState()
    // Rola suavemente o texto para manter sempre na posição final
    LaunchedEffect (expression) {
        scrollState.animateScrollTo (scrollState.maxValue)
    }
    // Modifier padrão dos botões
    val buttonModifier: Modifier = Modifier
        .fillMaxHeight()
        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
        .clip(RoundedCornerShape(8.dp))
        .background(Color.Cyan)
    //.clickable {onClick()}

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

            Row(modifier = Modifier.weight(0.1f).fillMaxWidth().border(3.dp, Color.Blue)) {
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.sin),
                    onClick = { expression += "sin" }
                )
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },

                    symbol = painterResource(R.drawable.cos),
                    onClick = { expression += "cos" }
                )
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.tan),
                    onClick = { expression += "tan" }
                )
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.test),
                    onClick = { expression += "" }
                )
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.test),
                    onClick = { expression += "" }
                )
            }

            Row(modifier = Modifier.weight(0.1f).fillMaxWidth().border(3.dp, Color.Blue)) {
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.sin_1),
                    onClick = { expression += "" }
                )
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.cos_1),
                    onClick = { expression += "" }
                )
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.tan_1),
                    onClick = { expression += "" }
                )
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.pi),
                    onClick = { expression += "" }
                )
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.e),
                    onClick = { expression += "" }
                )
            }

            Row(modifier = Modifier.weight(0.1f).fillMaxWidth().border(3.dp, Color.Blue)) {
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.sinh),
                    onClick = { expression += "" })
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.cosh),
                    onClick = { expression += "" })
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.tanh),
                    onClick = { expression += "" })
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.log),
                    onClick = { expression += "" })
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.ln),
                    onClick = { expression += "" })
            }

            Row(modifier = Modifier.weight(0.1f).fillMaxWidth().border(3.dp, Color.Blue)) {
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.asinh),
                    onClick = { expression += "" })
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.acosh),
                    onClick = { expression += "" })
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.atanh),
                    onClick = { expression += "" })
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.div_x),
                    onClick = { expression += "" })
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.percentage),
                    onClick = { expression += "" })
            }

            Row(modifier = Modifier.weight(0.1f).fillMaxWidth().border(3.dp, Color.Blue)) {
                // Raiz de y em x
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.y_sqrt_x_),
                    onClick = { expression += "" })
                // Raiz cúbica em x
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.three__sqrt_x_),
                    onClick = { expression += "" })
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.sqrt_x_),
                    onClick = { expression += "" })
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.ten_x),
                    onClick = { expression += "" })
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.n_fatorial),
                    onClick = { expression += "" })
            }

            Row(modifier = Modifier.weight(0.1f).fillMaxWidth().border(3.dp, Color.Blue)) {
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.e_x),
                    onClick = { expression += "" })
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.x_3),
                    onClick = { expression += "" })
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.x_2),
                    onClick = { expression += "" })
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.x_y),
                    onClick = { expression += "" })
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.test),
                    onClick = { expression += "" })
            }

            Row(modifier = Modifier.weight(0.1f).fillMaxWidth().border(3.dp, Color.Blue)) {
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.seven),
                    onClick = { expression += "7" })
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.eight),
                    onClick = { expression += "8" })
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.nine),
                    onClick = { expression += "9" })
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.plus),
                    onClick = { expression += "+" })
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.back),
                    onClick = { expression += "" })
            }

            Row(modifier = Modifier.weight(0.1f).fillMaxWidth().border(3.dp, Color.Blue)) {
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.four),
                    onClick = { expression += "4" })
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.five),
                    onClick = { expression += "5" })
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.six),
                    onClick = { expression += "6" })
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.minus),
                    onClick = { expression += "-" })
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.ans),
                    onClick = { expression += "" })
            }

            Row(modifier = Modifier.weight(0.1f).fillMaxWidth().border(3.dp, Color.Blue)) {
                Btn(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Cyan)
                        .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.one),
                    onClick = { expression += "1" })
                Btn(modifier = Modifier
                    .weight(0.2f)
                    .fillMaxHeight()
                    .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.Cyan)
                    .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.two),
                    onClick = { expression += "2" })
                Btn(modifier = Modifier
                    .weight(0.2f)
                    .fillMaxHeight()
                    .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.Cyan)
                    .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.three),
                    onClick = { expression += "3" })
                Btn(modifier = Modifier
                    .weight(0.2f)
                    .fillMaxHeight()
                    .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.Cyan)
                    .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.multiply),
                    onClick = { expression += "*" })
                Btn(modifier = Modifier
                    .weight(0.2f)
                    .fillMaxHeight()
                    .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.Cyan)
                    .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.m_plus),
                    onClick = { expression += "" })
            }

            Row(modifier = Modifier.weight(0.1f).fillMaxWidth().border(3.dp, Color.Blue)) {
                Btn(modifier = Modifier
                    .weight(0.2f)
                    .fillMaxHeight()
                    .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.Cyan)
                    .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.clear),
                    onClick = { expression = "" })
                Btn(modifier = Modifier
                    .weight(0.2f)
                    .fillMaxHeight()
                    .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.Cyan)
                    .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.zero),
                    onClick = { expression += "0" })
                Btn(modifier = Modifier
                    .weight(0.2f)
                    .fillMaxHeight()
                    .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.Cyan)
                    .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.equal),
                    onClick = { expression = Calculate(expression) })
                Btn(modifier = Modifier
                    .weight(0.2f)
                    .fillMaxHeight()
                    .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.Cyan)
                    .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.divide),
                    onClick = { expression += "/" })
                Btn(modifier = Modifier
                    .weight(0.2f)
                    .fillMaxHeight()
                    .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp))
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.Cyan)
                    .clickable { expression += "sin" },
                    symbol = painterResource(R.drawable.m_minus),
                    onClick = { expression += "" })
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