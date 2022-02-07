package com.italo.nice_carousel

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ContextThemeWrapper
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.italo.nice_carousel.databinding.NiceCarouselBinding

class NiceCarousel @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding: NiceCarouselBinding by lazy {
        val contextTheme = ContextThemeWrapper(context, R.style.Theme_MaterialComponents)
        NiceCarouselBinding.inflate(LayoutInflater.from(contextTheme), this)
    }

    private lateinit var carouselAdapter: CarouselAdapter

    private fun setLayout() {
        with(binding){
            TabLayoutMediator(niceCarouselTabLayout,niceCarouselViewPager) { _,_ -> }.attach()
        }
    }

    fun setActivity(appCompatActivity: AppCompatActivity){
        carouselAdapter = CarouselAdapter(appCompatActivity)
        binding.niceCarouselViewPager.adapter = carouselAdapter
    }

    fun addFragment(fragment: Fragment) {
        carouselAdapter.addFragment(fragment)
        setLayout()
    }

    fun addFragment(fragments : ArrayList<Fragment>){
        carouselAdapter.addFragment(fragments)
        setLayout()
    }

    fun enableIndicator(enabled: Boolean) {
        if (enabled.not()) {
            binding.niceCarouselTabLayout.visibility = GONE
        }
    }

    fun setSlideDuration(duration: Int) {

    }

}