package com.mamon.nestednavcompose.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mamon.nestednavcompose.ui.nav_graph.utils.Screens

@Composable
fun Home(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                color = Color.Red,
                text = Screens.HOME.label,
                fontSize = 35.sp
            )
            Spacer(modifier = Modifier.height(50.dp))
            Button(
                onClick = {
                navController.navigate(route = Screens.DETAILS.route)
            }) {
                Text(text = "Go to Detail")
            }

        }

    }
}