package com.example.practicesession.data.remote.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class OtpRequest(

    @Expose
    @SerializedName("mobile")
    val mobile:String,

    @Expose
    @SerializedName("type")
    val type:Int
)