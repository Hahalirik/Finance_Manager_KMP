package com.example.myapplication_123654.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.myapplication_123654.android.ui.navigation.AppNavigation
import com.example.myapplication_123654.android.ui.navigation.AppScreen
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val screens = AppScreen.getAll()

            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()

            var selectedScreen by remember {
                mutableStateOf(screens.first())
            }

            val navController = rememberNavController()

            MyApplicationTheme {
                Scaffold(
                    scaffoldState = scaffoldState,
                    drawerContent = {
                        screens.forEach{screen ->
                            TextButton(
                                onClick = {
                                    selectedScreen = screen
                                    navController.navigate(screen.route)
                                },
                                modifier = Modifier
                                    .background(
                                        if (selectedScreen == screen)
                                            Color.Black
                                        else Color.White
                                    )
                                    .fillMaxWidth()
                            ) {
                                Row{
                                    Icon(
                                        imageVector = screen.icon,
                                        contentDescription = null
                                    )
                                    Text(
                                        text = stringResource(screen.nameResource),
                                        color =
                                        if (selectedScreen == screen)
                                            Color.White
                                        else Color.Black
                                    )
                                }
                            }
                        }

                    },
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(stringResource(selectedScreen.nameResource))
                            },
                            navigationIcon = {
                                IconButton(onClick = {
                                    scope.launch {
                                        scaffoldState.drawerState.open()
                                    }
                                }) {
                                    Icon(
                                        imageVector = Icons.Default.Menu,
                                        contentDescription = null
                                    )
                                }
                            },
                            backgroundColor = Color.White,
                            elevation = 0.dp
                        )
                    },
                    content = {
                        AppNavigation(navController = navController)
                    }
                )
            }
        }
    }
}

