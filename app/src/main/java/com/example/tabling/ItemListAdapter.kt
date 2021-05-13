package com.example.tabling

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.tabling.databinding.ItemListBinding
import com.example.tabling.model.ListItem
import com.example.tabling.widget.RecyclerViewItemClickListener

class ItemListAdapter( private val mListener: RecyclerViewItemClickListener) : ListAdapter<ListItem, ListItemViewHolder>(ItemDiffUtil) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item,mListener )
    }

    companion object ItemDiffUtil : DiffUtil.ItemCallback<ListItem>() {
        override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
            return oldItem.id == newItem.id
        }
    }
}