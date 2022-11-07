package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_CLUB = "extra_club"
    }
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var intent = intent.getParcelableExtra<Club>(EXTRA_CLUB)

        binding.namedetail.text = intent?.name
        binding.leaguedetail.text = intent?.league
        binding.tvStadium.text = intent?.stadium
        binding.textView2.text = intent?.coach
        binding.imageView2.setImageResource(intent?.image!!)
    }
}