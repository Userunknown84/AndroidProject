package com.example.thaparpgbot

import android.service.autofill.OnClickAction
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.thaparpgbot.R



@Composable
fun LoginScreen(navController: NavController){
    var mail by remember { mutableStateOf("") }
    var  pass by remember { mutableStateOf("") }
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter= painterResource(id = R.drawable.ti), contentDescription = "Login Page",
            modifier = Modifier.size(200.dp).clip(CircleShape))

        Spacer(modifier = Modifier.height(16.dp))
        Text(text="Login to your Account")

        OutlinedTextField(value = mail, onValueChange = {mail = it}, label = {
            Text(text = "Email Address")
        })

        Spacer(modifier = Modifier.height(16.dp))


        OutlinedTextField(value = pass, onValueChange = {pass = it}, label = {
        Text(text = "Password")
    },visualTransformation = PasswordVisualTransformation())


        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("MainPage")
        }) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(16.dp))
        TextButton(onClick = {
            navController.navigate("ForgotPassword")
        }) {
            Text(text = "Forgot Password?")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "or")

        Image(painter= painterResource(id = R.drawable.gm), contentDescription = "Login with gmail",
            modifier = Modifier.size(60.dp).clip(CircleShape).clickable{ })



    }
}