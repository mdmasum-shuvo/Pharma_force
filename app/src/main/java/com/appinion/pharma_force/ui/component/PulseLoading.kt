package com.appinion.pharma_force.ui.component

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog


@Composable
fun PulseLoading(
    durationMillis: Int = 1000,
    maxPulseSize: Float = 300f,
    minPulseSize: Float = 50f,
    pulseColor: Color = Color(234, 240, 246),

) {

    Dialog(onDismissRequest ={}) {
        val infiniteTransition = rememberInfiniteTransition()
        val size = infiniteTransition.animateFloat(
            initialValue = minPulseSize,
            targetValue = maxPulseSize,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            )
        )
        val alpha = infiniteTransition.animateFloat(
            initialValue = 1f,
            targetValue = 0f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            )
        )
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Card(
                shape = CircleShape,
                modifier = Modifier
                    .size(size.value.dp)
                    .align(Alignment.Center)
                    .alpha(alpha.value),
                backgroundColor = pulseColor,
                elevation = 0.dp
            ) {}
            Column(
                modifier = Modifier
                    .size(minPulseSize.dp)
                    .align(Alignment.Center),
            ) {
                ImageNormal(height = 64, width = 100)
            }
        }

    }


}

@Composable
fun CustomDialogWithResultExample(
    onDismiss: () -> Unit,
) {


    Dialog(onDismissRequest = onDismiss) {
        ImageNormal(height = 64, width = 100)
    }

}