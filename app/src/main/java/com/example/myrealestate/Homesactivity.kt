package com.example.myrealestate


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myrealestate.databinding.ActivityMainBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.util.logging.Logger.global

const val base_url = "http://192.168.2.6:3000/"

lateinit var myadapter: MyAdapter
lateinit var linearLayoutManager: LinearLayoutManager

class Homesactivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val display = supportActionBar
        display?.setDisplayHomeAsUpEnabled(true)


        recyclerView = binding.recycleviewhome
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)



        getMyData()

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)

        }
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
                val id = responseBody.homes[1].id
               // Log.i("helloooo", id)

                myadapter = MyAdapter(baseContext, responseBody.homes)
                myadapter.notifyDataSetChanged()
                recyclerView.adapter = myadapter








                responseBody.homes.forEach {

                    Log.i("helloooo", it.request.url)


                }


                recyclerAdapter = MyAdapter(this@Homesactivity, responseBody.homes)
                recyclerView.adapter = recyclerAdapter
                recyclerAdapter.setOnItemClickListener(object :
                MyAdapter.onItemClickListener {
                    override fun onItemClick(position: Int) {
                        //edw diaxeirizomaste ta clicks gia to kathe spiti tou recycler view.
                        //theloume na paroume to url kai na to steiloume sto epomeno fragment me ta details
                        val url = responseBody.homes[position].request.url
                       val newactivity = Intent(this@Homesactivity, detailed_activity::class.java)
                        startActivity(newactivity)
                        newactivity.putExtra("id", id)

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





