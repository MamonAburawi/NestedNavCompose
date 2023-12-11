package com.mamon.nestednavcompose.ui.nav_graph.bottom_nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.mamon.nestednavcompose.ui.nav_graph.utils.Graph
import com.mamon.nestednavcompose.ui.nav_graph.utils.Screens
import com.mamon.nestednavcompose.ui.screens.Favorite
import com.mamon.nestednavcompose.ui.screens.Profile
import com.mamon.nestednavcompose.ui.screens.Settings


fun NavGraphBuilder.settingsNavGraph(navController: NavController) {

    navigation(route = Graph.SETTINGS, startDestination = Screens.SETTINGS.route) {
        composable( route =  Screens.SETTINGS.route){
            Settings(navController)
        }
        composable(route = Screens.PROFILE.route){
            Profile(navController)
        }
        composable(route = Screens.FAVORITE.route){
            Favorite()
        }
    }
}

