package com.appinion.pharma_force.screen.feature.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LoginScreen(viewModel: AuthViewModel = hiltViewModel()) {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewAuth() {
    LoginScreen()
}