package com.mamon.nestednavcompose.ui.nav_graph.bottom_nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mamon.nestednavcompose.ui.nav_graph.utils.Screens
import com.mamon.nestednavcompose.ui.screens.Detail
import com.mamon.nestednavcompose.ui.screens.Home


@Composable
fun HomeNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.HOME.route){
        composable( route =  Screens.HOME.route){
            Home(navController)
        }
        composable(route = Screens.DETAILS.route){
            Detail()
        }
    }
}



