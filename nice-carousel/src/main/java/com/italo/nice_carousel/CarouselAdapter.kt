package com.italo.nice_carousel

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class CarouselAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    private var fragmentList = arrayListOf<Fragment>()

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

    fun addFragment(fragment: Fragment){
        this.fragmentList.add(fragment)
    }

    fun addFragment(fragments : ArrayList<Fragment>) {
        this.fragmentList.addAll(fragments)
    }

}