package com.example.lifelonglearningapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.paging.LoadState
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.lifelonglearningapp.databinding.ItemSearchBinding

import timber.log.Timber
import java.nio.file.DirectoryStream
import java.nio.file.Files.size


class SearchPagingAdapter(clickListener: ClickListener) :
    PagingDataAdapter<Items, SearchPagingAdapter.SearchViewHolder>(COMPARATOR) {

    private var clickListener: ClickListener = clickListener

    inner class SearchViewHolder(private val binding: ItemSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bindAdapter(item: Items) = with(binding) {
            searchTitle.text = item.lctreNm
            searchDay.text = item.edcStartDay + " ~ " + item.edcEndDay
            searchDate.text = item.edcPlace
        }

    }


    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { holder.bindAdapter(it) }
        holder.itemView.setOnClickListener {
            clickListener.clickedItem(item)
        }
    }

    interface ClickListener{
        fun clickedItem(item: Items?)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            ItemSearchBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    }




    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Items>() {
            override fun areItemsTheSame(oldItem: Items, newItem: Items): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(oldItem: Items, newItem: Items): Boolean {
                return oldItem == newItem
            }
        }
    }


}