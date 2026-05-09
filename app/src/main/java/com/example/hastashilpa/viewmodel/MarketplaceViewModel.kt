package com.example.hastashilpa.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hastashilpa.data.ProductItem
import com.example.hastashilpa.data.MarketplaceRepository
import kotlinx.coroutines.launch

class MarketplaceViewModel : ViewModel() {
    private val repository = MarketplaceRepository()
    private val _products = MutableLiveData<List<ProductItem>>()
    val products: LiveData<List<ProductItem>> = _products

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        fetchProducts()
    }

    fun fetchProducts() {
        viewModelScope.launch {
            _isLoading.value = true
            _products.value = repository.getMarketplaceProducts()
            _isLoading.value = false
        }
    }
}