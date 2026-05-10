package com.example.hastashilpa.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.hastashilpa.data.DesignItem
import com.example.hastashilpa.databinding.FragmentBlueprintLibraryBinding

class BlueprintLibraryFragment : Fragment() {

    private var _binding: FragmentBlueprintLibraryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlueprintLibraryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Read the DesignItem passed from TrendingDesignsFragment
        val design = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getSerializable("designItem", DesignItem::class.java)
        } else {
            @Suppress("DEPRECATION")
            arguments?.getSerializable("designItem") as? DesignItem
        }
        
        design?.let {
            binding.tvBlueprintTitle.text = it.name
            binding.tvMeasurements.text = it.measurements
            binding.tvMaterials.text = it.materials
            binding.tvDifficulty.text = it.difficulty
            binding.tvEstTime.text = it.estimatedTime
            
            Glide.with(this)
                .load(it.imageUrl)
                .placeholder(android.R.drawable.ic_menu_gallery)
                .into(binding.blueprintImage)
        }

        binding.btnDownloadBlueprint.setOnClickListener {
            Toast.makeText(context, "Downloading blueprint for ${design?.name}...", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}