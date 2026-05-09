package com.example.hastashilpa.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hastashilpa.R
import com.example.hastashilpa.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardTrending.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_trending)
        }

        binding.cardBlueprints.setOnClickListener {
            findNavController().navigate(R.id.action_designs_to_blueprint)
        }

        binding.cardTracker.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_tracker)
        }

        binding.cardAiPrice.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_price_suggestion)
        }

        binding.cardMarketplace.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_marketplace)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}