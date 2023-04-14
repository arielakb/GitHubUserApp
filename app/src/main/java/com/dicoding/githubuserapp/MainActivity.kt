package com.dicoding.githubuserapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.githubuserapp.DetailUserActivity.Companion.EXTRA_DETAIL
import com.dicoding.githubuserapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var rvUser: RecyclerView

    private val list = ArrayList<ModelUser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        rvUser = mainBinding.rvUser
        rvUser.setHasFixedSize(true)

        list.addAll(listUser)
        showRecyclerView()
    }

    private val listUser: ArrayList<ModelUser>
        get() {
            val dataUsername = resources.getStringArray(R.array.username)
            val dataName = resources.getStringArray(R.array.name)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val dataAvatar = resources.obtainTypedArray(R.array.avatar)

            val listUser = ArrayList<ModelUser>()

            for (i in dataUsername.indices) {
                val user = ModelUser(
                    dataUsername[i],
                    dataName[i],
                    dataLocation[i],
                    dataCompany[i],
                    dataRepository[i],
                    dataFollowers[i],
                    dataFollowing[i],
                    dataAvatar.getResourceId(i, -1)
                )
                listUser.add(user)
            }

            return listUser
        }

    private fun showRecyclerView() {
        rvUser.layoutManager = LinearLayoutManager(this)

        val UserAdapter = UserAdapter(list)
        rvUser.adapter = UserAdapter

        UserAdapter.setOnItemClickCallback(object : UserAdapter.OnItemClickCallback {
            override fun onItemClicked(user: ModelUser) {
                goToDetailUser(user)
            }
        })

    }

    private fun goToDetailUser(user: ModelUser) {
        Intent(this, DetailUserActivity::class.java).apply {
            putExtra(EXTRA_DETAIL, user)
        }.also {
            startActivity(it)
        }
    }
}




