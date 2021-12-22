package com.appinion.pharma_force.netowork.repository_impl

import com.appinion.pharma_force.model.remot.auth.LoginResponse
import com.appinion.pharma_force.netowork.NetworkCallbackApi
import com.appinion.pharma_force.netowork.repository_callback.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val apiCallback: NetworkCallbackApi) :
    AuthRepository {

    override suspend fun loginAuth(userId: String, pass: String): LoginResponse {
        return apiCallback.requestLoginAuthentication(username = userId, password = pass)
    }
}