package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myapplication.UI.Fragments.Menu
import com.example.myapplication.UI.Fragments.Settings
import com.example.myapplication.UI.Fragments.Translator
import com.example.myapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(Translator())
        binding.bottomNavigationView.selectedItemId = R.id.translator

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.translator -> replaceFragment(Translator())
                R.id.menu -> replaceFragment(Menu())
                R.id.settings -> replaceFragment(Settings())

                else -> {
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}