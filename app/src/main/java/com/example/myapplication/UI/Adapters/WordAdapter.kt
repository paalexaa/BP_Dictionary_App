package com.example.myapplication.UI.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.wordDatabase.WordEntity

class WordAdapter (context: Context, private val arrayList: List<WordEntity>)
    : ArrayAdapter<WordEntity>(context, R.layout.wordpage_item, arrayList){

    private class ViewHolder(view: View) {
        val wordName: TextView = view.findViewById(R.id.word_name)
        val difficultyCircle: ImageView = view.findViewById(R.id.imageView)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.wordpage_item, parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val word = arrayList[position]

        holder.wordName.text = word.wordName

        when (word.difficulty) {
            0 -> holder.difficultyCircle.setImageResource(R.drawable.baseline_circle_green)
            1 -> holder.difficultyCircle.setImageResource(R.drawable.baseline_circle_yellow)
            2 -> holder.difficultyCircle.setImageResource(R.drawable.baseline_circle_red)
            else -> holder.difficultyCircle.setImageResource(R.drawable.baseline_circle_green)
        }

        return view
    }
}