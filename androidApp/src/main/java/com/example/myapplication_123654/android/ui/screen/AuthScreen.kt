package com.example.myapplication_123654.android.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AuthScreen(/*onCreateAccountClick: () -> Unit, onForgotPasswordClick: () -> Unit*/) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Вход", color = Color.Black, fontSize = 25.sp)
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text(text = "Логин") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color.Black,
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        cursorColor = Color.Black,
                        focusedLabelColor =  Color.Black
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(text = "Пароль") },
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = if (passwordVisibility) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                            Icon(if (passwordVisibility) Icons.Filled.Face
                            else Icons.Filled.Lock, contentDescription = "")
                        }
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color.Black,
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        cursorColor = Color.Black,
                        focusedLabelColor =  Color.Black
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextButton(
                    onClick = { /* Handle registration logic */ },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White
                    )
                ) {
                    Text(text = "Создать аккаунт", color = Color.Black)
                }
                Spacer(modifier = Modifier.height(4.dp))
                TextButton(
                    onClick = { /* Handle registration logic */ },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White
                    )
                ) {
                    Text(text = "Забыли пароль?", color = Color.Black)
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { /* Handle login logic */ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Green,
                        contentColor = Color.White)
                ) {
                    Text(text = "Войти")
                }
            }
        }
    )
}