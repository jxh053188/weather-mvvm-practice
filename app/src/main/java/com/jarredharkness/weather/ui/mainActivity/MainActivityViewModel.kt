package com.jarredharkness.weather.ui.mainActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jarredharkness.weather.data.repository.CurrentWeatherRepository
import com.jarredharkness.weather.model.current.WeatherModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {
    private val repository = CurrentWeatherRepository()

    private val _currentWeatherLiveData = MutableLiveData<WeatherModel?>()
    val currentWeatherLiveData: LiveData<WeatherModel?> = _currentWeatherLiveData

    //private val weatherApiService = WeatherAPIService()
    private val disposable = CompositeDisposable()

    fun refreshData(cityName: String) {
        //getDataFromAPI(cityName)
        viewModelScope.launch {
            val response = repository.getCurrentWeather(cityName)
            _currentWeatherLiveData.postValue(response)
        }
    }

    val weather_data = MutableLiveData<WeatherModel>()
    val weather_error = MutableLiveData<Boolean>()
    val weather_loading = MutableLiveData<Boolean>()


//    private fun getDataFromAPI(cityName: String) {
//
//        weather_loading.value = true
//        disposable.add(
//            weatherApiService.getDataService(cityName)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(object : DisposableSingleObserver<WeatherModel>() {
//
//                    override fun onSuccess(t: WeatherModel) {
//                        weather_data.value = t
//                        weather_error.value = false
//                        weather_loading.value = false
//                        Log.d(TAG, "onSuccess: Success")
//                    }
//
//                    override fun onError(e: Throwable) {
//                        weather_error.value = true
//                        weather_loading.value = false
//                        Log.e(TAG, "onError: " + e)
//                    }
//
//                })
//        )
//
//    }
}