package com.example.practicesession.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class OtpResponse(

    @Expose
    @SerializedName("status")
    val status:String,

    @Expose
    @SerializedName("code")
    val code:String
)
