package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.example.myapplication.databinding.FragmentMenuBinding

class Menu : Fragment() {

    private lateinit var binding: FragmentMenuBinding
    private lateinit var subjectArrayList: ArrayList<Subject_DB>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)

        val names = arrayOf(
            "Algebra a diskrétna matematika",
            "Matematická analýza",
            "Matematická logika I",
            "Pravdepodobnosť a štatistika"
        )

        subjectArrayList = ArrayList()

        for (i in names.indices){
            val subject = Subject_DB(names[i])
            subjectArrayList.add(subject)
        }

        binding.subjectsList.isClickable = true
        binding.subjectsList.adapter = Adapter(requireContext(), subjectArrayList)
        binding.subjectsList.setOnItemClickListener { parent, view, position, id ->

            val name = names[position]

            val wordPageFragment = WordPage()

            val bundle = Bundle()
            bundle.putString("name", name)
            wordPageFragment.arguments = bundle

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, wordPageFragment)
                .addToBackStack(null)
                .commit()
        }
        return binding.root
    }
}
