package com.example.cfacts


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FactDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fact_detail)

        val detailFactTextView = findViewById<TextView>(R.id.detailFactTextView)
        detailFactTextView.text = intent.getStringExtra("FactText")
    }
}