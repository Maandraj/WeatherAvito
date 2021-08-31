package com.example.teachweather.features.location.data

import android.content.Context

import com.example.teachweather.features.location.data.model.CityRes
import com.example.teachweather.features.location.data.model.mapper.CityMapper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStream
import javax.inject.Inject

class LocationRepo @Inject constructor(

    private val cityMapper: CityMapper
) {
    suspend fun getCity(context: Context) = withContext(Dispatchers.IO) {

       readJSONFromAsset(context).let { res -> res.map { cityMapper.map(it) } }
    }
   private fun readJSONFromAsset(context: Context): List<CityRes>{
        val moshi = Moshi.Builder().build()
        val inputStream: InputStream = context.assets.open("city.list.json")
        val json = inputStream.bufferedReader().use { it.readText() }
        val jsonAdapter: JsonAdapter<List<CityRes>> =
            moshi.adapter<List<CityRes>>(CityRes::class.java)
        return jsonAdapter.fromJson(json)!!
    }
}