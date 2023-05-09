package com.example.myapplication_123654.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.More
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.myapplication_123654.Greeting
import com.app_123654.compose.ui.ui.navigation.AppScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val screens = com.app_123654.compose.ui.ui.navigation.AppScreen.getAll()

            val scaffoldState = rememberScaffoldState()

            val selectedScreen by remember {
                mutableStateOf(screens.first())
            }

            val navController = rememberNavController()

            MyApplicationTheme {
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(stringResource(selectedScreen.nameResource))
                            },
                            navigationIcon = {
                                IconButton(onClick = {
                                    scaffoldState.drawerState.isOpen
                                }) {
                                    Icon(
                                        imageVector = Icons.Default.Menu,
                                        contentDescription = null
                                    )
                                }
                            }
                        )
                    }
                ) {

                }
            }
        }
    }
}

