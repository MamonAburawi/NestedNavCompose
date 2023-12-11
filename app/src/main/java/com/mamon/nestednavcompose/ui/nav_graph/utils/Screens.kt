package com.mamon.nestednavcompose.ui.nav_graph.utils


sealed class Screens(
    val route: String,
    val label: String
)  {
    object CART: Screens(
        route = "Cart",
        label = "Cart"
    )
    object DETAILS: Screens(
        route = "Detail",
        label = "Detail"
    )
    object FAVORITE: Screens(
        route = "Favorite",
        label = "Favorite"
    )
    object HOME: Screens(
        route = "Home",
        label = "Home"
    )
    object LOGIN: Screens(
        route = "Login",
        label = "Login"
    )
    object PROFILE: Screens(
        route = "Profile",
        label = "Profile"
    )
    object SETTINGS: Screens(
        route = "Settings",
        label = "Settings"
    )
    object SIGNUP: Screens(
        route = "SignUp",
        label = "SignUp"
    )
}