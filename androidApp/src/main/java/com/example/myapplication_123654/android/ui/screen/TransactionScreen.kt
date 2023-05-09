package com.example.myapplication_123654.android.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
fun TransactionScreen(dataList: List<String> = listOf("")) {
    var transactionDateStart by remember { mutableStateOf("") }
    var transactionDateEnd by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("Категория") }
    var expanded by remember { mutableStateOf(false) }


    Scaffold(
       content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
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
                                    if (category == selectedCategory)
                                        Color.Green
                                    else Color.Black
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ){
                    OutlinedTextField(
                        value = transactionDateStart,
                        onValueChange = { transactionDateStart = it },
                        label = { Text(text = "От") },
                        modifier = Modifier.width(175.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            textColor = Color.Black,
                            focusedBorderColor = Color.Black,
                            focusedLabelColor = Color.Black,
                            cursorColor = Color.Black
                        ),
                    )
                    Spacer(modifier = Modifier.weight(1f, true))
                    OutlinedTextField(
                        value = transactionDateEnd,
                        onValueChange = { transactionDateEnd = it },
                        label = { Text(text = "До") },
                        modifier = Modifier.width(175.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            textColor = Color.Black,
                            focusedBorderColor = Color.Black,
                            focusedLabelColor = Color.Black,
                            cursorColor = Color.Black
                        ),
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                LazyColumn(
                    modifier = Modifier.weight(1f, true),
                ){
                    items(
                        items = dataList
                    ) {
                        OutlinedButton(
                            onClick = { /* Handle login logic */ },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Green,
                                contentColor = Color.White
                            )
                        ) {
                            Text(text = it)
                        }
                    }
                }
            }
        }
    )
}

