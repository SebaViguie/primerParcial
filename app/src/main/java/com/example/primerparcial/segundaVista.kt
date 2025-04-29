package com.example.primerparcial

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.primerparcial.ui.theme.PrimerParcialTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Comprobante(monto: Int?) {

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {Text(text = "Comprobante", style = MaterialTheme.typography.headlineLarge)},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        content = {paddingValues ->
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.primaryContainer),
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                Spacer(modifier = Modifier.height(40.dp))

                Text(text = "Retiro exitoso", color = Color(0xFF2E7D32), style = MaterialTheme.typography.displaySmall)

                Spacer(modifier = Modifier.height(40.dp))

                Text(text = "Monto retirado", style = MaterialTheme.typography.titleLarge)

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "$$monto", style = MaterialTheme.typography.displayLarge)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ComprobantePreview() {
    PrimerParcialTheme {
        Comprobante(monto = 2000)
    }
}
