package com.example.practicesession.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Otp(

    @Expose
    @SerializedName("mobile")
    val mobile:String,

    @Expose
    @SerializedName("type")
    val type:String
)
