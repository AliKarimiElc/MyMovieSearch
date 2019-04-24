package com.example.mymoviesearch.model.result.omdb

import com.google.gson.annotations.SerializedName

data class OmdbSearchResult(
    @SerializedName("Response")
    var response: String?,
    @SerializedName("Search")
    var search: List<Search?>?,
    @SerializedName("totalResults")
    var totalResults: String?
)