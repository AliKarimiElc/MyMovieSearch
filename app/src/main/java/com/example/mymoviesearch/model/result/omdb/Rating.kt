package com.example.mymoviesearch.model.result.omdb

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Rating(
    @SerializedName("Source")
    var source: String?,
    @SerializedName("Value")
    var value: String?
):Serializable