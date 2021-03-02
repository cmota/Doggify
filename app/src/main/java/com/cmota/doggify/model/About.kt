package com.cmota.doggify.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class About(
    val age: String,
    val color: String,
    val sex: String
) : Parcelable