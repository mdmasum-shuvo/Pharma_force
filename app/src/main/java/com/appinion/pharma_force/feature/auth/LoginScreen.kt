package com.appinion.pharma_force.feature.auth


import android.widget.Toast
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.appinion.pharma_force.base.Routing
import com.appinion.pharma_force.feature.auth.component.LoginUiComponent
import com.appinion.pharma_force.ui.CustomSnackbar
import com.appinion.pharma_force.ui.component.PulseLoading
import com.appinion.pharma_force.ui.theme.BlueMedium
import com.appinion.pharma_force.utils.ValidationUtils
import com.appinion.pharma_force.utils.ValidationUtils.checkValidation
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: AuthViewModel = hiltViewModel(),

    ) {
    ValidationUtils.clearValidationArray()
    val login = viewModel.state.value
    val context = LocalContext.current
    val validationState = remember { mutableStateOf(false) }
    val textStateUserId = remember { mutableStateOf("") }
    val textStatePassword = remember { mutableStateOf("") }
    Surface(color = MaterialTheme.colors.background) {
        if (validationState.value) {
            if (checkValidation()) {
                viewModel.requestLogin(textStateUserId.value, textStatePassword.value)
            }
        }
        val scope = rememberCoroutineScope()
        val onClickLoginButton = {
            scope.launch {
                validationState.value = true
            }
        }

        login.data?.let {
            when (login.data?.status) {
                200 -> {
                    Toast.makeText(context, login.data.message, Toast.LENGTH_LONG).show()
                    LaunchedEffect(key1 = true, block = {
                        navController.navigate(route = Routing.DashBoardScreen.route)
                    })
                }
                401 -> {
                    Toast.makeText(context, login.data.message, Toast.LENGTH_LONG).show()
                }
                else -> {
                    CustomSnackbar(color = BlueMedium, text = login.data.message)
                }
            }
        }
        var name: String = ""
        var pass: String = ""
        LoginUiComponent(onClickLoginButton = {
            onClickLoginButton()
        }, textStateUserId = textStateUserId, textStatePassword = textStatePassword)

        if (login.isLoading) {
            PulseLoading()
        }


        if (login.error.isNotBlank()) {
            CustomSnackbar(color = BlueMedium, text = login.error)
            Toast.makeText(context, login.error, Toast.LENGTH_LONG).show()
        }
    }


}

private fun isValid(userID: String, pass: String) {
    if (userID == "")

        return

}

