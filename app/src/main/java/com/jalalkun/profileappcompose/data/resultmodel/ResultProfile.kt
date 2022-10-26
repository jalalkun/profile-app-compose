package com.jalalkun.profileappcompose.data.resultmodel


import com.google.gson.annotations.SerializedName
import com.jalalkun.apiservice.models.Info
import com.jalalkun.profileappcompose.data.model.DataProfile

data class ResultProfile(
    @SerializedName("info")
    val info: Info = Info(),
    @SerializedName("results")
    val results: List<DataProfile> = listOf()
)