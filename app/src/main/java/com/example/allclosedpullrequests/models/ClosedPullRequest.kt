package com.example.allclosedpullrequests.models

import com.google.gson.annotations.SerializedName

data class ClosedPullRequest(
    val title:String?,
    @SerializedName("created_at")
    val created_date:String?,
    @SerializedName("closed_at")
    val closed_date:String?,
    val user:User
)
