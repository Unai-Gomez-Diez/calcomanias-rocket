package com.example.calcomanias_rocket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calcomanias_rocket.databinding.ActivityMainBinding
import com.example.calcomanias_rocket.feature.decals.presentation.DecalsFragment

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding?=null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cargar el fragmento principal (DecalsFragment)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, DecalsFragment())
            .commit()
    }
}