package com.mamon.nestednavcompose.ui.nav_graph.bottom_nav


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mamon.nestednavcompose.ui.nav_graph.utils.Graph
import com.mamon.nestednavcompose.ui.nav_graph.utils.Screens
import com.mamon.nestednavcompose.ui.screens.Detail
import com.mamon.nestednavcompose.ui.screens.home.Home



fun NavGraphBuilder.homeNavGraph(navController: NavController) {
    navigation(route = Graph.HOME, startDestination = Screens.HOME.route){
        composable( route = Screens.HOME.route){
            Home(navController)
        }
        composable(route = Screens.DETAILS.route){
            Detail()
        }

    }
}


