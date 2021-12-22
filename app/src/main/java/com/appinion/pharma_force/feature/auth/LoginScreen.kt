package com.appinion.pharma_force.feature.auth

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.appinion.pharma_force.base.Routing


@Composable
fun LoginScreen(navController: NavController, viewModel: AuthViewModel = hiltViewModel()) {
    val login = viewModel.state.value
    val context = LocalContext.current

    login.data?.let {
        when (login.data?.status) {
            200 -> {
                Toast.makeText(context, "successfully", Toast.LENGTH_LONG).show()
                navController.navigate(Routing.DashBoardScreen.route)
            }
            401 -> {
                Toast.makeText(context, "unAuthorized", Toast.LENGTH_LONG).show()
            }
            else -> {
                Toast.makeText(context, "failed to load", Toast.LENGTH_LONG).show()
            }
        }
    }
    if (login.isLoading) {
        //  CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }

    if (login.error.isNotBlank()) {
        Toast.makeText(context, "failed to load", Toast.LENGTH_LONG).show()

    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewAuth() {
    //LoginScreen()
}