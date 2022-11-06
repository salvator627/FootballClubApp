package com.example.myapplication

import android.annotation.SuppressLint
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<Club>()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvClub.setHasFixedSize(true)

        list.addAll(getListClub())
        binding.rvClub.layoutManager = LinearLayoutManager(this)
        val adapter = Adapter(list)
        binding.rvClub.adapter = adapter
    }

    @SuppressLint("Recycle")
    private fun getListClub(): ArrayList<Club>{
        val name = resources.getStringArray(R.array.Data)
        val league = resources.getStringArray(R.array.Desc)
        val image:TypedArray = resources.obtainTypedArray(R.array.list)

        val ListClub = ArrayList<Club>()
        for(i in name.indices){
            val club = Club(
                name[i],
                league[i],
                image.getResourceId(i,-1)
            )
            ListClub.add(club)
        }
        return ListClub
    }
}