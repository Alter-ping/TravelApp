//package com.compose.travelapp.hotel_screen
//
//import android.location.Location
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import com.compose.travelapp.Utils.LoadingState
//
//class HotelScreenViewModel() {
//
//    private val _loading = MutableLiveData<Boolean>()
//    val loading: LiveData<Boolean>
//        get() = _loading
//    val error = SingleLiveEvent<String>()
//    private val _locations = MutableLiveData<List<Location>>()
//    val locations: LiveData<List<Location>>
//        get() = _locations
//    fun searchLocations(location: String) {
//        viewModelScope.launch {
//            _loading.value = true
//
//            when (
//                val result = SampleApplication
//                    .amadeus
//                    .referenceData
//                    .locations
//                    .get(listOf("CITY"), location) // We search only for cities, not airports
//            ) {
//                is LoadingState.Status. -> _locations.value = result.data
//                else -> error.value = "Something wrong happened with your request."
//            }
//            _loading.value = false
//        }
//    }
//}