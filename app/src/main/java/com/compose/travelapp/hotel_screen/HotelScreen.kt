//package com.compose.travelapp.hotel_screen
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.Button
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Text
//import androidx.compose.material.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.KeyboardType
//
//@Composable
//fun HotelScreen() {
//    var query: String by rememberSaveable { mutableStateOf("") }
//
//    Column(
//        modifier = Modifier
//            .background(color = Color.Cyan)
//            .fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//    ) {
//        TextField(
//            value = query,
//            onValueChange = { },
//            maxLines = 1,
//            textStyle = MaterialTheme.typography.subtitle1,
//            singleLine = true,
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
//        )
//        Text(
//            text = "HomeScreen",
//            fontWeight = FontWeight.Bold,
//            color = Color.Black
//        )
//        Button(onClick = { /*TODO*/ }) {
//            Text(text = "Trips")
//        }
//    }
//}