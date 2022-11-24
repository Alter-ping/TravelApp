package com.compose.travelapp.home_screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.compose.googleauth.R
import com.compose.travelapp.Screen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 30.dp),

        ) {
        Text(
            text = "Travel app",
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.purple_700),
            style = typography.h4
        )
        Spacer(modifier = Modifier.height(40.dp))
        Card(
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .size(110.dp)
        ) {
            Column(
                modifier = Modifier.clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null,
                    onClick = {
                        navController.navigate(Screen.HotelScreen.route)
                    }
                )
                    .padding(horizontal = 5.dp, vertical = 5.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hotel_booking),
                    contentDescription = "hotel booking",
                    modifier = Modifier
                        .size(44.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Hotel Booking",
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
            }
        }
//        Button(onClick = {
//            navController.navigate(Screen.HotelScreen.route)
//        }) {
//            Text(text = "Trips")
//        }
        Button(onClick = {
            Toast.makeText(context, "Logged out", Toast.LENGTH_SHORT).show()
            FirebaseAuth.getInstance().signOut()
            navController.navigate(Screen.LoginScreen.route)
        }) {
            Text(text = "Loggout")
        }
    }
}