package com.example.compose.rally

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.compose.rally.ui.components.RallyTabRow
import com.example.compose.rally.ui.theme.RallyTheme

// Clase principal de la app que se lanza al iniciar
class RallyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Llama al Composable principal de la app
            RallyApp()
        }
    }
}

// Composable principal que define la estructura de navegación y UI de la app
@Composable
fun RallyApp() {
    // Aplica el tema personalizado de la app
    RallyTheme {
        // Crea un controlador de navegación
        val navController = rememberNavController()

        // Obtiene el estado actual del backstack de navegación
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination

        // Determina qué pantalla mostrar en la TabRow
        val currentScreen =
            rallyTabRowScreens.find { it.route == currentDestination?.route } ?: Accounts

        // Scaffold con barra superior personalizada
        Scaffold(
            topBar = {
                RallyTabRow(
                    allScreens = rallyTabRowScreens, // las 3 pantallas principales
                    onTabSelected = { newScreen ->
                        navController.navigateSingleTopTo(newScreen.route)
                    },
                    currentScreen = currentScreen
                )
            }
        ) { innerPadding ->
            // Llama al NavHost que contiene las rutas declaradas
            RallyNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}


