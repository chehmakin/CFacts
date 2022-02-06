package com.example.cfacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.cfacts.FavouriteList.favouriteList
import io.realm.*


class FavouriteActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)
        initRealm()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        val favourListView = findViewById<ListView>(R.id.FavourListView)
//        saveToDb(favouriteList)
        val adapter = FavouriteAdapter(this, R.layout.favourite_item, favouriteList.distinct())

        favourListView.adapter = adapter



    }

    fun initRealm(){
        Realm.init(this)
        val config = RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build()
        Realm.setDefaultConfiguration(config)
    }

//    fun loadFromDb(): List<Fact>? {
//        val realm = Realm.getDefaultInstance()
//        return realm.where(Fact::class.java).findAll()
//    }


//    fun saveToDb(facts:List<Fact>){
//        val realm = Realm.getDefaultInstance()
//
//        realm.beginTransaction()
//        realm.copyToRealm(facts)
//        realm.commitTransaction()
//    }





}