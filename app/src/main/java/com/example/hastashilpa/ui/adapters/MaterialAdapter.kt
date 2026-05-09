package com.example.hastashilpa.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hastashilpa.data.MaterialRecord
import com.example.hastashilpa.databinding.ItemMaterialRecordBinding

class MaterialAdapter(
    private val onDeleteClick: (MaterialRecord) -> Unit
) : ListAdapter<MaterialRecord, MaterialAdapter.MaterialViewHolder>(DiffCallback) {

    class MaterialViewHolder(val binding: ItemMaterialRecordBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MaterialViewHolder {
        val binding = ItemMaterialRecordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MaterialViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MaterialViewHolder, position: Int) {
        val record = getItem(position)
        holder.binding.apply {
            tvMaterialName.text = record.materialName
            tvQuantity.text = "Quantity: ${record.quantity}"
            tvLabor.text = "Labor: ${record.laborHours}h"
            btnDelete.setOnClickListener { onDeleteClick(record) }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MaterialRecord>() {
        override fun areItemsTheSame(oldItem: MaterialRecord, newItem: MaterialRecord): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MaterialRecord, newItem: MaterialRecord): Boolean {
            return oldItem == newItem
        }
    }
}