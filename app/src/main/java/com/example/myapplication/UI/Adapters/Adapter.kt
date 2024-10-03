package com.example.myapplication.UI.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.myapplication.DataBase.Subjects
import com.example.myapplication.R

class Adapter (private val context: Context, private val subjects: List<Subjects>) : BaseAdapter(){
    override fun getCount(): Int {
        return subjects.size
    }
    override fun getItem(position: Int): Subjects {
        return subjects[position]
    }
    override fun getItemId(position: Int): Long {
        return subjects[position].id?.toLong() ?: 0L
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.menu_items, parent, false)
        val subjectName = view.findViewById<TextView>(R.id.subjects_name)
        subjectName.text = getItem(position).name
        return view
    }
}