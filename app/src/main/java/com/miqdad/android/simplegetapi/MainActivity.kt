package com.miqdad.android.simplegetapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.miqdad.android.simplegetapi.api.data.UsersResponseItem
import com.miqdad.android.simplegetapi.api.network.ApiClient
import com.miqdad.android.simplegetapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val adapterUser = UsersAdapter()

    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get Api
        getApi()
        //setLayoutManager dan Adapter

    }

    fun setData(data: ArrayList<UsersResponseItem>){
        binding.rvUsers.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterUser
            adapterUser.setUser(data)
        }
    }

    fun getApi(){
        ApiClient.getApiService().getListUser().enqueue(object : Callback<ArrayList<UsersResponseItem>>{
            override fun onResponse(
                call: Call<ArrayList<UsersResponseItem>>,
                response: Response<ArrayList<UsersResponseItem>>
            ) {
                response.body()?.let {
//                    adapterUser.setUser(it!!)
                    setData(it)
                }
            }
            override fun onFailure(call: Call<ArrayList<UsersResponseItem>>, t: Throwable) {
                Log.e("TAG", "onFailure:$t")
            }

        })
    }
}