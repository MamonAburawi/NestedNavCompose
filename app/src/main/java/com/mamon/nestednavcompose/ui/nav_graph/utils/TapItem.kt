package com.mamon.nestednavcompose.ui.nav_graph.utils

import androidx.compose.ui.graphics.vector.ImageVector

data class TapItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector
)
