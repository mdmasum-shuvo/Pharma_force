package com.appinion.pharma_force.feature.shop

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.appinion.pharma_force.base.Routing
import com.appinion.pharma_force.feature.common.TopBar

@Composable
fun RenataShopScreen(navController: NavController) {
    Surface() {

        Column() {
            TopBar(
                buttonIcon = Icons.Filled.ArrowBack,
                title = "shop",
                onButtonClicked = { navController.popBackStack() })
            Text(
                text = "shop",
                style = MaterialTheme.typography.h1
            )

            Button(onClick = { navController.navigate(Routing.TestCenter.route) }) {

            }
        }


    }

}