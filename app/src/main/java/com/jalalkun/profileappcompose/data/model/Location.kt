package com.jalalkun.profileappcompose.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(
    @SerializedName("city")
    val city: String? = "",
    @SerializedName("coordinates")
    val coordinates: Coordinates? = Coordinates(),
    @SerializedName("country")
    val country: String? = "",
    @SerializedName("postcode")
    val postcode: String? = "",
    @SerializedName("state")
    val state: String? = "",
    @SerializedName("street")
    val street: Street? = Street(),
    @SerializedName("timezone")
    val timezone: Timezone? = Timezone()
): Parcelable