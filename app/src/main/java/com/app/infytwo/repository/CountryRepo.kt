package com.app.infytwo.repository

import android.content.Context
import com.app.infytwo.data.CountryModel
import org.json.JSONArray
import org.json.JSONObject

class CountryRepo(val context : Context) {

    fun fectingData(): ArrayList<CountryModel>? {
        val countrylist = ArrayList<CountryModel>()

        var jsonObject : JSONObject = JSONObject(setUpData())
        var jsonArray : JSONArray = jsonObject.getJSONArray("rows")

        for (i in 0..jsonArray.length()-1) {
            var jsonObject: JSONObject = jsonArray.getJSONObject(i)
            var country_title: String = jsonObject.getString("title")
            var country_description: String = jsonObject.getString("description")
            var image: String = jsonObject.getString("imageHref")

            val country_model: CountryModel = CountryModel(country_title, country_description, image)

            if (checkiSEmpty(country_model))
                countrylist.add(country_model)

        }
        return countrylist
    }
    fun setUpData() :String?{
        var json: String

        json =context.assets.open("api.txt").bufferedReader().use {
            it.readText()
        }
        return json
    }
    fun checkiSEmpty(data: CountryModel): Boolean = if (data.title != "null") true else false

}