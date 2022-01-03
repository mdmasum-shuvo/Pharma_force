/*
 * *
 *  * Created by MD. Masum Talukder on 1/3/22, 5:06 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 1/3/22, 4:56 PM
 *
 */

package com.appinion.pharma_force.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch


/**
 * @author MD. Masum Talukder
 * @composable Snackbar design
 * @param color
 * @param text
 *
 */

@Composable
fun CustomSnackbar(color: Color, text: String) {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val modifier = Modifier

    Box(modifier.fillMaxSize()) {
        coroutineScope.launch {
            snackbarHostState.showSnackbar(message = text)
        }

        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier.align(Alignment.BottomCenter),

            ) {
            Snackbar(
                actionColor = Color.White,
                snackbarData = it,
                backgroundColor = color,
                contentColor = Color.White
            )
        }
    }
}
