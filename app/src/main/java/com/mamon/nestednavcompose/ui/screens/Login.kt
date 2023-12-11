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
import com.mamon.nestednavcompose.ui.nav_graph.utils.Graph
import com.mamon.nestednavcompose.ui.nav_graph.utils.Screens

@Composable
fun Login(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                color = Color.Black,
                text = Screens.LOGIN.label,
                fontSize = 35.sp
            )

            Spacer(modifier = Modifier.height(50.dp))
            Button(onClick = {
                navController.navigate(route = Screens.SIGNUP.route)
            }) {
                Text(text = "Go to SignUp")
            }

            Spacer(modifier = Modifier.height(50.dp))
            Button(
                onClick = {
                navController.popBackStack() // for remove the current destination from back stack
                navController.navigate(route = Graph.DASHBOARD)
            }) {
                Text(text = "Go to Dashboard")
            }

        }

    }
}