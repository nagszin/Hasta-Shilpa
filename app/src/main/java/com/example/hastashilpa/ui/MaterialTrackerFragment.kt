package com.example.hastashilpa.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.hastashilpa.data.MaterialRecord
import com.example.hastashilpa.databinding.FragmentMaterialTrackerBinding
import com.example.hastashilpa.ui.adapters.MaterialAdapter
import com.example.hastashilpa.viewmodel.MaterialViewModel

class MaterialTrackerFragment : Fragment() {

    private var _binding: FragmentMaterialTrackerBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MaterialViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMaterialTrackerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MaterialAdapter { record ->
            viewModel.delete(record)
            Toast.makeText(context, "Record deleted", Toast.LENGTH_SHORT).show()
        }
        binding.rvMaterialRecords.adapter = adapter

        viewModel.allRecords.observe(viewLifecycleOwner) { records ->
            adapter.submitList(records)
        }

        binding.btnSave.setOnClickListener {
            saveRecord()
        }
    }

    private fun saveRecord() {
        val name = binding.etMaterial.text.toString()
        val qtyString = binding.etQuantity.text.toString()
        val laborString = binding.etLabor.text.toString()

        if (name.isBlank() || qtyString.isBlank() || laborString.isBlank()) {
            Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val qty = qtyString.toDoubleOrNull() ?: 0.0
        val labor = laborString.toDoubleOrNull() ?: 0.0

        val record = MaterialRecord(
            materialName = name,
            quantity = qty,
            laborHours = labor
        )

        viewModel.insert(record)
        
        // Clear fields
        binding.etMaterial.text?.clear()
        binding.etQuantity.text?.clear()
        binding.etLabor.text?.clear()
        
        Toast.makeText(context, "Record saved successfully", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}