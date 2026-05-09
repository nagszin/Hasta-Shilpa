package com.example.hastashilpa.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ProfileViewModel(application: Application) : AndroidViewModel(application) {
    private val sharedPrefs = application.getSharedPreferences("user_profile", Context.MODE_PRIVATE)

    private val _name = MutableLiveData<String>(sharedPrefs.getString("name", "Nagszain"))
    val name: LiveData<String> = _name

    private val _location = MutableLiveData<String>(sharedPrefs.getString("location", "Sirsi, Western Ghats"))
    val location: LiveData<String> = _location
    
    private val _village = MutableLiveData<String>(sharedPrefs.getString("village", "Western Ghats"))
    val village: LiveData<String> = _village

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