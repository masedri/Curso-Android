package com.example.masedri.forecastapplication

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.masedri.forecastapplication.adapter.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import java.net.URL

class MainActivity : Activity() {


    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )
    //val url: String = "https://api.github.com/users/masedri"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val forecastList = findViewById(R.id.forecastList) as RecyclerView
        //val forecastList: RecyclerView = find(R.id.forecastList)

        forecastList.layoutManager = GridLayoutManager(this, 2) // new LinearLayoutManager()
        //forecastList.adapter = ForecastListAdapter(items)
        toast("heeyyy")
        longToast("LongToast")

        async(){
            Request(url = "https://api.github.com/users/masedri").run()
            uiThread { longToast("Request performed") }
        }

    }

    class Request(val url: String){

        fun run(){
            val forecastJsonStr = URL(url).readText()
            Log.d(javaClass.simpleName, forecastJsonStr)
        }


    }







}
