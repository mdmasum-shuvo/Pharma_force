package com.appinion.pharma_force.base

sealed class Routing(val route: String) {
    object LoginScreen : Routing(LOGIN_SCREEN)
}


const val LOGIN_SCREEN = "login_screen"