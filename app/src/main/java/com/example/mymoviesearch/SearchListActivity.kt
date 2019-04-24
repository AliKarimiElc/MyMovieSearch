package com.example.mymoviesearch

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.example.mymoviesearch.model.result.omdb.OmdbSearchResult
import com.example.mymoviesearch.model.result.omdb.SearchListAdapter
import com.example.mymoviesearch.repository.remote.RetrofitServiceGenerator
import com.example.mymoviesearch.repository.remote.Service
import kotlinx.android.synthetic.main.activity_search_list.*

class SearchListActivity : AppCompatActivity() {

    var adapter: SearchListAdapter? = null
    var searchText: String? = null
    private lateinit var layoutManager: LinearLayoutManager


    private val service: Service = RetrofitServiceGenerator().createService(Service::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_list)
    }

    override fun onResume() {
        super.onResume()

        val extra = intent.extras
        if (extra != null) {
            searchText = extra.getString("searchText")
        }
        if (searchText != null && searchText!!.isNotEmpty()) {
            service.searchOmdbMovie(searchText!!).enqueue(object : retrofit2.Callback<OmdbSearchResult> {

                override fun onResponse(
                    call: retrofit2.Call<OmdbSearchResult>,
                    response: retrofit2.Response<OmdbSearchResult>
                ) {
                    try {
                        if (response.code() == 200) {
                            runOnUiThread {
                                try {
                                    Log.d(
                                        "res",
                                        response.code().toString() + " " + response.message() + call.request().url()
                                    )
                                    layoutManager = LinearLayoutManager(this@SearchListActivity)
                                    movieRecycler.layoutManager = layoutManager
                                    adapter = SearchListAdapter(response.body()?.search, this@SearchListActivity)
                                    movieRecycler.adapter = adapter
                                    adapter?.notifyDataSetChanged()
                                } catch (e: Exception) {

                                }
                            }
                        } else {
                            Log.d("res", response.code().toString() + " " + response.message() + call.request().url())
                            Toast.makeText(
                                this@SearchListActivity,
                                response.code().toString() + " " + response.message(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } catch (e: Exception) {
                        runOnUiThread {
                            Log.d(
                                "res",
                                response.code().toString() + " " + response.message() + " " + call.request().url() + " " + e.message
                            )
                            Toast.makeText(this@SearchListActivity, "Movie not found!!!!!!", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                override fun onFailure(call: retrofit2.Call<OmdbSearchResult>, t: Throwable) {
                    Log.d("FAIL", t.message + " " + call.request().url())
                    runOnUiThread {
                        Toast.makeText(this@SearchListActivity, "can not connect", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }
}
