package com.appinion.pharma_force.base

sealed class Routing(val route: String) {
    object LoginScreen : Routing(LOGIN_SCREEN)
    object DashBoardScreen : Routing(DASHBOARD_SCREEN)
}


const val LOGIN_SCREEN = "login_screen"
const val DASHBOARD_SCREEN = "dashboard_screen"