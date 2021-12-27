package com.appinion.pharma_force.base

import com.appinion.pharma_force.R

sealed class Routing(val title:String="",val route: String="", val drawable: Int= R.drawable.app_icon) {
    object LoginScreen : Routing(route=LOGIN_SCREEN,title="Login")
    object HomeScreen : Routing(route= HOME_SCREEN,title="Home")
    object DashBoardScreen : Routing(route=DASHBOARD_SCREEN,title="Dashboard",drawable= R.drawable.home)
    object MedicineLibrary : Routing(route=MEDICINE_LIBRARY_SCREEN,title="Medicine Literature",drawable= R.drawable.pills)
    object CommunicationHub : Routing(route=COMMUNICATION_HUB_SCREEN,title="Communication Hub",drawable=  R.drawable.mail)
    object DcrCrf : Routing(route=DCR_CRF_SCREEN,title="DCR & CRF", drawable= R.drawable.medical_team)
    object RxCalculator : Routing(route=RX_CALCULATOR_SCREEN,title="Rx Calculator",drawable=  R.drawable.prescription_rx)
    object IncentiveTracker : Routing(route=INCENTIVE_TRACKER_SCREEN,title="Incentive Tracker",drawable=  R.drawable.profits)
    object TestCenter : Routing(route=TEST_CENTER_SCREEN,title="Test Center",drawable=  R.drawable.exam)
    object RenataShop : Routing(route=RENATA_SHOP_SCREEN,title="Renata Shop", drawable= R.drawable.giftbox)
    object LeaderBoard : Routing(route=LEADER_BOARD_SCREEN,title="Leader Board",drawable=  R.drawable.award)
    object Logout : Routing(route=LOGOUT_SCREEN,title="Logout",drawable=  R.drawable.logout)
}


const val LOGIN_SCREEN = "login_screen"
const val HOME_SCREEN = "home_screen"
const val DASHBOARD_SCREEN = "dashboard_screen"
const val MEDICINE_LIBRARY_SCREEN = "MedicineLibrary"
const val COMMUNICATION_HUB_SCREEN = "CommunicationHub"
const val DCR_CRF_SCREEN = "DcrCrf"
const val RX_CALCULATOR_SCREEN = "RxCalculator"
const val INCENTIVE_TRACKER_SCREEN = "IncentiveTracker"
const val TEST_CENTER_SCREEN = "TestCenter"
const val RENATA_SHOP_SCREEN = "RenataShop"
const val LEADER_BOARD_SCREEN = "LeaderBoard"
const val LOGOUT_SCREEN = "Logout"