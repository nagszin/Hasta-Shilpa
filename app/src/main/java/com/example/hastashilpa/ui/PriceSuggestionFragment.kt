package com.example.hastashilpa.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.hastashilpa.databinding.FragmentPriceSuggestionBinding
import java.util.Locale

class PriceSuggestionFragment : Fragment() {

    private var _binding: FragmentPriceSuggestionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPriceSuggestionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalculate.setOnClickListener {
            calculatePrice()
        }
    }

    private fun calculatePrice() {
        val materialCost = binding.etMaterialCost.text.toString().toDoubleOrNull() ?: 0.0
        val hours = binding.etHours.text.toString().toDoubleOrNull() ?: 0.0
        val rate = binding.etLaborRate.text.toString().toDoubleOrNull() ?: 0.0
        val profitPercent = binding.etProfitPercent.text.toString().toDoubleOrNull() ?: 0.0

        if (materialCost <= 0 || hours <= 0 || rate <= 0) {
            Toast.makeText(context, "Please enter valid values", Toast.LENGTH_SHORT).show()
            return
        }

        val laborCost = hours * rate
        val baseCost = materialCost + laborCost
        val profitAmount = baseCost * (profitPercent / 100.0)
        val totalPrice = baseCost + profitAmount

        binding.tvSuggestedPrice.text = String.format(Locale.getDefault(), "₹ %.2f", totalPrice)
        binding.tvEstimatedProfit.text = String.format(Locale.getDefault(), "Estimated Profit: ₹ %.2f", profitAmount)
        binding.cardResult.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}