package com.example.lifelonglearningapp


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lifelonglearningapp.databinding.ItemSearchBinding
import java.util.stream.DoubleStream.concat

class SearchPageAdapter : ListAdapter<Items, SearchPageAdapter.SearchViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class SearchViewHolder(private val binding: ItemSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Items) {
            with(binding) {
                searchTitle.text = item.instrctrNm
                var searchDate1 = item.edcStartDay
                var searchDate2 = " ~ "
                var searchDate3 = item.edcEndDay
                var searchDateTotal = searchDate1 + searchDate2 + searchDate3
                searchDate.text = searchDateTotal
                searchDay.text = item.operDay


            }

        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Items>() {
            override fun areItemsTheSame(oldItem: Items, newItem: Items): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(oldItem: Items, newItem: Items): Boolean {
                return oldItem == newItem
            }
        }
    }

}