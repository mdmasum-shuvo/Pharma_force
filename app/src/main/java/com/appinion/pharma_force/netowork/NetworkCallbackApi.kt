package com.appinion.pharma_force.netowork

import com.appinion.pharma_force.model.remot.auth.LoginResponse
import retrofit2.http.POST
import retrofit2.http.Query

interface NetworkCallbackApi {

    @POST(APP_LOGIN)
    suspend fun requestLoginAuthentication(
        @Query(APP_USER_ID) username: String?,
        @Query(APP_PASSWORD) password: String?
    ): LoginResponse
}