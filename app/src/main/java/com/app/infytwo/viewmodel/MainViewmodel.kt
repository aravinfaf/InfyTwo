package com.app.infytwo.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.infytwo.data.CountryModel
import com.app.infytwo.repository.CountryRepo

class MainViewmodel(private val countryRepo: CountryRepo) : ViewModel() {

    var countryLiveData = MutableLiveData<ArrayList<CountryModel>>()

    init {
        getAllData()
    }

    private fun getAllData(){
        val data = countryRepo.fectingData()
        Log.e("EE",data!!.size.toString())
        countryLiveData.value=data
    }
}