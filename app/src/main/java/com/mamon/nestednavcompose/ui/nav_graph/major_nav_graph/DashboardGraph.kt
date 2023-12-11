package com.mamon.nestednavcompose.ui.nav_graph.major_nav_graph


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mamon.nestednavcompose.ui.nav_graph.bottom_nav.CartNavGraph
import com.mamon.nestednavcompose.ui.nav_graph.bottom_nav.HomeNavGraph
import com.mamon.nestednavcompose.ui.nav_graph.bottom_nav.SettingsNavGraph
import com.mamon.nestednavcompose.ui.nav_graph.utils.Screens


/**  This navigation graph encompasses three major sections: Home, Cart, and Settings.
     Each section serves a distinct purpose and is connected to facilitate seamless navigation within the app,
     also each section has a separate graph  **/

@Composable
fun DashBoardGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.HOME.route) {

        composable(route = Screens.HOME.route) {
            HomeNavGraph()
        }

        composable(route = Screens.CART.route) {
            CartNavGraph()
        }

        composable(route = Screens.SETTINGS.route) {
            SettingsNavGraph()
        }

    }
}

