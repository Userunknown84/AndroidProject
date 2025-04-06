package com.example.thaparpgbot

import android.R.id.input
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.automirrored.rounded.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch


@Composable
fun Main(navController: NavController){



    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )
    val scope = rememberCoroutineScope()


    ModalNavigationDrawer(
        drawerState = drawerState
        ,drawerContent = {
            ModalDrawerSheet {
                DrawerContent()
            }
        }
    ) {
        Scaffold(
            topBar =  {
                TopBar(navController,
                    onOpenDrawer = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    }
                )
            }
        ){ padding ->
            Box(modifier = Modifier.fillMaxSize()){
                background_img()
                ScreenContent(modifier = Modifier.padding(padding))
            }
        }
    }
}


@Composable
fun DrawerContent(modifier: Modifier = Modifier){
    Text(
        text = "Thapar Pg GPT",
        modifier = Modifier.padding(16.dp),
        fontSize = 20.sp
    )
    HorizontalDivider()

    NavigationDrawerItem(
        icon = {
            Icon(imageVector = Icons.Rounded.AccountCircle,
                contentDescription = "Account" )
        }
        ,
        label = {
            Text(
                text = "View Query",
                fontSize = 17.sp,
                modifier = Modifier.padding(16.dp)
            )
        },
        selected = false,
        onClick ={ }

    )

    Spacer(modifier = Modifier.height(8.dp))

    NavigationDrawerItem(
        icon = {
            Icon(imageVector = Icons.Rounded.AccountCircle,
                contentDescription = "Account" )
        }
        ,
        label = {
            Text(
                text = "Feedback",
                fontSize = 17.sp,
                modifier = Modifier.padding(16.dp)
            )
        },
        selected = false,
        onClick ={ }

    )


}

@Composable
fun ScreenContent(modifier: Modifier = Modifier) {
    var input by remember { mutableStateOf("") }
    var submittedText by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = input,
                onValueChange = { input = it },
                label = { Text(text = "Enter Your Query") },
                modifier = Modifier
                    .weight(1f)
            )

            Button(onClick = {
                submittedText = input
                input = ""
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Send,
                    contentDescription = "Send"
                )
            }
        }
        if (submittedText.isNotEmpty()) {
            Text(text = "Submitted: $submittedText", modifier = Modifier.padding(16.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavController, onOpenDrawer: () -> Unit) {
    var showMenu by remember { mutableStateOf(false) }
    TopAppBar(
        modifier = Modifier.background(color = Color.Transparent),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                modifier = Modifier
                    .padding(start = 16.dp, end = 8.dp)
                    .size(28.dp)
                    .clickable {
                        onOpenDrawer()
                    }
            )
        },
        title = {
            Text(text = "")
        },
        actions = {
            Image(
                painter = painterResource(id = R.drawable.p),
                contentDescription = "Menu",
                modifier = Modifier
                    .padding(start = 16.dp, end = 8.dp)
                    .size(35.dp)
                    .clip(CircleShape)
                    .clickable {
                        showMenu = !showMenu
                    }
            )

            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false },
                modifier = Modifier.offset(x = (-5).dp, y = 0.dp) // Adjust the offset as needed
            ) {
                DropdownMenuItem(
                    text = { Text("Profile") },
                    onClick = {
                        navController.navigate("profile")
                        showMenu = false
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.AccountCircle,
                            contentDescription = "Profile"
                        )
                    }
                )
                DropdownMenuItem(
                    text = { Text("Logout") },
                    onClick = {
                        navController.navigate("login")
                        showMenu = false
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.ExitToApp,
                            contentDescription = "Logout"
                        )
                    }
                )

            }
        }
    )
}

@Composable
fun background_img() {
    Image(
        painter = painterResource(id = R.drawable.b), contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
}
