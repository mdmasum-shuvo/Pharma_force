package com.appinion.pharma_force.feature.dashboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.appinion.pharma_force.feature.common.TopBar
import com.appinion.pharma_force.feature.dashboard.component.DashBoardItem
import com.appinion.pharma_force.feature.dashboard.data.FakeDataList
import com.appinion.pharma_force.ui.theme.PharmaForceTheme

@ExperimentalFoundationApi
@Composable
fun DashBoardScreen(openDrawer: () -> Unit, title: String = "") {
    Surface(color = MaterialTheme.colors.background) {
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
            ) {
                LazyVerticalGrid(cells = GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
                    items(FakeDataList.getFakeDataList()) { item ->
                        DashBoardItem(dashBoardItem = item, onItemClick = {

                        })
                    }
                }
            }
        }

    }


}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DashPreview() {
    PharmaForceTheme {

    }

}