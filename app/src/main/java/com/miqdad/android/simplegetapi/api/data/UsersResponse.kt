package com.miqdad.android.simplegetapi.api.data

import com.google.gson.annotations.SerializedName

data class UsersResponse(

	@field:SerializedName("UsersResponse")
	val usersResponse: List<UsersResponseItem?>? = null
)