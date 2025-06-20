package com.example.compose.rally

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.MoneyOff
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink

// Interfaz base para definir un destino de navegación
sealed interface RallyDestination {
    val icon: ImageVector // ícono que se muestra en la barra superior
    val route: String     // ruta única para identificar la pantalla
}

// Objeto que representa la pantalla de resumen (overview)
data object Overview : RallyDestination {
    override val icon = Icons.Filled.PieChart
    override val route = "overview"
}

// Objeto que representa la pantalla de cuentas
data object Accounts : RallyDestination {
    override val icon = Icons.Filled.AttachMoney
    override val route = "accounts"
}

// Objeto que representa la pantalla de facturas
data object Bills : RallyDestination {
    override val icon = Icons.Filled.MoneyOff
    override val route = "bills"
}

// Objeto que representa la pantalla de detalle de una cuenta individual
data object SingleAccount : RallyDestination {
    override val icon = Icons.Filled.Money // Este icono no se usa directamente
    override val route = "single_account" // Ruta base sin argumentos

    // Clave del argumento que se pasa por la ruta (tipo de cuenta)
    const val accountTypeArg = "account_type"

    // Ruta completa con el argumento para navegación dinámica
    val routeWithArgs = "$route/{$accountTypeArg}"

    // Lista de argumentos esperados en esta ruta
    val arguments = listOf(
        navArgument(accountTypeArg) { type = NavType.StringType }
    )

    // Deep link para permitir acceso externo directo a esta pantalla
    val deepLinks = listOf(
        navDeepLink { uriPattern = "rally://$route/{$accountTypeArg}" }
    )
}

// Lista de pantallas principales que se muestran en la barra superior
val rallyTabRowScreens = listOf(Overview, Accounts, Bills)

