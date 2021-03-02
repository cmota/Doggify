package com.cmota.doggify.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DoggoItem(
    val about: About,
    val breed: String,
    val description: String,
    val details: Details,
    val featuredImg: String,
    val id: Int,
    val images: List<String>,
    val name: String
) : Parcelable