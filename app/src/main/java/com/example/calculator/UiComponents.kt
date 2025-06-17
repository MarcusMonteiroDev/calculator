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
import android.util.Log
import androidx.compose.material3.TextFieldDefaults
import androidx.annotation.DrawableRes
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.TextField
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.Dark_Button_Clear
import com.example.calculator.ui.theme.Dark_Button_Equals
import com.example.calculator.ui.theme.Dark_Button_Number
import com.example.calculator.ui.theme.Dark_Button_Operator
import com.example.calculator.ui.theme.Light_Button_Clear
import com.example.calculator.ui.theme.Light_Button_Equals
import com.example.calculator.ui.theme.Light_Button_Number
import com.example.calculator.ui.theme.Light_Button_Operator

@Composable
fun Btn(
    modifier: Modifier = Modifier,
    symbol: Painter,
    contentDescription: String? = null,
    categoryButton: ButtonCategory,
    onClick: () -> Unit
) {
    // Verifica se o tema é claro ou escuro
    val isDarkTheme = isSystemInDarkTheme()

    // Cor do texto dos botões
    val iconColor = when (isDarkTheme) {
        true -> Light_Button_Number
        false -> Dark_Button_Number
    }

    // Determina as cores dos componentes
    val backgroundColor = if (!isDarkTheme) {
        // Cores do tema claro
        when (categoryButton) {
            ButtonCategory.NUMBER -> Light_Button_Number
            ButtonCategory.CLEAR -> Light_Button_Clear
            ButtonCategory.EQUALS -> Light_Button_Equals
            ButtonCategory.OPERATOR -> Light_Button_Operator
            else -> Color.Black
        }
    }
    else {
        // Cores do tema escuro
        when (categoryButton) {
            ButtonCategory.NUMBER -> Dark_Button_Number
            ButtonCategory.CLEAR -> Dark_Button_Clear
            ButtonCategory.EQUALS -> Dark_Button_Equals
            ButtonCategory.OPERATOR -> Dark_Button_Operator
            else -> Color.Black
        }
    }

    // Essa Row vai funcionar como a parte clicável do botão, servindo apenas para a estilização
    // O Button em si não é estilizado pois não fornece amplas opções de estilização
    Box (
        modifier = modifier
            .clickable (onClick = onClick)
            .background(
                backgroundColor
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon (painter = symbol,
            contentDescription = contentDescription,
            tint = iconColor
            )
    }
}

/*@Preview (showBackground = true)
@Composable
fun UiPreview () {
    Column (modifier = Modifier.fillMaxSize()) {
        Btn (symbol = painterResource(R.drawable.one), onClick = {/*todo*/})
    }
}*/