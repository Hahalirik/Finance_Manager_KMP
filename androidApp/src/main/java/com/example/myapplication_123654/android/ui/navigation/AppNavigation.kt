package com.example.myapplication_123654.android.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication_123654.android.ui.screen.AuthScreen
import com.example.myapplication_123654.android.ui.screen.RegistrationScreen
import com.example.myapplication_123654.android.ui.screen.TransactionEditorScreen
import com.example.myapplication_123654.android.ui.screen.TransactionScreen
import com.example.myapplication_123654.android.ui.screen.*

@Composable
fun AppNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AppScreen.AuthScreen.route
    ){
        composable(
            route = AppScreen.AuthScreen.route
        ){
            AuthScreen()
        }
        
        composable(
            route = AppScreen.RegistrationScreen.route
        ){
            RegistrationScreen()
        }
        
        composable(
            route = AppScreen.TransactionScreen.route
        ){
            TransactionScreen()
        }

        composable(
            route = AppScreen.TransactionEditorScreen.route
        ){
            TransactionEditorScreen()
        }

        composable(
            route = AppScreen.QrScreen.route
        ){
            //QrScreen()
        }

        composable(
            route = AppScreen.SettingsScreen.route
        ){
            //SettingsScreen()
        }
        
    }
}