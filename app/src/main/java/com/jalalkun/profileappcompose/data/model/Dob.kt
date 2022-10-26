package com.jalalkun.profileappcompose.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dob(
    @SerializedName("age")
    val age: Int? = 0,
    @SerializedName("date")
    val date: String? = ""
): Parcelable