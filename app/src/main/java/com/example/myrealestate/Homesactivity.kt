package com.example.myrealestate


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

const val base_url = "http://192.168.2.7:3000/"

lateinit var myAdapter: MyAdapter

lateinit var linearLayoutManager: LinearLayoutManager
class Homesactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getmyData();

    }
        fun getmyData(){
            val retrofitbuilder =
                Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(
                    base_url
                ).build().create(ApiInterface::class.java)


            val retrofitData = retrofitbuilder.getData()

            retrofitData.enqueue(object : Callback<ResponseData?> {
                override fun onResponse(call: Call<ResponseData?>, response: Response<ResponseData?>) {
                  val responseBody = response.body()!!
                    val mystring = StringBuilder()


                    val test1 = findViewById<TextView>(R.id.test)

                    responseBody.homes.forEach{
                       test1.append(it.id)
                        test1.append("\n")

                    }




                }

                override fun onFailure(call: Call<ResponseData?>, t: Throwable) {
                    Log.d("ActivityMain", "OnFailure:" +t.message)

                }
            })

        }





    }





