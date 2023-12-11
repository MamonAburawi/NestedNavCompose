package com.mamon.nestednavcompose.ui.nav_graph.bottom_nav


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mamon.nestednavcompose.ui.nav_graph.utils.Graph
import com.mamon.nestednavcompose.ui.nav_graph.utils.Screens
import com.mamon.nestednavcompose.ui.screens.Cart


fun NavGraphBuilder.cartNavGraph(navController: NavController) {

    navigation(route = Graph.CART, startDestination = Screens.CART.route){
        composable( route = Screens.CART.route) {
            Cart()
        }
    }
}

