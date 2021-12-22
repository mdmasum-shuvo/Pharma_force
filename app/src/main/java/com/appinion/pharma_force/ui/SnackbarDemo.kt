package com.appinion.pharma_force.ui

import android.util.Log
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarResult
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@Composable
fun Snackbar(color: Int, text: String) {
    val scaffoldState = rememberScaffoldState() // this contains the `SnackbarHostState`
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier,
        scaffoldState = scaffoldState // attaching `scaffoldState` to the `Scaffold`
    ) {

        coroutineScope.launch { // using the `coroutineScope` to `launch` showing the snackbar
            // taking the `snackbarHostState` from the attached `scaffoldState`
            val snackbarResult = scaffoldState.snackbarHostState.showSnackbar(
                message = text,
                actionLabel = "ok"
            )
            when (snackbarResult) {
                SnackbarResult.Dismissed -> Log.d("SnackbarDemo", "Dismissed")
                SnackbarResult.ActionPerformed -> Log.d("SnackbarDemo", "Snackbar's button clicked")
            }
        }
    }

}
