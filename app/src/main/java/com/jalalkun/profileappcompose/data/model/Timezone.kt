package com.jalalkun.profileappcompose.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Timezone(
    @SerializedName("description")
    val description: String?,
    @SerializedName("offset")
    val offset: String?
): Parcelable