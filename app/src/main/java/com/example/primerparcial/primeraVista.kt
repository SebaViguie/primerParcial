package com.example.primerparcial

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.primerparcial.ui.theme.PrimerParcialTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Inicio(navController: NavController, total: MutableState<Int>) {
    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text(text = "Billetera virtual", style = MaterialTheme.typography.headlineLarge) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        content = {paddingValues ->

            var inputRetiro by remember { mutableStateOf("") }
            var errorText by remember { mutableStateOf("") }

            Column(modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.primaryContainer),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Spacer(modifier = Modifier.height(40.dp))

                Text(text = "Monto total", style = MaterialTheme.typography.titleLarge)

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "$${total.value}", style = MaterialTheme.typography.displayLarge)

                Spacer(modifier = Modifier.height(40.dp))

                Text(text = "A retirar:", style = MaterialTheme.typography.titleLarge)

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(value = inputRetiro,
                    label = { Text(text = "Efectivo") },
                    onValueChange = {inputRetiro = it}
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = {
                    val monto = inputRetiro.toInt()

                    if (monto <= total.value) {
                        navController.navigate(route = "comprobante/$monto")
                        total.value -= monto
                    } else {
                        errorText = "El monto a retirar no puede superar el total"
                    }
                })
                {
                    Text(text = "Confirmar")
                }

                Spacer(modifier = Modifier.height(16.dp))

                if (errorText.isNotEmpty()) {
                    Text(
                        text = errorText,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun InicioPreview() {
    PrimerParcialTheme {
        Inicio(navController = rememberNavController(), total = remember { mutableIntStateOf(100000) } )
    }
}