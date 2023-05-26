package com.example.tasksolution2505

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tasksolution2505.adapter.Adapter
import com.example.tasksolution2505.databinding.ActivityMainBinding
import com.example.tasksolution2505.model.Results
import com.example.tasksolution2505.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.HORIZONTAL, false
        )
        onClickListener()
        getMovie()
    }
    fun onClickListener() {
        binding.popularButtonId.setOnClickListener {

        }
        binding.upcomingFilmsButtonId.setOnClickListener {

        }
    }
    fun getMovie() {
        val call: Call<Results> = RetrofitClient.getInstances()!!
            .getMyApi().getUpcomingMovie(Constants.API_KEY)
        call.enqueue(object : Callback<Results> {
            override fun onResponse(call: Call<Results>, response: Response<Results>) {
                val movieList: Results = response.body() as Results
                binding.recyclerView.adapter = Adapter(movieList.results)
            }

            override fun onFailure(call: Call<Results>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
            }
        })
    }
}