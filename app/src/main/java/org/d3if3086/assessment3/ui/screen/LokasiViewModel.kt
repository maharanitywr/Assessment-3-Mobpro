package org.d3if3086.assessment3.ui.screen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.d3if3086.assessment3.model.ReviewTempat
import org.d3if3086.assessment3.network.BaksoApi

class LokasiViewModel : ViewModel() {

    var data = mutableStateOf(emptyList<ReviewTempat>())
        private set

    var status = MutableStateFlow(BaksoApi.ApiStatus.LOADING)
        private set

    init {
        retrieveData()
    }

    fun retrieveData() {
        viewModelScope.launch(Dispatchers.IO) {
            status.value = BaksoApi.ApiStatus.LOADING
            try {
                data.value = BaksoApi.service.getApiBakso()
                status.value = BaksoApi.ApiStatus.SUCCESS
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
                status.value = BaksoApi.ApiStatus.FAILED
            }
        }
    }
}