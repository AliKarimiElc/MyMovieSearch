package com.example.mymoviesearch.repository.remote

import com.example.mymoviesearch.model.result.omdb.OmdbTResult
import com.example.mymoviesearch.model.result.SearchResult
import com.example.mymoviesearch.model.result.omdb.OmdbSearchResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("search/movie?api_key=6315bf3f1feda1c8e29584aa8efcaef7")
    fun get(@Query("query") name: String): Call<SearchResult>

    @GET("?apikey=70ad462a")
    fun getOmdbMovie(@Query("t") name: String): Call<OmdbTResult>

    @GET("?apikey=70ad462a")
    fun searchOmdbMovie(@Query("s") name: String): Call<OmdbSearchResult>


}