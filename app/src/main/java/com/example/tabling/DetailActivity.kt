package com.example.tabling

import android.app.Activity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.tabling.databinding.ActivityDetailBinding

class DetailActivity : Activity() {

    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        Glide.with(applicationContext).load(intent.getStringExtra("imageUrl")).into(binding.imageDetail)

    }

}