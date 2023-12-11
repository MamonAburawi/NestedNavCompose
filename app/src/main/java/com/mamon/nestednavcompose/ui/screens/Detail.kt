package com.mamon.nestednavcompose.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.mamon.nestednavcompose.ui.nav_graph.utils.Screens

@Composable
fun Detail() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Text(
            color = Color.Green,
            text = Screens.DETAILS.label,
            fontSize = 35.sp
        )

    }
}
