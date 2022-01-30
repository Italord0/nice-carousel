package com.italo.nice_carousel

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ContextThemeWrapper
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
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

    init {
        setLayout()
    }

    private fun setLayout() {

    }

    fun setActivity(appCompatActivity: AppCompatActivity){
        carouselAdapter = CarouselAdapter(appCompatActivity)
        binding.niceCarouselViewPager.adapter = carouselAdapter
    }

    fun addFragment(fragment: Fragment) {
        carouselAdapter.addFragment(fragment)
    }

    fun addFragment(fragments : ArrayList<Fragment>){
        carouselAdapter.addFragment(fragments)
    }

    fun enableIndicator(enabled: Boolean) {

    }

    fun setSlideDuration(duration: Int) {

    }

}