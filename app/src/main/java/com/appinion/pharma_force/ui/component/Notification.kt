package com.appinion.pharma_force.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appinion.pharma_force.feature.auth.component.CustomTextHeader
import com.appinion.pharma_force.ui.theme.*

@Composable
fun Notification(size: Int = 24, color: Color = BlueMedium, number: Int = 0) {

    if (number <= 0) {
        return
    }

    Card(
        modifier = Modifier.size(size = size.dp),
        shape = CircleShape,
        backgroundColor = selectColor(number = number),
        elevation = 6.dp

    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            Alignment.CenterHorizontally

        ) {
            CustomTextHeader(
                text = if (number >= 9) "9+" else number.toString(),
                textStyle = MaterialTheme.typography.h4,
                color = White
            )
        }

    }


}

fun selectColor(number: Int): Color {
    when {
        number >= 9 -> {
            return Red
        }
        number in 6..8 -> {
            return Yellow

        }
        number in 1..5 -> {
            return Green
        }
        else -> {

        }
    }

    return Yellow

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun NotificationPreview() {
    PharmaForceTheme {
        Notification()
    }

}