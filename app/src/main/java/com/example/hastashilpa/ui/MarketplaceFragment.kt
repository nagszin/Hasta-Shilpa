package com.example.hastashilpa.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.hastashilpa.databinding.FragmentMarketplaceBinding
import com.example.hastashilpa.ui.adapters.MarketplaceAdapter
import com.example.hastashilpa.viewmodel.MarketplaceViewModel

class MarketplaceFragment : Fragment() {

    private var _binding: FragmentMarketplaceBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MarketplaceViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMarketplaceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.products.observe(viewLifecycleOwner) { products ->
            val adapter = MarketplaceAdapter(products) { product ->
                Toast.makeText(context, "Contacting ${product.sellerName}...", Toast.LENGTH_SHORT).show()
            }
            binding.rvMarketplace.adapter = adapter
        }

        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            // UI feedback for loading state
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}