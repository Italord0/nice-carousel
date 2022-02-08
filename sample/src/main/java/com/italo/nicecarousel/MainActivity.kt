package com.italo.nicecarousel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.italo.nicecarousel.databinding.ActivityMainBinding
import com.italo.nicecarousel.fragments.Fragment1
import com.italo.nicecarousel.fragments.Fragment2
import com.italo.nicecarousel.fragments.Fragment3

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            carousel.setActivity(this@MainActivity)
            carousel.addFragment(Fragment1())
            carousel.addFragment(Fragment2())
            carousel.addFragment(Fragment3())
            carousel.setSlideDuration(3)
        }
    }
}
