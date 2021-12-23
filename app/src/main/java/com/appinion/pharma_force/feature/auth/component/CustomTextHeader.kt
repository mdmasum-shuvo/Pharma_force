package com.appinion.pharma_force.feature.auth.component

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.*
import com.appinion.pharma_force.R
import com.appinion.pharma_force.ui.theme.BlueMedium

@Composable
fun CustomTextHeader(text: String, textStyle: TextStyle) {
    Text(
        text = text, style = textStyle, color = BlueMedium,
    )

}