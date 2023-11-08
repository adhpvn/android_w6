package com.example.androidw6_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemsList = arrayListOf<ItemModel>()

        // Danh sách các tên ứng dụng ngẫu nhiên
        val randomAppNames = listOf(
            "Facebook",
            "Messenger",
            "Youtube",
            "Zoom",
            "Instagram",
            "Gmail",
            "Tinder",
            "Telegram",
            "Escape",
            "IctSV"
        )

        val random = Random()
        val randomIndexes = ArrayList<Int>() // Danh sách để theo dõi chỉ số ngẫu nhiên đã được chọn
        val maxApps = randomAppNames.size

        for (i in 1..10) {
            var randomIndex: Int
            do {
                randomIndex = random.nextInt(maxApps)
            } while (randomIndexes.contains(randomIndex))
            randomIndexes.add(randomIndex)

            val appName = randomAppNames[randomIndex]
            val imageResourceName = "thumb${randomIndex + 1}"
            val randomNumber = Random().nextInt(5).toString()

            itemsList.add(
                ItemModel(
                    resources.getIdentifier(imageResourceName, "drawable", packageName),
                    appName,
                    "$randomNumber"
                )
            )
        }

        val adapter = ItemAdapter(itemsList)
        val recyclerView1 = findViewById<RecyclerView>(R.id.recyclerView1)
        val recyclerView2 = findViewById<RecyclerView>(R.id.recyclerView2)
        val recyclerView3 = findViewById<RecyclerView>(R.id.recyclerView3)
        val recyclerView4 = findViewById<RecyclerView>(R.id.recyclerView4)

        recyclerView1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView1.adapter = adapter
        recyclerView2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView2.adapter = adapter
        recyclerView3.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView3.adapter = adapter
        recyclerView4.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView4.adapter = adapter
    }
}