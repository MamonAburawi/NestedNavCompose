package com.mamon.nestednavcompose.ui.nav_graph.bottom_nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mamon.nestednavcompose.ui.nav_graph.utils.Screens
import com.mamon.nestednavcompose.ui.screens.Cart

@Composable
fun CartNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.CART.route){
        composable( route =  Screens.CART.route){
            Cart()
        }
    }
}


