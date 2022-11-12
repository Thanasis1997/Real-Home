package com.example.myrealestate


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myrealestate.databinding.ActivityMainBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

const val base_url = "http://192.168.2.7:3000/"


class Homesactivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        recyclerView = binding.recycleviewHomes
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)


        getMyData()

    }

    private fun getMyData() {
        val retrofitBuilder =
            Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(
                base_url
            ).build().create(ApiInterface::class.java)


        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<ResponseData?> {
            override fun onResponse(call: Call<ResponseData?>, response: Response<ResponseData?>) {
                val responseBody = response.body()!!
                val myString = StringBuilder()


                val test1 = findViewById<TextView>(R.id.test)

                responseBody.homes.forEach {
                    Log.d("helloooo", it.city)

                    test1.append(it.id)
                    test1.append("\n")

                }


                recyclerAdapter = MyAdapter(this@Homesactivity, responseBody.homes)
                recyclerView.adapter = recyclerAdapter
                recyclerAdapter.setOnItemClickListener(object :
                MyAdapter.onItemClickListener {
                    override fun onItemClick(position: Int) {
                        //edw diaxeirizomaste ta clicks gia to kathe spiti tou recycler view.
                        //theloume na paroume to url kai na to steiloume sto epomeno fragment me ta details
                        val url = responseBody.homes[position].request.url
                        //kai edw kane to navigation px intent kai perna to url val pou eftiaksa to opoio tha einai to call sto epomeno view
                    }
                })


            }

            override fun onFailure(call: Call<ResponseData?>, t: Throwable) {
                Log.d("ActivityMain", "OnFailure:" + t.message)

            }
        })

    }


}





