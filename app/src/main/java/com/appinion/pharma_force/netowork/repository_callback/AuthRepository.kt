package com.appinion.pharma_force.netowork.repository_callback

import com.appinion.pharma_force.model.remot.auth.LoginResponse

interface AuthRepository {
    suspend fun loginAuth(userId: String, pass: String): LoginResponse

}