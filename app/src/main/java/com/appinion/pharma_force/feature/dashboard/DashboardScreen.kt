package com.appinion.pharma_force.feature.dashboard

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
import androidx.compose.ui.tooling.preview.Preview
import com.appinion.pharma_force.R
import com.appinion.pharma_force.ui.theme.PharmaForceTheme
import com.appinion.pharma_force.utils.TopBar

@Composable
fun DashBoardScreen(openDrawer: () -> Unit,title:String="") {
    val context = LocalContext.current

        Column(modifier = Modifier.fillMaxSize()) {
            TopBar(
                buttonIcon = Icons.Filled.Menu,
                title = title,
                onButtonClicked = {
                    openDrawer()
                }
            )

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Home Page content here.")
            }
        }


}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DashPreview() {
    PharmaForceTheme {

    }

}