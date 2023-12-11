package com.mamon.nestednavcompose.ui.nav_graph.bottom_nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mamon.nestednavcompose.ui.screens.Favorite
import com.mamon.nestednavcompose.ui.screens.Profile
import com.mamon.nestednavcompose.ui.screens.Settings

@Composable
fun SettingsNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Settings") {
        composable( route =  "Settings"){
            Settings(navController)
        }
        composable(route = "Profile"){
            Profile(navController)
        }
        composable(route = "Favorite"){
            Favorite()
        }
    }
}







