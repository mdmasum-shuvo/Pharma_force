package com.appinion.pharma_force.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/**
 * @author MD. Masum Talukder
 * use it as a custom typography
 * Set of Material typography styles to start with
 * for getting custom behaviour
 * copy h1-h6 text style
 * copy body text style
 */
val Typography = Typography(

    h1 = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Medium,
        color = BlueMedium,
        fontSize = 16.sp
    ),
    h2 = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Bold,
        color = BlueMedium,
        fontSize = 14.sp
    ),

    h3 = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Bold,
        color = BlueMedium,
        fontSize = 12.sp
    ),
    h4 = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        color = BlueMedium,
        fontSize = 10.sp
    ),

    h5 = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        color = BlueMedium,
        fontSize = 10.sp
    ),

    h6 = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        color = BlueMedium,
        fontSize = 10.sp
    ),

    body1 = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        color = BlueMedium,
        fontSize = 16.sp
    ),

    body2 = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        color = White,
        fontSize = 14.sp
    ),


/* Other default text styles to override
button = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.W500,
    fontSize = 14.sp
),
caption = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp
)
*/
)