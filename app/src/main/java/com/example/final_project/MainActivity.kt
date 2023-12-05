package com.example.final_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList : ArrayList<News>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.amazon_icon,
            R.drawable.ebay_logo,
            R.drawable.weazel,
            R.drawable.wallmart_logo,
            R.drawable.twittard_logo,
            R.drawable.spotify_logo,
            R.drawable.instagram_logo,
            R.drawable.google_logo,
            R.drawable.life,
            R.drawable.epsilon_logo

        )

        heading = arrayOf(
            "Asset Management - Amazon",
            "Software Engineer",
            "Network Engineer",
            "Cashier",
            "Database Administrator",
            "Data Engineer",
            "Web Developer",
            "Backend Developer",
            "Designer",
            "Journalist"

        )


        newRecyclerView = findViewById(R.id.recycleView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)



        newArrayList = arrayListOf<News>()
        getUserdata()

    }

    private fun getUserdata(){

        for(i in imageId.indices){
            val news = News(imageId[i], heading[i])
            newArrayList.add(news)
        }

        var adapter = MyAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickedListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(this@MainActivity, "You Clicked on the item no. $position", Toast.LENGTH_SHORT).show()
            }

        })

    }

}