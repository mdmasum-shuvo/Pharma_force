package com.appinion.pharma_force.feature.common


import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.appinion.pharma_force.base.Routing
import com.appinion.pharma_force.feature.auth.LoginScreen
import com.appinion.pharma_force.feature.communication_hub.CommunicationHubScreen
import com.appinion.pharma_force.feature.dashboard.DashBoardScreen
import com.appinion.pharma_force.feature.incentive_calculator.IncentiveCalculatorScreen
import com.appinion.pharma_force.feature.shop.RenataShopScreen
import com.appinion.pharma_force.feature.testing_center.TestCenterScreen
import com.appinion.pharma_force.utils.*
import kotlinx.coroutines.launch

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    Scaffold{
        Surface(color = MaterialTheme.colors.background) {
            val drawerState = rememberDrawerState(DrawerValue.Closed)
            val scope = rememberCoroutineScope()
            val openDrawer = {
                scope.launch {
                    drawerState.open()
                }
            }

            ModalDrawer(
                drawerState = drawerState,
                gesturesEnabled = drawerState.isOpen,
                drawerContent = {
                    Drawer(
                        onDestinationClicked = { route ->
                            scope.launch {
                                drawerState.close()
                            }
                            navController.navigate(route) {
                                popUpTo = navController.graph.startDestinationId
                                launchSingleTop = true
                            }
                        }
                    )
                }
            ) {
                NavHost(
                    navController = navController,
                    startDestination = Routing.LoginScreen.route
                ) {
                    composable(Routing.LoginScreen.route) {
                        LoginScreen(
                            navController = navController
                        )
                    }
                    composable(Routing.DashBoardScreen.route) {
                        DashBoardScreen(
                            openDrawer = {
                                openDrawer()
                            }, title = Routing.DashBoardScreen.title
                        )
                    }
                    composable(
                        route = Routing.CommunicationHub.route
                    ) {
                        CommunicationHubScreen(openDrawer = {
                            openDrawer()
                        }, title = Routing.CommunicationHub.title)
                    }
                    composable(
                        route = Routing.IncentiveTracker.route
                    ) {
                        IncentiveCalculatorScreen(
                            navController = navController,
                            title = Routing.IncentiveTracker.title
                        )
                    }

                    composable(
                        route = Routing.RenataShop.route
                    ) {
                        RenataShopScreen(navController = navController)
                    }

                    composable(
                        route = Routing.TestCenter.route
                    ) {
                        TestCenterScreen(navController = navController)
                    }
                }
            }
        }

    }
}


@Composable
fun AppMainScreen() {
    val navController = rememberNavController()
    Surface(color = MaterialTheme.colors.background) {
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        val openDrawer = {
            scope.launch {
                drawerState.open()
            }
        }
        ModalDrawer(
            drawerState = drawerState,
            gesturesEnabled = drawerState.isOpen,
            drawerContent = {
                Drawer(
                    onDestinationClicked = { route ->
                        scope.launch {
                            drawerState.close()
                        }
                        navController.navigate(route) {
                            popUpTo = navController.graph.startDestinationId
                            launchSingleTop = true
                        }
                    }
                )
            }
        ) {
            NavHost(
                navController = navController,
                startDestination = DrawerScreens.Home.route
            ) {
                composable(DrawerScreens.DashBoardScreen.route) {
                    DashBoardScreen(
                        openDrawer = {
                            openDrawer()
                        }
                    )
                }
                composable(DrawerScreens.Home.route) {
                    Home(
                        openDrawer = {
                            openDrawer()
                        }
                    )
                }
                composable(DrawerScreens.Account.route) {
                    Account(
                        openDrawer = {
                            openDrawer()
                        }
                    )
                }

                composable(DrawerScreens.Help.route) {
                    Help(
                        navController = navController
                    )
                }
            }
        }
    }
}
