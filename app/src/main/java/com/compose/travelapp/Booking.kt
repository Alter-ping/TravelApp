//package com.compose.travelapp
//
//import com.compose.travelapp.hotel_screen.HotelBooking
//import kotlinx.coroutines.CoroutineDispatcher
//import retrofit2.Retrofit
//
//class Booking internal constructor(
//    private val retrofit: Retrofit,
//    private val dispatcher: CoroutineDispatcher
//) {
//
//    /**
//     * A namespaced client for the
//     * `/v1/booking/hotel-booking` endpoints.
//     */
//    val hotelBooking = HotelBooking(retrofit, dispatcher)
//
//}