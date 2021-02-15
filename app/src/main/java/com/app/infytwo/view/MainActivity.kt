package com.app.infytwo.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.infytwo.R
import com.app.infytwo.adapter.CountryAdapter
import com.app.infytwo.data.CountryModel
import com.app.infytwo.databinding.ActivityMainBinding
import com.app.infytwo.viewmodel.MainViewmodel

class MainActivity : AppCompatActivity() {

    var countrylist: ArrayList<CountryModel> = arrayListOf()
    lateinit var countryAdapter: CountryAdapter
    lateinit var mainViewmodel: MainViewmodel
    lateinit var activityMainBinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        showdata()
    }


    fun showdata() {

        mainViewmodel = ViewModelProviders.of(this).get(MainViewmodel::class.java)

        mainViewmodel.country_data.observe(this, Observer {

            activityMainBinding.countryRecyclerview.layoutManager = LinearLayoutManager(this)
            countryAdapter =
                CountryAdapter(it)
            activityMainBinding.countryRecyclerview.addItemDecoration(
                DividerItemDecoration(
                    activityMainBinding.countryRecyclerview.context,
                    (activityMainBinding.countryRecyclerview.layoutManager as LinearLayoutManager).orientation
                )
            )
            activityMainBinding.countryRecyclerview.adapter = countryAdapter
        })
    }

    private fun setupUIadapter(countrylist: ArrayList<CountryModel>) {

        activityMainBinding.countryRecyclerview.layoutManager = LinearLayoutManager(this)
        countryAdapter =
            CountryAdapter(countrylist)
        activityMainBinding.countryRecyclerview.addItemDecoration(
            DividerItemDecoration(
                activityMainBinding.countryRecyclerview.context,
                (activityMainBinding.countryRecyclerview.layoutManager as LinearLayoutManager).orientation
            )
        )
        activityMainBinding.countryRecyclerview.adapter = countryAdapter
    }
}
