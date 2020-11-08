package com.mrmobo.mvvm2.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.mrmobo.mvvm2.R
import com.mrmobo.mvvm2.data.models.User
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_user.view.*

class UsersAdapter(val data: List<User>):RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.item_user, parent, false))

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size


}

class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bind(item: User) = with(itemView){
        usernameTv.text = item.login
        Picasso.get().load(item.avatar_url).into(userImgView)
    }
}