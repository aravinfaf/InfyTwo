package com.app.infytwo.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.infytwo.R
import com.app.infytwo.adapter.CountryAdapter
import com.app.infytwo.application.MyApp
import com.app.infytwo.data.CountryModel
import com.app.infytwo.databinding.ActivityMainBinding
import com.app.infytwo.viewmodel.MainViewmodel

class MainActivity : AppCompatActivity() {

    lateinit var countryAdapter: CountryAdapter
    lateinit var mainViewmodel: MainViewmodel
    lateinit var activityMainBinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setUpViewmodel()
        showdata()
    }

    fun showdata() {

        mainViewmodel.countryLiveData.observe(this, Observer {

            activityMainBinding.countryRecyclerview.layoutManager = LinearLayoutManager(this)
            countryAdapter =
                CountryAdapter(it as ArrayList<CountryModel>)
            activityMainBinding.countryRecyclerview.addItemDecoration(
                DividerItemDecoration(
                    activityMainBinding.countryRecyclerview.context,
                    (activityMainBinding.countryRecyclerview.layoutManager as LinearLayoutManager).orientation
                )
            )
            activityMainBinding.countryRecyclerview.adapter = countryAdapter
            countryAdapter.notifyDataSetChanged()
        })
    }
    fun setUpViewmodel(){
        val factory = (this.applicationContext as MyApp).viewModelFactory
        mainViewmodel = ViewModelProviders.of(this,factory).get(MainViewmodel::class.java)
    }

}
