package com.example.myapplication_123654.android.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TransactionEditorScreen() {
    var transactionName by remember { mutableStateOf("") }
    var transactionDate by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("Категория") }
    var expanded by remember { mutableStateOf(false) }
    var productName by remember { mutableStateOf("") }
    var productPrice by remember { mutableStateOf("") }
    var productCount by remember { mutableStateOf(1) }

    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                OutlinedTextField(
                    value = transactionName,
                    onValueChange = { transactionName = it },
                    label = { Text(text = "Название транзакции") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color.Black,
                        focusedBorderColor = Color.Black,
                        focusedLabelColor = Color.Black,
                        cursorColor = Color.Black
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = transactionDate,
                    onValueChange = { transactionDate = it },
                    label = { Text(text = "Дата транзакции (дд.мм.гггг)") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color.Black,
                        focusedBorderColor = Color.Black,
                        focusedLabelColor = Color.Black,
                        cursorColor = Color.Black
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Spacer(modifier = Modifier.height(16.dp))
                val categories = listOf("Категория 1", "Категория 2", "Категория 3")
                Column(modifier = Modifier.fillMaxWidth()) {
                    TextButton(
                        onClick = { expanded = true },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.White
                        )
                    ) {
                        Text(
                            text = selectedCategory,
                            color = Color.Black
                        )
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        categories.forEach { category ->
                            DropdownMenuItem(
                                onClick = {
                                    selectedCategory = category
                                    expanded = false
                                }
                            ) {
                                Text(
                                    text = category,
                                    color =
                                        if (category == selectedCategory) Color.Green
                                        else Color.Black
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                LazyColumn(
                    modifier = Modifier.weight(1f, true),
                    content = {
                    items(
                        count = productCount
                    ){
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                        ){
                            OutlinedTextField(
                                value = productName,
                                onValueChange = { productName = it },
                                label = { Text(text = "Название товара") },
                                modifier = Modifier.width(250.dp),
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    textColor = Color.Black,
                                    focusedBorderColor = Color.Black,
                                    focusedLabelColor = Color.Black,
                                    cursorColor = Color.Black
                                ),
                            )
                            Spacer(modifier = Modifier.weight(1f, true))
                            OutlinedTextField(
                                value = productPrice,
                                onValueChange = { productPrice = it },
                                label = { Text(text = "Цена") },
                                modifier = Modifier.width(100.dp),
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    textColor = Color.Black,
                                    focusedBorderColor = Color.Black,
                                    focusedLabelColor = Color.Black,
                                    cursorColor = Color.Black
                                ),
                            )
                        }
                    }
                })
                TextButton(
                    onClick = { productCount++ },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White
                    )
                ) {
                    Text(
                        text = "+ Добавить товар",
                        color = Color.Black
                    )
                }
                //Spacer(modifier = Modifier.weight(1f, true))
                Button(
                    onClick = { /* Handle login logic */ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Green,
                        contentColor = Color.White)
                ) {
                    Text(text = "Сохранить")
                }
                Button(
                    onClick = { /* Handle login logic */ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Red,
                        contentColor = Color.White)
                ) {
                    Text(text = "Удалить")
                }
                Button(
                    onClick = { /* Handle login logic */ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Black,
                        contentColor = Color.White)
                ) {
                    Text(text = "QR-сканер")
                }
            }
        }
    )
}