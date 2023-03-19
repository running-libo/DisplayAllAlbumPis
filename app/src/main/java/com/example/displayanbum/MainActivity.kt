package com.example.displayanbum

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, 100)
        }
        loadData()
    }

    private fun loadData() {
        recyclerView = findViewById(R.id.recyclerview)
        var adapter = MyAdapter(applicationContext)
        recyclerView?.adapter = adapter
        MediaFileLoader.loadMediaFile(applicationContext)?.let {
            adapter.setDatas(it)
        }
    }
}