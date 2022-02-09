package com.italo.nice_carousel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import com.italo.nice_carousel.databinding.FragmentImageBinding

class ImageFragment(private var imageUrl: String?, private var drawable: Int?) : Fragment() {

    constructor(imageUrl: String?) : this(imageUrl, null) {
        this.imageUrl = imageUrl
    }

    constructor(@DrawableRes drawable: Int?) : this(null, drawable) {
        this.drawable = drawable
    }

    private var _binding: FragmentImageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageUrl?.let {
            binding.fragmentImage.load(it)
        }
        drawable?.let {
            binding.fragmentImage.load(it)
        }
    }

}
