package com.appinion.pharma_force.feature.testing_center

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.appinion.pharma_force.utils.TopBar

@Composable
fun TestCenterScreen(navController: NavController) {
    Surface() {

        Column() {
            TopBar(
                buttonIcon = Icons.Filled.ArrowBack,
                title = "Test Center",
                onButtonClicked = { navController.popBackStack() })
            Text(
                text ="Test Center",
                style = MaterialTheme.typography.h1
            )
        }


    }

}