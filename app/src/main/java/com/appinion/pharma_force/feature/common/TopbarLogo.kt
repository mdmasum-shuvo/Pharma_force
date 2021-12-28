package com.appinion.pharma_force.feature.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.appinion.pharma_force.R
import com.appinion.pharma_force.feature.auth.component.CustomTextHeader
import com.appinion.pharma_force.ui.component.ImageNormal

@Composable
fun TopbarLogo(title:String,subTitle:String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(24.dp),
    ) {
        ImageNormal(height = 32, width = 32)
        Column(modifier = Modifier.padding(2.dp, 0.dp)) {
            CustomTextHeader(
                text = title,
                textStyle = MaterialTheme.typography.h3
            )
            CustomTextHeader(
                text = subTitle,
                textStyle = MaterialTheme.typography.h4
            )

        }
    }
}