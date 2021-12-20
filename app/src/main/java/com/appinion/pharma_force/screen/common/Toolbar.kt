package com.appinion.pharma_force.screen.common

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.appinion.pharma_force.ui.theme.BlueMedium
import com.appinion.pharma_force.ui.theme.PharmaForceTheme
import com.appinion.pharma_force.ui.theme.White

@Composable
fun Toolbar(title: String = "", buttonIcon: ImageVector, onButtonClicked: () -> Unit) {

    TopAppBar(
        title = {
            Text(text = title,color = BlueMedium)
        },
        navigationIcon = {
            IconButton(onClick = { onButtonClicked }) {
                Icon(buttonIcon, contentDescription = "",tint = BlueMedium)

            }
        },
        backgroundColor = White
    )
}

@Preview(showSystemUi = true,showBackground = true)
@Composable
fun ToolbarPreview() {
    PharmaForceTheme {
        Toolbar(title = "Home",buttonIcon = Icons.Filled.Menu,onButtonClicked = {})
    }

}