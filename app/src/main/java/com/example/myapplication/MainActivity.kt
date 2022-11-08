package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.DetailActivity.Companion.EXTRA_CLUB
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

        //deklarasi adapter to detail
        adapter.setonItemClickListener(object : Adapter.onItemClickListener{
            override fun onItemClicked(data: Club) {
                val clubparcel = Club(
                    data.name,
                    data.league,
                    data.stadium,
                    data.coach,
                    data.banner,
                    data.image
                )
                val intent = Intent(this@MainActivity,DetailActivity::class.java)
                intent.putExtra(EXTRA_CLUB,clubparcel)
                startActivity(intent)
            }

        })

    }
    //show data to recycleview
    @SuppressLint("Recycle")
    private fun getListClub(): ArrayList<Club>{
        val name = resources.getStringArray(R.array.Data)
        val league = resources.getStringArray(R.array.Desc)
        val stadium = resources.getStringArray(R.array.stadium)
        val coach = resources.getStringArray(R.array.Coach)
        val banner = resources.obtainTypedArray(R.array.banner)
        val image:TypedArray = resources.obtainTypedArray(R.array.list)

        val ListClub = ArrayList<Club>()
        for(i in name.indices){
            val club = Club(
                name[i],
                league[i],
                stadium[i],
                coach[i],
                banner.getResourceId(i, -1),
                image.getResourceId(i,-1)
            )
            ListClub.add(club)
        }
        return ListClub
    }
}
