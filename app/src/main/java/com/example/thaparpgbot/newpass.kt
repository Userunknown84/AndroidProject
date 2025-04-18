package com.example.thaparpgbot

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun newpass(navController: NavController){
    var mail by remember { mutableStateOf("") }
    var mail2 by remember { mutableStateOf("") }
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = mail, onValueChange = {mail = it}, label = {
            Text(text = "Enter Your New Password")
        })

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = mail2, onValueChange = {mail2 = it}, label = {
            Text(text = "Re-Enter Your  Password")
        })

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("login")
        }) {
            Text(text = "Continue")
        }

    }
}