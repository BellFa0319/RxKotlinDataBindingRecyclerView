package com.example.tabling

import androidx.recyclerview.widget.RecyclerView
import com.example.tabling.databinding.ItemListBinding
import com.example.tabling.model.ListItem
import com.example.tabling.widget.RecyclerViewItemClickListener

class ListItemViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ListItem, listener: RecyclerViewItemClickListener) {
        binding.listitem = item
        binding.listItemClick = listener
    }

}