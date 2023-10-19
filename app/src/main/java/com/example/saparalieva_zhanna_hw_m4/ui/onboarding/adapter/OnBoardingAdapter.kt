package com.example.saparalieva_zhanna_hw_m4.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.saparalieva_zhanna_hw_m4.databinding.FragmentOnBoardingBinding
import com.example.saparalieva_zhanna_hw_m4.databinding.ItemOnboardingBinding
import com.example.saparalieva_zhanna_hw_m4.model.OnBoarding
import com.example.saparalieva_zhanna_hw_m4.utils.loadImage

class OnBoardingAdapter(private val onClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {
    private val list = arrayListOf<OnBoarding>(
        OnBoarding("Title1", "Desc1", "https://dspncdn.com/a1/media/originals/6f/f3/51/6ff35161e8ddf3b77a089c434953e83c.jpg"),
        OnBoarding("Title2", "Desc2", "https://www.playmeo.com/wp-content/uploads/2021/06/Planning-Board-for-sequencing-programs-shutterstock_615691754.png"),
        OnBoarding("Title3", "Desc3", "https://www.pinclipart.com/picdir/big/409-4092024_get-started-for-free-clipart.png")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoarding) = with(binding) {
            tvTitle.text = onBoarding.title
            tvDesc.text = onBoarding.desc
            tvSkip.isVisible = adapterPosition != list.lastIndex
            btnGetStarted.isVisible = adapterPosition == list.lastIndex
            ivBoard.loadImage(onBoarding.image.toString())

            btnGetStarted.setOnClickListener {
                onClick()
            }
            tvSkip.setOnClickListener {
                onClick()
            }

        }


    }

}