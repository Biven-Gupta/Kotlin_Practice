package com.example.kotlinpractice.retrofit

import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinpractice.databinding.ActivityRetrofitPracticeBinding
import com.facebook.drawee.backends.pipeline.Fresco
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL ="https://jsonplaceholder.typicode.com/"

class RetrofitPractice : AppCompatActivity() {
    private lateinit var binding: ActivityRetrofitPracticeBinding
    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetrofitPracticeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Fresco.initialize(this)
        //setContentView(R.layout.activity_retrofit_practice)
        binding.recyclerView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = linearLayoutManager
        getMyData()
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL).build().create(Apiinterface::class.java)
        val retrofitData = retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>,
            ) {
                val responseBody = response.body()
                myAdapter = MyAdapter(baseContext,responseBody!!)
                myAdapter.notifyDataSetChanged()
                binding.recyclerView.adapter = myAdapter


            }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                TODO("Not yet implemented")
                d("RetrofitPractice","OnFailure ${t.message}")
            }
        })
    }
}