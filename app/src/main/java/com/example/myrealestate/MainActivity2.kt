package com.example.myrealestate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.myrealestate.databinding.ActivityMainBinding


class MainActivity2 : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.main_sccreen)

        val search = findViewById<Button>(R.id.search_button)
        search.setOnClickListener{

            val newscreen = Intent(this@MainActivity2, Homesactivity::class.java)
            startActivity(newscreen)
        }



        //autocomplete
        val textView = findViewById(R.id.perioxh_input) as AutoCompleteTextView
// Get the string array
        val countries: Array<out String> = resources.getStringArray(R.array.countries_array)
// Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries).also { adapter ->
            textView.setAdapter(adapter)
        }







    }
}