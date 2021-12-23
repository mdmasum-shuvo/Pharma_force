package com.appinion.pharma_force.feature.auth.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.appinion.pharma_force.ui.theme.BlueMedium
import com.appinion.pharma_force.ui.theme.White

@Composable
fun CustomRoundButton(text: String, height: Int, width: Int, round: Int) {
    Button(
        modifier = Modifier
            .height(height.dp)
            .width(width.dp)
            .fillMaxWidth(), onClick = {
        },
        shape = RoundedCornerShape(round.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = White,
            backgroundColor = BlueMedium
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.body2,
            color = White
        )
    }
}