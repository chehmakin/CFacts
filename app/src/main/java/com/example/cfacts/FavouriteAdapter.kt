package com.example.cfacts

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class FavouriteAdapter(var cntx: Context, var res:Int, var items:List<Fact>): ArrayAdapter<Fact>(cntx, res, items) {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(cntx)
        val view = layoutInflater.inflate(res, null)

        val factTextView = view.findViewById<TextView>(R.id.factTextView)
        val fromFavouriteBtn = view.findViewById<Button>(R.id.fromFavouriteBtn)

        val item = items[position]
        fromFavouriteBtn.setOnClickListener {
            FavouriteList.favouriteList.remove(Fact(item.text))
            Toast.makeText(parent.context, "Удалено", Toast.LENGTH_SHORT).show()


        }
        factTextView.text = item.text
        return view

    }
}