package com.mamon.nestednavcompose.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
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
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mamon.nestednavcompose.ui.nav_graph.major_nav_graph.DashBoardGraph
import com.mamon.nestednavcompose.ui.nav_graph.utils.BottomNavItem
import com.mamon.nestednavcompose.ui.nav_graph.utils.Screens



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

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomAppBar(navController,navBackStackEntry)
        },
        content = {
            DashBoardGraph(navController = navController)
        }
    )
}


@Composable
private fun BottomAppBar(
    rootNavController: NavController,
    navBackStackEntry: State<NavBackStackEntry?>
) {

    NavigationBar {
        val selectedItem = getSelectedItem(items, navBackStackEntry.value?.destination?.route)
        items.forEach { item ->
            NavigationBarItem(
                selected = item == selectedItem,
                label = { Text(text = item.title) },
                icon = {
                    Icon(
                        imageVector = item.selectedIcon,
                        contentDescription = item.title
                    )
                },
                onClick = {
                    navigateTo(item.title.lowercase(), rootNavController)
                }
            )
        }
    }

}



private fun getSelectedItem(items: List<BottomNavItem>, destinationRoute: String?): BottomNavItem? {
    return items.find { item -> item.title.lowercase() == destinationRoute?.lowercase() }
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
    ),
    BottomNavItem(
        title = Screens.CART.label,
        selectedIcon = Icons.Filled.ShoppingCart,
        unselectedIcon = Icons.Outlined.ShoppingCart,
    ),
    BottomNavItem(
        title = Screens.SETTINGS.label,
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings,
    )
)

