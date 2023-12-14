package com.mamon.nestednavcompose.ui.nav_graph.major_nav_graph


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mamon.nestednavcompose.ui.nav_graph.bottom_nav.cartNavGraph
import com.mamon.nestednavcompose.ui.nav_graph.bottom_nav.homeNavGraph
import com.mamon.nestednavcompose.ui.nav_graph.bottom_nav.settingsNavGraph
import com.mamon.nestednavcompose.ui.nav_graph.utils.Graph


/**  This navigation graph encompasses three major sections: Home, Cart, and Settings.
     Each section serves a distinct purpose and is connected to facilitate seamless navigation within the app,
     also each section has a separate graph  **/


@Composable
fun DashBoardGraph(navController: NavHostController) {
    var tapIndex by remember { mutableIntStateOf(0) }

    NavHost(navController = navController, startDestination = Graph.HOME) {

        homeNavGraph(navController)

        cartNavGraph(navController)

        settingsNavGraph(navController)

    }
}

