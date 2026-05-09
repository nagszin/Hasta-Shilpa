package com.example.hastashilpa.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hastashilpa.data.DesignItem
import com.example.hastashilpa.databinding.ItemDesignBinding

class DesignAdapter(
    private val items: List<DesignItem>,
    private val onBlueprintClick: (DesignItem) -> Unit
) : RecyclerView.Adapter<DesignAdapter.DesignViewHolder>() {

    class DesignViewHolder(val binding: ItemDesignBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DesignViewHolder {
        val binding = ItemDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DesignViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DesignViewHolder, position: Int) {
        val item = items[position]
        holder.binding.apply {
            designName.text = item.name
            designDescription.text = item.description
            
            Glide.with(designImage.context)
                .load(item.imageUrl)
                .placeholder(android.R.drawable.ic_menu_gallery)
                .into(designImage)

            btnViewBlueprint.setOnClickListener { onBlueprintClick(item) }
        }
    }

    override fun getItemCount() = items.size
}