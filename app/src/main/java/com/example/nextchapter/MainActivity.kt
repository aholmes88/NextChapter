package com.example.nextchapter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.nextchapter.ui.theme.NextChapterTheme


import com.example.nextchapter.screen.HomeScreen
import com.example.nextchapter.ui.screen.LoginScreen
import com.example.nextchapter.ui.screen.SignupScreen
import com.example.nextchapter.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val userView : UserViewModel by viewModels()

        setContent {
            NextChapterTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "login"){
                    composable("login") {
                        LoginScreen(navController)
                    }
                    composable("signup") {
                        SignupScreen(navController)
                    }
                    composable("home") {
                        HomeScreen(navController, userView)
                        //Text("Welcome to the Homepage, ${userView.currentUser.value?.username}")
                    }
                }
            }
        }
    }
}
