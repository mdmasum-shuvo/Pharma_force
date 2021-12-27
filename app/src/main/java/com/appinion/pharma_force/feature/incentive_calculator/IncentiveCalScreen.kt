package com.appinion.pharma_force.feature.incentive_calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.appinion.pharma_force.R
import com.appinion.pharma_force.base.Routing
import com.appinion.pharma_force.utils.TopBar

@Composable
fun IncentiveCalculatorScreen(navController: NavController, title: String = "") {
    val context = LocalContext.current
    Surface {
        Column(modifier = Modifier.fillMaxSize()) {
            TopBar(
                buttonIcon = Icons.Filled.ArrowBack,
                title = title,
                onButtonClicked = { navController.popBackStack() })

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "IncentiveCalculator.", style = MaterialTheme.typography.h4)

                Button(onClick = { navController.navigate(Routing.RenataShop.route) }) {

                }
            }

        }
    }
}