package com.mamon.nestednavcompose.ui.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mamon.nestednavcompose.ui.nav_graph.major_nav_graph.DashBoardGraph
import com.mamon.nestednavcompose.ui.nav_graph.utils.BottomNavItem
import com.mamon.nestednavcompose.ui.nav_graph.utils.Screens
import com.mamon.nestednavcompose.ui.theme.DarkBlue
import com.mamon.nestednavcompose.ui.theme.Orange


/**
This composable function, named "Dashboard," serves as the primary landing page for users after successful login,
also support navigation bottoms with nested navigation: These provide convenient access to various sections or features within the application.
 **/

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashBoard() {

    val navController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    var isVisible by remember{ mutableStateOf(true) }

    // listing on current destination
    navController.addOnDestinationChangedListener { controller, destination, arguments ->
        Log.d("DashBoard","current destination: ${destination.route}")
        isVisible = destination.route == "Home" || destination.route == "Cart" || destination.route == "Settings"
    }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomAppBar(navController,navBackStackEntry,isVisible)
        },
        content = {
            DashBoardGraph(navController = navController)
        }

    )

}


@Composable
private fun BottomAppBar(
    rootNavController: NavController,
    navBackStackEntry: State<NavBackStackEntry?>,
    isVisible: Boolean = true
){
    val selectedItemRoute = navBackStackEntry.value?.destination?.route?.lowercase()
    AnimatedVisibility (isVisible){
        NavigationBar(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp)),
            containerColor = DarkBlue
        ) {
            items.forEach { item ->
                val selected = item.route.lowercase() == selectedItemRoute
                NavigationBarItem(
                    selected = selected,
                    label = {
                        if (selected){
                            Text(
                                color = Color.White,
                                text = item.title,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    },
                    icon = {
                        Icon(
                            modifier = Modifier.size(28.dp),
                            imageVector = item.selectedIcon,
                            contentDescription = item.title,
                            tint = Orange
                        )
                    },
                    onClick = {
                        navigateTo(item.route.lowercase(), rootNavController)
                    }
                )
            }
        }
    }

}


private fun navigateTo(route: String, navController: NavController) {
    navController.navigate(route) {
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}


private val items = listOf(
    BottomNavItem(
        title = Screens.HOME.label,
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        route = "Home"

    ),
    BottomNavItem(
        title = Screens.CART.label,
        selectedIcon = Icons.Filled.ShoppingCart,
        unselectedIcon = Icons.Outlined.ShoppingCart,
        route = "Cart"
    ),
    BottomNavItem(
        title = Screens.SETTINGS.label,
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings,
        route = "Settings"
    )
)


@Preview
@Composable
fun DashBoardPreview() {
    DashBoard()
}
@Composable
@Preview(showBackground = true)
fun CustomBottomBarPreview() {
    val navController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntryAsState()

    BottomAppBar(rootNavController = navController, navBackStackEntry = navBackStackEntry)
}
