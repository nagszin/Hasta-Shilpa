package com.example.hastashilpa.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hastashilpa.data.DesignItem
import com.example.hastashilpa.data.DesignRepository
import kotlinx.coroutines.launch

class TrendingDesignsViewModel : ViewModel() {
    private val repository = DesignRepository()
    private val _designs = MutableLiveData<List<DesignItem>>()
    val designs: LiveData<List<DesignItem>> = _designs

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        fetchDesigns()
    }

    fun fetchDesigns() {
        viewModelScope.launch {
            _isLoading.value = true
            _designs.value = repository.getTrendingDesigns()
            _isLoading.value = false
        }
    }
}