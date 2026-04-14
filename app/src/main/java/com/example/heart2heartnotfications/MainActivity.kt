package com.example.heart2heartnotifications

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.heart2heartnotifications.ui.theme.Heart2HeartNotificationsTheme
import com.example.heart2heartnotifications.view.HomeScreen
import com.example.heart2heartnotifications.view.Screen2
import com.example.heart2heartnotifications.view.Screen3
import com.example.heart2heartnotifications.view.Screen4

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Heart2HeartNotificationsTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "home-screen"
                ) {
                    composable("home-screen") {
                        HomeScreen(
                            name = "",
                            onScreen2ButtonClick = {
                                navController.navigate("screen-2")
                            },
                            onScreen3ButtonClick = {
                                navController.navigate("screen-3")
                            },
                            onScreen4ButtonClick = {
                                navController.navigate("screen-4")
                            },
                            onScreen5ButtonClick = {
                                navController.navigate("screen-5")
                            }

                        )
                    }

                    composable("screen-2") {
                        Screen2 {
                            navController.popBackStack()
                        }
                    }

                    composable("screen-3") {
                        Screen3 {
                            navController.popBackStack()
                        }
                    }

                    composable("screen-4") {
                        Screen4 {
                            navController.popBackStack()
                        }
                    }
                    composable("screen-5") {
                        Screen4 {
                            navController.popBackStack()
                        }
                    }
                }
            }
        }
    }
}