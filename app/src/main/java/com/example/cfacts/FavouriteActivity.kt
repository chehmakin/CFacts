package com.example.cfacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView

import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.cfacts.FavouriteList.favouriteList



class FavouriteActivity : AppCompatActivity() {

    var favourList = favouriteList.toList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        if (favourList.isNotEmpty()) {
            findViewById<TextView>(R.id.message).visibility = View.GONE
            val favourListView = findViewById<ListView>(R.id.FavourListView)
            val adapter = FavouriteAdapter(this, R.layout.favourite_item, favourList)

            favourListView.adapter = adapter

        favourListView.setOnItemClickListener { _:AdapterView<*>, _:View, pos:Int, _:Long ->
            val intent = Intent(this, FactDetailActivity::class.java).apply {
                putExtra("FactText", favourList[pos].text)
            }
            startActivity(intent)
        }
        }


    }





}

