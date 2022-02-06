package com.example.cfacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import com.android.volley.*
import com.android.volley.toolbox.*
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
        val queue = Volley.newRequestQueue(this)


        getJson(queue)
    }


    private fun getJson(queue: RequestQueue){
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility = View.VISIBLE
        val stringRequest = StringRequest(
            Request.Method.GET,
            "https://cat-fact.herokuapp.com/facts",
            {res ->
                val factList = resToList(res)

                val factListView = findViewById<ListView>(R.id.factListView)
                factListView.adapter = FactAdapter(this, R.layout.fact_item, factList)
                progressBar.visibility = View.GONE




            },
            {
                Toast.makeText(this, "Ошибка", Toast.LENGTH_LONG).show()
                progressBar.visibility = View.GONE
            }
        )
        queue.add(stringRequest)
    }

    private fun resToList(res:String):List<Fact>{
        val factList:MutableList<Fact> = mutableListOf()
        val jsonArray = JSONArray(res)
        for (i in 0 until jsonArray.length()){
            val jsonObject = jsonArray.getJSONObject(i)
            val factText = jsonObject.getString("text")
            factList.add(Fact(factText))
        }
        return factList
    }



    fun goToFavourite(view: View) {
        val intent = Intent(this, FavouriteActivity::class.java)
        startActivity(intent)
    }
}


