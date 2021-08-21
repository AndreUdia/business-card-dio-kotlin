package com.cabomaldade.businescarddio.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cabomaldade.businescarddio.data.BusinessCard
import com.cabomaldade.businescarddio.databinding.ItemBusinessCardBinding

class BusinessCardAdapter :
    ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    val listenerShare: (View) -> Unit = {}

    inner class ViewHolder (
        private val binding: ItemBusinessCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind (item: BusinessCard) {
            binding.tvName.text = item.name
            binding.tvTelephone.text = item.telephone
            binding.tvMail.text = item.mail
            binding.tvBusinessName.text = item.businessName
            binding.mcvContent.setBackgroundColor(Color.parseColor(item.cardColorBackground))
            binding.mcvContent.setOnClickListener {
                listenerShare(it)
            }
        }
    }
}

// This has the same structure and could be find over the internet
class DiffCallback: DiffUtil.ItemCallback<BusinessCard>() {
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem == newItem
    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) =
        oldItem.id == newItem.id
}