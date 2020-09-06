package com.example.practicesession.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ItemList(
    @Expose
    @SerializedName("item_id")
    var item_id: String? =null ,

    @Expose
    @SerializedName("item_qty")
    var item_qty: String? = null
)
