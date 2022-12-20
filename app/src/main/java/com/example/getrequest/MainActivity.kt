package com.example.getrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.getrequest.databinding.ActivityMainBinding
import com.example.getrequest.viewmodel.MainActivityViewmodel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: MainActivityViewmodel = ViewModelProvider(this)[MainActivityViewmodel::class.java]


        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer {
            Log.d(TAG, it.body)
            Log.d(TAG, it.title)
            Log.d(TAG, it.id.toString())
            Log.d(TAG, it.userId.toString())
        })

        viewModel.getPosts()
        viewModel.myResponseList.observe(this, Observer {
            for (user in it) {
                Log.d(TAG, user.body)
                Log.d(TAG, user.title)
                Log.d(TAG, user.id.toString())
                Log.d(TAG, user.userId.toString())
            }
        })
    }
}