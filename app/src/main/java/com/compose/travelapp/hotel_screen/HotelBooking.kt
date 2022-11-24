//package com.compose.travelapp.hotel_screen
//
//import com.compose.travelapp.domain.BaseApi
//import com.compose.travelapp.domain.BookingApi
//import com.squareup.moshi.Moshi
//import kotlinx.coroutines.CoroutineDispatcher
//import okhttp3.OkHttpClient
//import retrofit2.Retrofit
//import retrofit2.create
//
//class HotelBooking internal constructor(
//    retrofit: Retrofit,
//    dispatcher: CoroutineDispatcher
//) : BaseApi(dispatcher) {
//
//    private val api: BookingApi = retrofit.create()
//
//    suspend fun post(
//        requestBody: String
//    ) = safeApiCall {
//        api.createBooking(bodyAsMap(requestBody))
//    }
//
//    suspend fun post(
//        requestBody: Map<String, Any>
//    ) = safeApiCall {
//        api.createBooking(requestBody)
//    }
//
//}