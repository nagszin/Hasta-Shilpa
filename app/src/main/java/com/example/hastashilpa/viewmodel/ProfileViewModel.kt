package com.example.hastashilpa.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.hastashilpa.network.ArtisanStats
import com.example.hastashilpa.network.RetrofitClient
import kotlinx.coroutines.launch

class ProfileViewModel(application: Application) : AndroidViewModel(application) {
    private val sharedPrefs = application.getSharedPreferences("user_profile", Context.MODE_PRIVATE)

    private val _name = MutableLiveData<String>(sharedPrefs.getString("name", "Nagszain"))
    val name: LiveData<String> = _name

    private val _location = MutableLiveData<String>(sharedPrefs.getString("location", "Sirsi, Western Ghats"))
    val location: LiveData<String> = _location
    
    private val _village = MutableLiveData<String>(sharedPrefs.getString("village", "Western Ghats"))
    val village: LiveData<String> = _village

    private val _stats = MutableLiveData<ArtisanStats>()
    val stats: LiveData<ArtisanStats> = _stats

    init {
        fetchStats()
    }

    fun fetchStats() {
        viewModelScope.launch {
            try {
                _stats.value = RetrofitClient.apiService.getArtisanStats()
            } catch (e: Exception) {
                // Fallback dummy stats if backend is down
                _stats.value = ArtisanStats(12, 15400.0, 4.5)
            }
        }
    }

    fun updateProfile(newName: String, newLocation: String, newVillage: String) {
        _name.value = newName
        _location.value = newLocation
        _village.value = newVillage
        
        sharedPrefs.edit().apply {
            putString("name", newName)
            putString("location", newLocation)
            putString("village", newVillage)
            apply()
        }
    }
}