package org.d3if3086.assessment3.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.d3if3086.assessment3.ui.screen.AboutScreen
import org.d3if3086.assessment3.ui.screen.DetailScreen
import org.d3if3086.assessment3.ui.screen.KEY_ID_BAKSO
import org.d3if3086.assessment3.ui.screen.LokasiScreen
import org.d3if3086.assessment3.ui.screen.MainScreen

@Composable
fun SetupNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            MainScreen(navController)
        }
        composable(route = Screen.FormBaru.route) {
            DetailScreen(navController)
        }
        composable(
            route = Screen.FormUbah.route,
            arguments = listOf(
                navArgument(KEY_ID_BAKSO) { type = NavType.LongType }
            )
        ) { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getLong(KEY_ID_BAKSO)
            DetailScreen(navController, id)
        }
        composable(route = Screen.About.route) {
            AboutScreen(navController)
        }
        composable(route = Screen.Lokasi.route) {
            LokasiScreen(navController)
        }
    }
}