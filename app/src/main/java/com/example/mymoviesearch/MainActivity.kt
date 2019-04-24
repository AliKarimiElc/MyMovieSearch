package com.example.mymoviesearch

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.example.mymoviesearch.model.result.omdb.OmdbTResult
import com.example.mymoviesearch.repository.remote.RetrofitServiceGenerator
import com.example.mymoviesearch.repository.remote.Service
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onResume() {
        super.onResume()
        searchButton.setOnClickListener {
            var intent = Intent(this,SearchListActivity::class.java)
            intent.putExtra("searchText",searchBox.text.toString())
            startActivity(intent)
        }
    }
}
