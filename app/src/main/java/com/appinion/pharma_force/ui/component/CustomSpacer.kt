package com.appinion.pharma_force.ui.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomSpacerHeight(size: Int=20) = Spacer(modifier = Modifier.height(size.dp))

@Composable
fun CustomSpacerWidth(size: Int) = Spacer(modifier = Modifier.width(size.dp))

