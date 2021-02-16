package com.app.infytwo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.infytwo.data.CountryModel
import com.app.infytwo.repository.CountryRepo
import org.json.JSONArray
import org.json.JSONObject

public class MainViewmodel(private val countryRepo: CountryRepo) : ViewModel() {

    var countryLiveData = MutableLiveData<ArrayList<CountryModel>>()

    init {
        getAllData()
    }

    private fun getAllData(){
        val data = countryRepo.fectingData()
        countryLiveData.postValue(data)
    }
}