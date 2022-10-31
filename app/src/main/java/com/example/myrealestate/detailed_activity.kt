package com.example.myrealestate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class detailed_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detailed)
        val display = supportActionBar
        display?.setDisplayHomeAsUpEnabled(true)



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
}