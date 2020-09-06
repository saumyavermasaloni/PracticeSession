package com.example.practicesession.data.remote.request

import com.example.practicesession.data.model.ItemList
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ListItemRequest(
    @Expose
    @SerializedName("order_number")
    var order_number:String,

    @Expose
    @SerializedName("transaction_number")
    var transaction_number:String,

    @Expose
    @SerializedName("shop_id")
    var shop_id:String,

    @Expose
    @SerializedName("subtotal")
    var subtotal:String,

    @Expose
    @SerializedName("cgst")
    var cgst:String,

    @Expose
    @SerializedName("sgst")
    var sgst:Int,

    @Expose
    @SerializedName("grand_total")
    var grand_total:String,

    @Expose
    @SerializedName("user_id")
    var user_id:String,

    @Expose
    @SerializedName("items")
    var items:List<ItemList>
)
