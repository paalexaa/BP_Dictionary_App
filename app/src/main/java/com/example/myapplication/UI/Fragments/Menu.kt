package com.example.myapplication.UI.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.myapplication.DataBase.SubjectDao
import com.example.myapplication.R
import com.example.myapplication.UI.Adapters.Adapter
import com.example.myapplication.ViewModel.SubjectViewModel
import com.example.myapplication.databinding.FragmentMenuBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class Menu : Fragment() {

    private val subjectViewModel: SubjectViewModel by viewModels()
    private lateinit var binding: FragmentMenuBinding

    @Inject
    lateinit var subjectDao: SubjectDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)

        subjectViewModel.getSubjects.observe(viewLifecycleOwner, Observer { subjects ->
            val adapter = Adapter(requireContext(), subjects)
            binding.subjectsList.adapter = adapter
        })

//        binding.subjectsList.setOnItemClickListener { parent, view, position, id ->
//            val selectedSubject = (binding.subjectsList.adapter as Adapter).getItem(position)
//
//            val wordPageFragment = WordPage()
//            val bundle = Bundle().apply {
//                putString("name", selectedSubject.name)
//            }
//            wordPageFragment.arguments = bundle
//
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, wordPageFragment)
//                .addToBackStack(null)
//                .commit()
//        }
        return binding.root
    }
}
