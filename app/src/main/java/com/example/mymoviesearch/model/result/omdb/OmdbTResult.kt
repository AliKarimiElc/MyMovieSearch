package com.example.mymoviesearch.model.result.omdb

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class OmdbTResult(
    @SerializedName("Actors")
    var actors: String? = null,
    @SerializedName("Awards")
    var awards: String? = null,
    @SerializedName("BoxOffice")
    var boxOffice: String? = null,
    @SerializedName("Country")
    var country: String? = null,
    @SerializedName("DVD")
    var dVD: String? = null,
    @SerializedName("Director")
    var director: String? = null,
    @SerializedName("Genre")
    var genre: String? = null,
    @SerializedName("Language")
    var language: String? = null,
    @SerializedName("Metascore")
    var metascore: String? = null,
    @SerializedName("Plot")
    var plot: String? = null,
    @SerializedName("Poster")
    var poster: String? = null,
    @SerializedName("Production")
    var production: String? = null,
    @SerializedName("Rated")
    var rated: String? = null,
    @SerializedName("Ratings")
    var ratings: List<Rating?>? = null,
    @SerializedName("Released")
    var released: String? = null,
    @SerializedName("Response")
    var response: String? = null,
    @SerializedName("Runtime")
    var runtime: String? = null,
    @SerializedName("Title")
    var title: String? = null,
    @SerializedName("Type")
    var type: String? = null,
    @SerializedName("Website")
    var website: String? = null,
    @SerializedName("Writer")
    var writer: String? = null,
    @SerializedName("Year")
    var year: String? = null,
    @SerializedName("imdbID")
    var imdbID: String? = null,
    @SerializedName("imdbRating")
    var imdbRating: String? = null,
    @SerializedName("imdbVotes")
    var imdbVotes: String? = null
) : Serializable