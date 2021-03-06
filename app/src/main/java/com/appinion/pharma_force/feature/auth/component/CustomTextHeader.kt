package com.appinion.pharma_force.feature.auth.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.style.TextAlign
import com.appinion.pharma_force.ui.theme.BlueMedium

@Composable
fun CustomTextHeader(text: String, textStyle: TextStyle, color: Color = BlueMedium) {
    Text(
        text = text, style = textStyle, color = color, textAlign = TextAlign.Center,
    )
}


@Composable
fun CustomTextStart(text: String, textStyle: TextStyle, color: Color = BlueMedium) {
    Text(
        text = text, style = textStyle, color = color, textAlign = TextAlign.Start, maxLines = 3
    )
}