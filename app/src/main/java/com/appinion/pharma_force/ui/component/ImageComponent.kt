package com.appinion.pharma_force.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.appinion.pharma_force.R

@Composable
fun ImageNormal(drawableId:Int= R.drawable.app_icon, height:Int=84, width:Int=120){
    Image(
        painterResource(drawableId),
        contentDescription = "logo",
        modifier = Modifier
            .height(height = height.dp)
            .width(width = width.dp)
    )
}

@Composable
fun CircleImage(drawableId:Int,size:Int){
    Card(
        modifier = Modifier.size(size.dp),
        shape = CircleShape,
        elevation = 2.dp
    ) {
        Image(
            painterResource(drawableId),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}