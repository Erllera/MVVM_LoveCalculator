package com.geektech.relesson52.model

import com.google.gson.annotations.SerializedName

//{
//    "fname": "Hina",
//    "sname": "Erlan",
//    "percentage": "56",
//    "result": "All the best!"
//}
data class LoveModel(
    val fname: String,
    val sname: String,
    val percentage: String,
    val result: String
)
