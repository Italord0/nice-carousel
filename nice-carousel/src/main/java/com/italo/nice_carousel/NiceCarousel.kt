package com.italo.nice_carousel

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ContextThemeWrapper
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.italo.nice_carousel.databinding.NiceCarouselBinding
import kotlin.concurrent.fixedRateTimer

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
    private lateinit var activity: AppCompatActivity

    private fun setLayout() {
        with(binding) {
            TabLayoutMediator(niceCarouselTabLayout, niceCarouselViewPager) { _, _ -> }.attach()
        }
    }

    fun setActivity(appCompatActivity: AppCompatActivity) {
        activity = appCompatActivity
        carouselAdapter = CarouselAdapter(activity)
        binding.niceCarouselViewPager.adapter = carouselAdapter
    }

    fun addFragment(fragment: Fragment) {
        carouselAdapter.addFragment(fragment)
        setLayout()
    }

    fun addFragment(fragments: ArrayList<Fragment>) {
        carouselAdapter.addFragment(fragments)
        setLayout()
    }

    fun addImage(imageUrl: String) {
        carouselAdapter.addFragment(ImageFragment(imageUrl))
        setLayout()
    }

    fun addImage(@DrawableRes drawable: Int) {
        carouselAdapter.addFragment(ImageFragment(drawable))
        setLayout()
    }

    fun enableIndicator(enabled: Boolean) {
        if (enabled.not()) {
            binding.niceCarouselTabLayout.visibility = GONE
        }
    }

    fun setSlideDuration(duration: Long) {
        fixedRateTimer(
            name = FIXED_RATE_TIMER_NAME,
            daemon = false, initialDelay = duration * 1000, period = duration * 1000
        ) {
            animateViewPager()
        }
    }

    private fun animateViewPager() {
        with(binding) {
            val currentIndex = niceCarouselViewPager.currentItem
            val itemCount = carouselAdapter.itemCount
            activity.runOnUiThread {
                when (itemCount > (currentIndex.plus(1))) {
                    true -> niceCarouselViewPager.setCurrentItem(currentIndex.plus(1), true)
                    else -> niceCarouselViewPager.setCurrentItem(0, true)
                }
            }
        }
    }

}

private const val FIXED_RATE_TIMER_NAME = "carouselTimer"
