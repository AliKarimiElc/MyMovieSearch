package com.example.mymoviesearch

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.mymoviesearch.model.result.omdb.OmdbTResult
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var movie: OmdbTResult? = null

        val extras = intent.extras
        if (extras != null) {
            movie = extras.get("movie") as OmdbTResult
        }

        titleView.text=movie?.title
        yearView.text=movie?.year
        releasedView.text=movie?.released
        runtimeView.text=movie?.runtime
        genrView.text=movie?.genre
    }
}
