package com.example.myrealestate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class MainActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_sccreen)

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