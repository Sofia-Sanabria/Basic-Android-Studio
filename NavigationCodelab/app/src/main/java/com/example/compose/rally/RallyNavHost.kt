package com.example.compose.rally

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compose.rally.ui.accounts.AccountsScreen
import com.example.compose.rally.ui.accounts.SingleAccountScreen
import com.example.compose.rally.ui.bills.BillsScreen
import com.example.compose.rally.ui.overview.OverviewScreen

@Composable
fun RallyNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    // Define la estructura de navegación y sus rutas
    NavHost(
        navController = navController,
        startDestination = Overview.route, // pantalla inicial
        modifier = modifier
    ) {
        // Pantalla de resumen con botones para navegar a cuentas y facturas
        composable(route = Overview.route) {
            OverviewScreen(
                onClickSeeAllAccounts = {
                    navController.navigateSingleTopTo(Accounts.route)
                },
                onClickSeeAllBills = {
                    navController.navigateSingleTopTo(Bills.route)
                },
                onAccountClick = { accountType ->
                    navController.navigateToSingleAccount(accountType)
                }
            )
        }

        // Pantalla que lista todas las cuentas
        composable(route = Accounts.route) {
            AccountsScreen(
                onAccountClick = { accountType ->
                    navController.navigateToSingleAccount(accountType)
                }
            )
        }

        // Pantalla que muestra las facturas
        composable(route = Bills.route) {
            BillsScreen()
        }

        // Pantalla de detalle de cuenta con argumento dinamico accountType
        composable(
            route = SingleAccount.routeWithArgs,
            arguments = SingleAccount.arguments,
            deepLinks = SingleAccount.deepLinks
        ) { navBackStackEntry ->
            // Recupera el argumento pasado por la ruta
            val accountType =
                navBackStackEntry.arguments?.getString(SingleAccount.accountTypeArg)

            // Solo muestra si accountType no es nulo
            accountType?.let {
                SingleAccountScreen(accountType = it)
            }
        }
    }
}

// Navega a la pantalla de cuenta individual usando la ruta con argumento
private fun NavHostController.navigateToSingleAccount(accountType: String) {
    this.navigate("${SingleAccount.route}/$accountType") {
        launchSingleTop = true // Evita duplicar pantallas en el backstack
        restoreState = false   // No conserva estado previo para forzar recomposición
    }
}

// Navega a una pantalla sin duplicar entradas en el backstack
fun NavHostController.navigateSingleTopTo(route: String) = this.navigate(route) {
    popUpTo(
        this@navigateSingleTopTo.graph.findStartDestination().id
    ) {
        saveState = true
    }
    launchSingleTop = true
    restoreState = true
}

