package com.example.thaparpgbot

import android.R.attr.id
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun Profile(navController: NavHostController) {
    Image(
        painter = painterResource(id = R.drawable.b),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
    Button(onClick = {navController.popBackStack() }, modifier = Modifier.offset(x=0.dp,y=0.dp)) {
        Text(text ="Go Back")
    }

    var value by remember { mutableStateOf("") }
    var value1 by remember { mutableStateOf("") }
    var value2 by remember { mutableStateOf("") }
    var value3 by remember { mutableStateOf("") }
    var value4 by remember { mutableStateOf("") }
    var value5 by remember { mutableStateOf("") }
    var value6 by remember { mutableStateOf("") }

    Column (
        modifier = Modifier.fillMaxSize().padding(10.dp).offset(x = 20.dp,y=40.dp),
        verticalArrangement = Arrangement.Top
    ){
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = value, onValueChange = {value = it}, label = {
            Text(text = "First Name")
        })
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(value = value1, onValueChange = {value1 = it}, label = {
            Text(text = "Last Name")
        })
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(value = value2, onValueChange = {value2 = it}, label = {
            Text(text = "Contact")
        })
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(value = value3, onValueChange = {value3 = it}, label = {
            Text(text = "E-mail")
        })
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(value = value4, onValueChange = {value4 = it}, label = {
            Text(text = "Course")
        })
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(value = value5, onValueChange = {value5 = it}, label = {
            Text(text = "Semester")
        })
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(value = value6, onValueChange = {value6 = it}, label = {
            Text(text = "City")
        })


    }
}