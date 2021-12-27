package com.appinion.pharma_force.feature.communication_hub

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.appinion.pharma_force.R
import com.appinion.pharma_force.utils.TopBar

@Composable
fun CommunicationHubScreen(openDrawer: () -> Unit,title:String="") {
    Surface{
        Column(modifier = Modifier.fillMaxSize()) {
            TopBar(
                buttonIcon = Icons.Filled.Menu,
                title =title,
                onButtonClicked = { openDrawer() })

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "CommunicationHubScreen", style = MaterialTheme.typography.h4)
            }

        }

    }


}