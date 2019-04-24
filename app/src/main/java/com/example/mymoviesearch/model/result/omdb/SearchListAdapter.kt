package com.example.mymoviesearch.model.result.omdb

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymoviesearch.DownloadImageTask
import com.example.mymoviesearch.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.search_list_item.*


class SearchListAdapter(var list: List<Search?>?, var context: Context) : RecyclerView.Adapter<SearchHolder>() {

    override fun onBindViewHolder(holder: SearchHolder, position: Int) {
        list?.get(position)?.let { holder.bindItem(it) }
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onCreateViewHolder(holder: ViewGroup, position: Int): SearchHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.search_list_item, holder, false)
        return SearchHolder(view)
    }
}

class SearchHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun bindItem(item: Search) {
        try {
            titleView2.text = item.title
            yearView2.text = item.year
            imdbIdView2.text = item.imdbID
            typeView2.text = item.type
            DownloadImageTask(imageView2).execute(item.poster)
        } catch (e: Exception) {

        }
    }
}