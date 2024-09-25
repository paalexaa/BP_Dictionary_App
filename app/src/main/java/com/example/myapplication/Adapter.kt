package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class Adapter (private val context: Context, private val arrayList: ArrayList<Subject_DB>)
    : ArrayAdapter<Subject_DB>(context, R.layout.menu_items, arrayList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.menu_items, null)

        val subjectName : TextView = view.findViewById(R.id.subjects_name)

        subjectName.text = arrayList[position].subjectName


        return view
    }
}