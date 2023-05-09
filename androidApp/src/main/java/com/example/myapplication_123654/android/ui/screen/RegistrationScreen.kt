package com.example.myapplication_123654.android.ui.screen


import android.annotation.SuppressLint
import android.widget.ImageButton
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.IconCompat

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RegistrationScreen() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var confirmPasswordVisibility by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Регистрация") },
                backgroundColor = Color.White,
                elevation = 0.dp
            )
        },
        content = {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text(text = "Логин") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Black,
                        focusedLabelColor = Color.Black,
                        cursorColor = Color.Black
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(text = "Пароль") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Black,
                        focusedLabelColor = Color.Black,
                        cursorColor = Color.Black
                    ),
                    visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                            Icon(if (passwordVisibility) Icons.Filled.FavoriteBorder else Icons.Filled.Done, contentDescription = "")
                        }
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    label = { Text(text = "Повторите пароль") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Black,
                        focusedLabelColor = Color.Black,
                        cursorColor = Color.Black
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { /* Handle registration logic */ },
                    modifier = Modifier.fillMaxWidth(),
                    colors =  ButtonDefaults.buttonColors(
                        backgroundColor = Color.Green,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Зарегистрироваться")
                }
            }
        }
    )
}
