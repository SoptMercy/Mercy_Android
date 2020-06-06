package com.mercyteam.mercy.data

data class ResponseRecommend(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : DrugData?
)

data class DrugData(
    val name : String,
    val image : String,
    val price : String,
    val content : String
)