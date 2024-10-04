package com.example.myapplication.View

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.myapplication.Componentes.InputField
import com.example.myapplication.Componentes.SegmentedButtonGroup
import java.text.DecimalFormat
import kotlin.math.pow


@Composable
fun HomeView() {
    var selectedGender by remember { mutableStateOf("Hombre") }
    var edad by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var imcResult by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título
        Text(
            text = "Calculadora de IMC",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )


        SegmentedButtonGroup(
            options = listOf("Hombre", "Mujer"),
            selectedOption = selectedGender,
            onOptionSelected = {

                selectedGender = it
                edad = ""
                peso = ""
                altura = ""
                imcResult = ""
            }
        )


        InputField(
            value = edad,
            label = "Edad",
            onValueChange = { edad = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )


        InputField(
            value = peso,
            label = "Peso (Kg)",
            onValueChange = { peso = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )


        InputField(
            value = altura,
            label = "Altura (cm)",
            onValueChange = { altura = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(
            onClick = {
                imcResult = calcularIMC(peso, altura)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = when (selectedGender) {
                    "Hombre" -> Color.Blue
                    "Mujer" -> Color.Blue
                    else -> Color.LightGray
                },
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(text = "Calcular")
        }

        //Resultado del cálculo de IMC
        Text(
            text = "Resultado IMC: $imcResult",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}
// Función calcular el IMC
fun calcularIMC(pesoStr: String, alturaStr: String): String {
    val peso = pesoStr.toFloatOrNull()
    val altura = alturaStr.toFloatOrNull()

    return if (peso != null && altura != null && altura > 0) {
        val alturaEnMetros = altura / 100
        val imc = peso / alturaEnMetros.pow(2)
        // Formatear el resultado a 1 decimal
        DecimalFormat("#.#").format(imc)
    } else {
        "Datos inválidos"
    }
}
