package com.volkankelleci.newsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.volkankelleci.newsapp.R
import com.volkankelleci.newsapp.model.Article

class ArticleAdapter:RecyclerView.Adapter<ArticleAdapter.NewsAdapterViewHolder>() {

    class NewsAdapterViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    private val diffUtil=object:DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url==newItem.url

        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem==newItem
        }

    }
    private val differ=AsyncListDiffer(this,diffUtil)
    var arts:List<Article>
        get() = differ.currentList
        set(value) =differ.submitList(value)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapterViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_article_preview,parent,false)
        return NewsAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsAdapterViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return arts.size
    }
}