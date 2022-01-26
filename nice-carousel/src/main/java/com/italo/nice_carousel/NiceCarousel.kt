package com.italo.nice_carousel

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.view.ContextThemeWrapper
import androidx.constraintlayout.widget.ConstraintLayout
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

    init {
        setLayout()
    }

    private fun setLayout() {

    }

}