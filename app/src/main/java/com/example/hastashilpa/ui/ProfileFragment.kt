package com.example.hastashilpa.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.hastashilpa.R
import com.example.hastashilpa.databinding.FragmentProfileBinding
import com.example.hastashilpa.viewmodel.ProfileViewModel
import java.util.Locale

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ProfileViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observe profile details from ViewModel (Persistent via SharedPreferences)
        viewModel.name.observe(viewLifecycleOwner) { name ->
            binding.tvArtisanName.text = name
        }

        viewModel.location.observe(viewLifecycleOwner) { location ->
            binding.tvLocation.text = location
        }

        // Observe live stats from Backend (with local fallback)
        viewModel.stats.observe(viewLifecycleOwner) { stats ->
            binding.tvProductsCount.text = stats.productsCreated.toString()
            binding.tvTotalEarnings.text = String.format(Locale.getDefault(), "₹ %,.0f", stats.totalEarnings)
        }

        binding.btnEditProfile.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_profile_to_editProfileFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}