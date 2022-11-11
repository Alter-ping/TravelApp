package com.compose.travelapp.home_screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.compose.travelapp.Screen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .background(color = Color.Cyan)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "HomeScreen",
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Trips")
        }
        Button(onClick = {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
            FirebaseAuth.getInstance().signOut()
            navController.navigate(Screen.LoginScreen.route)
        }) {
            Text(text = "Loggout")
        }
    }
}