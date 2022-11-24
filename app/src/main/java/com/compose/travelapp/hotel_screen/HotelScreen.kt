package com.compose.travelapp.hotel_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.googleauth.R

@Composable
fun HotelScreen(
    //viewModel: HotelScreenViewModel = hiltViewModel()
) {
    //val viewModel by viewModels<LocationViewModel>()
    var city by rememberSaveable { mutableStateOf("") }

        Column(
            modifier = Modifier
                .background(color = colorResource(id = R.color.purple_700))
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 30.dp)
        ) {
            var query by rememberSaveable { mutableStateOf("") }
            Text(
                text = "Hotel booking",
                fontWeight = FontWeight.SemiBold,
                color = colorResource(R.color.white),
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(30.dp))
            TextField(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        Color.LightGray,
                        shape = RoundedCornerShape(8.dp)
                    ).fillMaxWidth(),
                value = query,
                label = {
                    Text("Date",fontSize = 18.sp, color = Color.White)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                onValueChange = {
                    query = it
                },
//                leadingIcon = {
//                    Icon(
//                        imageVector = Icons.Filled.DateRange,
//                        tint = Color.White,
//                        contentDescription = "date"
//                    )
//                },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.White,
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        Color.LightGray,
                        shape = RoundedCornerShape(8.dp)
                    ).fillMaxWidth(),
                value = city,
                label = {
                    Text("City",fontSize = 18.sp,color = Color.White)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                onValueChange = {
                    city = it
                },
//                leadingIcon = {
//                    Icon(
//                        imageVector = Icons.Filled.DateRange,
//                        tint = Color.White,
//                        contentDescription = "date"
//                    )
//                },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.White,
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(15.dp))
            Button(onClick = {},
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                modifier = Modifier.fillMaxWidth(),
                content={
                    Text(
                        text = "Search",color = Color.Black)
                }
            )
        }

    Column(modifier = Modifier.fillMaxSize()) {
        //            LazyColumn(modifier = Modifier.fillMaxSize()){
        //                items(state.coins){ coin ->
        //                    CoinListItem(
        //                        coin = coin,
        //                        onItemClick = {
        //                            navController.navigate(Screen.CoinDetailScreen.route + "/${coin.id}")
        //                        }
        //                    )
        //                }
        //            }
        //            if(state.error.isNotBlank()){
        //                TextField(value = "", onValueChange = {})
        //                Text(
        //                    text = state.error,
        //                    color = MaterialTheme.colors.error,
        //                    textAlign = TextAlign.Center,
        //                    modifier = Modifier
        //                        .fillMaxWidth()
        //                        .padding(horizontal = 20.dp)
        //                        .align(Alignment.Center)
        //                )
        //            }
        //            if(state.isLoading){
        //                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        //
        //            }
    }
}
