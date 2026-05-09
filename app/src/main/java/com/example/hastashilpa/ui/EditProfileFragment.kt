package com.example.hastashilpa.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.hastashilpa.databinding.FragmentEditProfileBinding
import com.example.hastashilpa.viewmodel.ProfileViewModel

class EditProfileFragment : Fragment() {

    private var _binding: FragmentEditProfileBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ProfileViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Pre-fill fields with current data
        binding.etName.setText(viewModel.name.value)
        binding.etLocation.setText(viewModel.location.value)
        binding.etVillage.setText(viewModel.village.value)

        binding.btnSaveProfile.setOnClickListener {
            val name = binding.etName.text.toString()
            val location = binding.etLocation.text.toString()
            val village = binding.etVillage.text.toString()
            
            if (name.isNotEmpty()) {
                viewModel.updateProfile(name, location, village)
                Toast.makeText(context, "Profile updated successfully", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()
            } else {
                Toast.makeText(context, "Name cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}