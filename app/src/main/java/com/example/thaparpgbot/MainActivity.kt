package com.example.thaparpgbot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Routes.screenA, builder={
                composable(Routes.screenA){
                    LoginScreen(navController)
                }
                composable(Routes.screenB){
                    Main(navController)
                }
                composable(Routes.screenC){
                    ForgotPass(navController)
                }
                composable(Routes.screenD){
                    newpass(navController)
                }
                composable(Routes.screenE){
                    Profile(navController)
                }
            })
            }
        }
    }








