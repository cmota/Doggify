package com.cmota.doggify.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Details(
    val childrens: String,
    val life: String,
    val personality: String,
    val size: String
) : Parcelable