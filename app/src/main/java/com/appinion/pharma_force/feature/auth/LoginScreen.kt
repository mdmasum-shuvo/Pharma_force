package com.appinion.pharma_force.feature.auth


import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.appinion.pharma_force.base.Routing
import com.appinion.pharma_force.feature.auth.component.LoginUiComponent
import com.appinion.pharma_force.ui.CustomSnackbar
import com.appinion.pharma_force.ui.SnackbarSample
import com.appinion.pharma_force.ui.component.CustomDialogWithResultExample
import com.appinion.pharma_force.ui.component.PulseLoading
import com.appinion.pharma_force.ui.theme.BlueMedium


@Composable
fun LoginScreen(navController: NavController, viewModel: AuthViewModel = hiltViewModel(),openDrawer: () -> Unit) {
    val login = viewModel.state.value
    val context = LocalContext.current
    LoginUiComponent()
    login.data?.let {

        when (login.data?.status) {
            200 -> {
                Toast.makeText(context, login.data.message, Toast.LENGTH_LONG).show()
                // navController.navigate(Routing.DashBoardScreen.route)
                SnackbarSample(color = BlueMedium, text = login.data.message)
                navController.navigate(route = Routing.DashBoardScreen.route)
            }
            401 -> {
                Toast.makeText(context, login.data.message, Toast.LENGTH_LONG).show()
            }
            else -> {
                navController.navigate(route = Routing.DashBoardScreen.route)

                SnackbarSample(color = BlueMedium, text = login.data.message)
            }
        }
    }

    if (login.isLoading) {
        PulseLoading()
    }


    if (login.error.isNotBlank()) {
        SnackbarSample(color = BlueMedium, text = login.error)

        Toast.makeText(context, login.error, Toast.LENGTH_LONG).show()
    }

}

