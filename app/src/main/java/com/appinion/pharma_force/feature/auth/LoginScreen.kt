package com.appinion.pharma_force.feature.auth


import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.appinion.pharma_force.feature.auth.component.LoginUiComponent


@Composable
fun LoginScreen(navController: NavController, viewModel: AuthViewModel = hiltViewModel()) {
/*
    val login = viewModel.state.value
    val context = LocalContext.current
    login.data?.let {
        when (login.data?.status) {
            200 -> {
                Toast.makeText(context, login.data.message, Toast.LENGTH_LONG).show()
                // navController.navigate(Routing.DashBoardScreen.route)
            }
            401 -> {
                Toast.makeText(context, login.data.message, Toast.LENGTH_LONG).show()
            }
            else -> {
                Toast.makeText(context, login.data.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    if (login.isLoading) {
        Column(verticalArrangement = Arrangement.Center) {
        }
    }

    if (login.error.isNotBlank()) {
        Toast.makeText(context, login.error, Toast.LENGTH_LONG).show()

    }
*/

    LoginUiComponent(viewmodel = viewModel)

}

