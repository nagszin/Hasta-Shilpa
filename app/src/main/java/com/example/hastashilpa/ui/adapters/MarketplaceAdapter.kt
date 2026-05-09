package com.example.hastashilpa.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hastashilpa.data.ProductItem
import com.example.hastashilpa.databinding.ItemMarketplaceProductBinding
import java.util.Locale

class MarketplaceAdapter(
    private val items: List<ProductItem>,
    private val onContactClick: (ProductItem) -> Unit
) : RecyclerView.Adapter<MarketplaceAdapter.ProductViewHolder>() {

    class ProductViewHolder(val binding: ItemMarketplaceProductBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemMarketplaceProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = items[position]
        holder.binding.apply {
            productName.text = item.name
            productPrice.text = String.format(Locale.getDefault(), "₹ %.2f", item.price)
            sellerName.text = "Seller: ${item.sellerName} (${item.location})"
            
            Glide.with(productImage.context)
                .load(item.imageUrl)
                .placeholder(android.R.drawable.ic_menu_gallery)
                .into(productImage)

            btnContact.setOnClickListener { onContactClick(item) }
        }
    }

    override fun getItemCount() = items.size
}