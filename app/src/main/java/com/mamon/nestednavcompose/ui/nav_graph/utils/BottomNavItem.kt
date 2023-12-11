package com.mamon.nestednavcompose.ui.nav_graph.utils

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector
)