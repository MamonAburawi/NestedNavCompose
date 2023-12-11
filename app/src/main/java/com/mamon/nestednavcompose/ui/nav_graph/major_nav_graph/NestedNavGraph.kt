package com.mamon.nestednavcompose.ui.nav_graph.major_nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mamon.nestednavcompose.ui.nav_graph.utils.Graph
import com.mamon.nestednavcompose.ui.screens.DashBoard

/**
    This navigation graph acts as the root container for hosting multiple nested navigation graphs.
    It allows you to organize and manage navigation across your entire application efficiently.
 **/


@Composable
fun NestedNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Graph.AUTH) {

        authNavGraph(route = Graph.AUTH, navController = navController)

        composable(route = Graph.DASHBOARD) {
            DashBoard()
        }
    }
}

