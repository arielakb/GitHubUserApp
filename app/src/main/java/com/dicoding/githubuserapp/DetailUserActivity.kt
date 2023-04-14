package com.dicoding.githubuserapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.githubuserapp.databinding.ActivityUserDetailBinding

class DetailUserActivity  : AppCompatActivity() {

    private lateinit var detailBinding: ActivityUserDetailBinding
    private lateinit var user: ModelUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detailBinding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        user = intent.extras?.getParcelable<ModelUser>(EXTRA_DETAIL) as ModelUser
        parseDetailUser (user)
    }


    private fun parseDetailUser (user: ModelUser) {
        detailBinding.apply {
            tvDetailNumberOfRepos.text = user.repository
            tvDetailNumberOfFollowers.text = user.followers
            tvDetailNumberOfFollowing.text = user.following
            tvDetailName.text = user.name
            tvDetailCompany.text = user.company
            tvDetailLocation.text = user.location

            Glide.with(this@DetailUserActivity)
                .load(user.avatar)
                .apply(RequestOptions.circleCropTransform())
                .into(ivDetailAvatar)

        }
    }
    companion object {
        const val EXTRA_DETAIL = "extra_detail"
    }

}