package com.appinion.pharma_force.model.remot.auth

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginResponse(
    @Json(name = "app_user_id")
    val appUserID: String="",
    val message: String="",
    val status: Int=0,
    val token: String=""
)

