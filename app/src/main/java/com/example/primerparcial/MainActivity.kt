package com.example.primerparcial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.primerparcial.ui.theme.PrimerParcialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrimerParcialTheme {
                val navController = rememberNavController()
                val total = remember { mutableIntStateOf(100000) }

                NavHost(
                    navController = navController,
                    startDestination = "inicio"
                ) {
                    composable(route = "inicio") {
                        Inicio(navController, total)
                    }

                    composable(route = "comprobante/{monto}") {
                        backStack -> val monto = backStack.arguments?.getString("monto")?.toInt()
                        Comprobante(monto = monto)
                    }
                }
            }
        }
    }
}
