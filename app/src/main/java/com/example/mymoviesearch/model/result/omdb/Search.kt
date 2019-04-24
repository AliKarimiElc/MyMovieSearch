package com.example.mymoviesearch.model.result.omdb

import com.google.gson.annotations.SerializedName

data class Search(
    @SerializedName("Poster")
    var poster: String?,
    @SerializedName("Title")
    var title: String?,
    @SerializedName("Type")
    var type: String?,
    @SerializedName("Year")
    var year: String?,
    @SerializedName("imdbID")
    var imdbID: String?
)