package com.appinion.pharma_force.feature.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appinion.pharma_force.R
import com.appinion.pharma_force.base.Routing
import com.appinion.pharma_force.feature.auth.component.CustomTextHeader
import com.appinion.pharma_force.ui.component.CustomSpacerWidth
import com.appinion.pharma_force.ui.component.ImageNormal
import com.appinion.pharma_force.ui.theme.OffWhite
import com.appinion.pharma_force.ui.theme.PharmaForceTheme


private val screens = listOf(
    Routing.DashBoardScreen,
    Routing.MedicineLibrary,
    Routing.CommunicationHub,
    Routing.DcrCrf,
    Routing.RxCalculator,
    Routing.IncentiveTracker,
    Routing.TestCenter,
    Routing.RenataShop,
    Routing.LeaderBoard,
    Routing.Logout
)

@Composable
fun Drawer(
    modifier: Modifier = Modifier,
    onDestinationClicked: (route: String) -> Unit
) {
    Column(
        modifier
            .fillMaxSize()
    ) {
        val context = LocalContext.current
        Surface(color = OffWhite) {
            TopbarLogo(
                title = context.getString(R.string.app_name),
                subTitle = context.getString(R.string.by_company_name)
            )
        }
        Spacer(Modifier.height(24.dp))

        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            screens.forEach { screen ->
                Row(
                    modifier = Modifier
                        .padding(24.dp, 12.dp)
                        .clickable { onDestinationClicked(screen.route) },
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    ImageNormal(screen.drawable, width = 32, height = 32)
                    CustomSpacerWidth(size = 16)
                    CustomTextHeader(
                        text = screen.title,
                        textStyle = MaterialTheme.typography.h2,
                        Color.Black
                    )

                }

            }

        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DrawerPreview() {
    PharmaForceTheme {
        // Drawer()
    }

}