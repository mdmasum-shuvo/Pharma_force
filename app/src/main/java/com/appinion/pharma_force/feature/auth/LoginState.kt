package com.appinion.pharma_force.feature.auth

import com.appinion.pharma_force.model.remot.auth.LoginResponse

data class LoginState(
    val isLoading: Boolean = false,
    val data: LoginResponse?=null,
    val error: String = ""
)
