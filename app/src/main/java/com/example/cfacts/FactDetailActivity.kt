package com.example.cfacts


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import org.json.JSONArray

class FactDetailActivity : AppCompatActivity() {
    private val url = "https://aws.random.cat/meow"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fact_detail)
        val queue = Volley.newRequestQueue(this)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility = View.VISIBLE
        val stringRequest = StringRequest(

            Request.Method.GET,
            url,
            {res ->

                val randomImage = findViewById<ImageView>(R.id.randomImage)
                Glide.with(this).load("https://cataas.com/cat/cute").into(randomImage)
                progressBar.visibility = View.GONE



            },
            {
                Toast.makeText(this, "картинка не загружена", Toast.LENGTH_LONG).show()

            }
        )
        queue.add(stringRequest)

        val detailFactTextView = findViewById<TextView>(R.id.detailFactTextView)

        detailFactTextView.text = intent.getStringExtra("FactText")



    }

    private fun resToString(res:String):String{
        var imageUrl:String = ""
        val jsonArray = JSONArray(res)
        for (i in 0 until jsonArray.length()){
            val jsonObject = jsonArray.getJSONObject(i)
            val fileUrl = jsonObject.getString("file")
            imageUrl = fileUrl
        }
        return imageUrl
    }
}