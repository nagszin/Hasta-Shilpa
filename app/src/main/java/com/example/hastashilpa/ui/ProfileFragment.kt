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

        viewModel.name.observe(viewLifecycleOwner) { name ->
            binding.tvArtisanName.text = name
        }

        viewModel.location.observe(viewLifecycleOwner) { location ->
            binding.tvLocation.text = location
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