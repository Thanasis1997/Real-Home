package com.example.myrealestate


import com.google.gson.annotations.SerializedName

data class ResponseData(
    @SerializedName("homes")
    val homes: List<Home>
) {


    data class Home(
        @SerializedName("city")
        val city: String,
        @SerializedName("homeImage")
        val homeImage: String,
        @SerializedName("_id")
        val id: String,
        @SerializedName("price")
        val price: Int,
        @SerializedName("request")
        val request: Request,
        @SerializedName("squaremeters")
        val squaremeters: Int
    ) {
        data class Request(
            @SerializedName("url")
            val url: String
        )
    }
}