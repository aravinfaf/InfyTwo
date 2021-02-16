package com.app.infytwo.viewmodel.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.infytwo.repository.CountryRepo
import com.app.infytwo.viewmodel.MainViewmodel

class ViewModelFactory : ViewModelProvider.Factory {

    lateinit var context : Context
    constructor(context: Context) {
        this.context = context
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewmodel::class.java))
            return MainViewmodel(CountryRepo(context)) as T

        return create(modelClass)
    }
}