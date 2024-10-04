package com.example.myapplication.Componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@Composable
fun SegmentedButtonGroup(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        options.forEach { option ->
            Button(
                onClick = { onOptionSelected(option) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (option == selectedOption) Color.Blue else Color.LightGray,
                    contentColor = Color.White
                ),
                modifier = Modifier.padding(4.dp)
            ) {
                Text(text = option)
            }
        }
    }
}


@Composable
fun InputField(
    value: String,
    label: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    )
}

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Text(text, color = Color.White)
    }
}

@Composable
fun CalculadoraIMCApp() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
        }
    }
}

@Composable
fun InputField(
    value: String,
    label: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        keyboardOptions = keyboardOptions
    )
}

