package com.italo.nicecarousel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.italo.nicecarousel.databinding.ActivityMainBinding
import com.italo.nicecarousel.fragments.Fragment1
import com.italo.nicecarousel.fragments.Fragment2
import com.italo.nicecarousel.fragments.Fragment3

class MainActivity : AppCompatActivity() {

    private var binding : ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.carousel?.setActivity(this)
        binding?.carousel?.addFragment(Fragment1())
        binding?.carousel?.addFragment(Fragment2())
        binding?.carousel?.addFragment(Fragment3())

    }
}