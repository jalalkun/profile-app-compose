package com.jalalkun.profileappcompose.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Name(
    @SerializedName("first")
    val first: String? = "",
    @SerializedName("last")
    val last: String? = "",
    @SerializedName("title")
    val title: String? = ""
): Parcelable