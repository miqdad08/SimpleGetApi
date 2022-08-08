package com.miqdad.android.simplegetapi.api.network

import com.miqdad.android.simplegetapi.api.data.UsersResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiService {
    @GET("users")
    @Headers("Authorization: token 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")
    fun getListUser(): Call<ArrayList<UsersResponseItem>>
}