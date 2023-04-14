package com.dicoding.githubuserapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelUser(
    val username: String,
    val name: String,
    val location: String,
    val company: String,
    val repository: String,
    val followers: String,
    val following: String,
    val avatar: Int
): Parcelable
