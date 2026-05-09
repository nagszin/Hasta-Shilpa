package com.example.hastashilpa.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.hastashilpa.R
import com.example.hastashilpa.databinding.FragmentTrendingDesignsBinding
import com.example.hastashilpa.ui.adapters.DesignAdapter
import com.example.hastashilpa.viewmodel.TrendingDesignsViewModel

class TrendingDesignsFragment : Fragment() {

    private var _binding: FragmentTrendingDesignsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TrendingDesignsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTrendingDesignsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.designs.observe(viewLifecycleOwner) { designs ->
            val adapter = DesignAdapter(designs) { design ->
                findNavController().navigate(R.id.action_designs_to_blueprint)
            }
            binding.rvTrendingDesigns.adapter = adapter
        }

        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            // You could show a ProgressBar here
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}