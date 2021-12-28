package com.appinion.pharma_force.feature.dashboard.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ElevationOverlay
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appinion.pharma_force.R
import com.appinion.pharma_force.feature.auth.component.CustomTextHeader
import com.appinion.pharma_force.feature.auth.component.CustomTextStart
import com.appinion.pharma_force.feature.dashboard.data.DashBoardModel
import com.appinion.pharma_force.ui.component.CustomSpacerWidth
import com.appinion.pharma_force.ui.component.ImageNormal
import com.appinion.pharma_force.ui.component.Notification
import com.appinion.pharma_force.ui.theme.BlueMedium
import com.appinion.pharma_force.ui.theme.Gray
import com.appinion.pharma_force.ui.theme.PharmaForceTheme
import com.appinion.pharma_force.ui.theme.Red

@Composable
fun DashBoardItem(
    dashBoardItem: DashBoardModel,
    onItemClick: (DashBoardModel) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .clickable { onItemClick(dashBoardItem) }
    ) {
        Card(
            modifier = Modifier.size(height = 156.dp, width = 168.dp),
            shape = MaterialTheme.shapes.large,
            elevation = 0.5.dp

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp, 16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ImageNormal(drawableId = dashBoardItem.image, height = 64, width = 64)
                    Notification(color = Red, number = dashBoardItem.number)
                }
                CustomTextStart(
                    text = dashBoardItem.title,
                    textStyle = MaterialTheme.typography.h2,
                    color = Color.Black
                )

                CustomTextStart(
                    text = dashBoardItem.body,
                    textStyle = MaterialTheme.typography.h4,
                    color = Gray,

                    )


            }
        }
    }


}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DashPreview() {
    PharmaForceTheme {
        //DashBoardItem()
    }

}