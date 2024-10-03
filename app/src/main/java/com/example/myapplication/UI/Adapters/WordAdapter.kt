package com.example.myapplication.UI.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.Difficulty
import com.example.myapplication.R
import com.example.myapplication.Word_DB

class WordAdapter (private val context: Context, private val arrayList: ArrayList<Word_DB>)
    : ArrayAdapter<Word_DB>(context, R.layout.wordpage_item, arrayList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.wordpage_item, null)

        val wordName : TextView = view.findViewById(R.id.word_name)
        val difficultyCircle: ImageView = view.findViewById(R.id.imageView)

        wordName.text = arrayList[position].wordName

        when (arrayList[position].difficulty) {
            Difficulty.EASY -> difficultyCircle.setImageResource(R.drawable.baseline_circle_green)
            Difficulty.MEDIUM -> difficultyCircle.setImageResource(R.drawable.baseline_circle_yellow)
            Difficulty.HARD -> difficultyCircle.setImageResource(R.drawable.baseline_circle_red)
        }

        return view
    }
}