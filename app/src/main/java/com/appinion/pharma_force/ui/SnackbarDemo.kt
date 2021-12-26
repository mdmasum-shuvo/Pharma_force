package com.appinion.pharma_force.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import com.appinion.pharma_force.ui.theme.BlueMedium
import kotlinx.coroutines.launch

@Composable
fun CustomSnackbar(color: Color, text: String) {
    val scaffoldState = rememberScaffoldState() // this contains the `SnackbarHostState`
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier,
        scaffoldState = scaffoldState, // attaching `scaffoldState` to the `Scaffold`
        snackbarHost = {
            // reuse default SnackbarHost to have default animation and timing handling
            SnackbarHost(it) { data ->
                // custom snackbar with the custom colors
                Snackbar(
                    actionColor = Green,
                    //contentColor = ...,
                    snackbarData = data
                )
            }
        },
    ) {

        coroutineScope.launch { // using the `coroutineScope` to `launch` showing the snackbar
            // taking the `snackbarHostState` from the attached `scaffoldState`
            val snackbarResult = scaffoldState.snackbarHostState.showSnackbar(
                message = text,
                actionLabel = "ok"
            )

        }
    }

}

@Composable
fun SnackbarSample(color: Color, text: String) {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val modifier = Modifier

    Box(modifier.fillMaxSize()) {
        coroutineScope.launch {
            snackbarHostState.showSnackbar(message =text)
        }

        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier.align(Alignment.BottomCenter),

            ) {
            Snackbar(
                actionColor = Color.White,
                snackbarData = it
            )
        }
    }
}
