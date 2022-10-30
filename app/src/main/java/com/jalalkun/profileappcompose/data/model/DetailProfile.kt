package com.jalalkun.profileappcompose.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DetailProfile(
    val name: String,
    val phoneNumber:String,
    val email: String,
    val birthday: String,
    val address: String,
    val picture: String,
) : Parcelable