package com.mamon.nestednavcompose.ui.nav_graph.major_nav_graph


import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mamon.nestednavcompose.ui.nav_graph.utils.Screens
import com.mamon.nestednavcompose.ui.screens.Login
import com.mamon.nestednavcompose.ui.screens.SignUp


fun NavGraphBuilder.authNavGraph(route: String ,navController: NavHostController) {
    navigation(route = route, startDestination = Screens.LOGIN.route){

        composable(route = Screens.LOGIN.route) {
            Login(navController = navController)
        }

        composable(route = Screens.SIGNUP.route){
            SignUp(navController = navController)
        }

    }
}
