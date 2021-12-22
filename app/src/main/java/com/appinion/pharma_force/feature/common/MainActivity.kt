package com.appinion.pharma_force.feature.common

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.appinion.pharma_force.base.Routing
import com.appinion.pharma_force.feature.auth.LoginScreen
import com.appinion.pharma_force.feature.dashboard.DashBoardScreen
import com.appinion.pharma_force.ui.theme.PharmaForceTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PharmaForceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background,
                    shape = MaterialTheme.shapes.medium
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Routing.LoginScreen.route
                    ) {
                        composable(
                            route = Routing.LoginScreen.route
                        ) {
                            LoginScreen(navController)
                        }

                        composable(
                            route = Routing.DashBoardScreen.route
                        ) {
                            DashBoardScreen()
                        }

                    }

                }
            }
        }
    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    PharmaForceTheme {
    }
}