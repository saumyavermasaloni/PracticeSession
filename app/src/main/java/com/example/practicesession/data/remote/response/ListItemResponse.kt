package com.example.practicesession.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ListItemResponse(

    @Expose
    @SerializedName("status")
    var status:String,

    @Expose
    @SerializedName("order_number")
    var order_number:String,

    @Expose
    @SerializedName("cust_id")
    var cust_id:Int
)