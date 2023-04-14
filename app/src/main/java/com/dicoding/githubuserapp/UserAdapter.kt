package com.dicoding.githubuserapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.githubuserapp.databinding.ListUserBinding


class UserAdapter(private val listUser: ArrayList<ModelUser>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback


    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    class UserViewHolder(var binding: ListUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ListUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = listUser[position]

        holder.binding.apply {
            tvUsername.text = user.username
            tvName.text = user.name
            tvCompany.text = user.company

            Glide.with(holder.itemView.context)
                .load(user.avatar)
                .apply(RequestOptions.circleCropTransform())
                .into(imgUser)
        }
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(user) }

    }

    override fun getItemCount(): Int = listUser.size

    interface OnItemClickCallback {
        fun onItemClicked(user: ModelUser)
    }

}


