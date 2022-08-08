package com.miqdad.android.simplegetapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miqdad.android.simplegetapi.api.data.UsersResponseItem
import com.miqdad.android.simplegetapi.databinding.ItemUsersBinding

class UsersAdapter: RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    private val listUsers = ArrayList<UsersResponseItem>()

    class UsersViewHolder(val itemUser : ItemUsersBinding):RecyclerView.ViewHolder(itemUser.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UsersViewHolder(
        ItemUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )


    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.itemUser.apply {
            with(listUsers[position]){
                tvUsers.text = login
                Glide.with(imageUsers.context).load(avatarUrl).into(imageUsers)
            }
        }
    }

    override fun getItemCount(): Int = listUsers.size

    fun setUser(users : List<UsersResponseItem>){
        this.listUsers.clear()
        this.listUsers.addAll(users)
    }
}