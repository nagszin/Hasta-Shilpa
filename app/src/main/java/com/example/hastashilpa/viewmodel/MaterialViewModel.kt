package com.example.hastashilpa.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.hastashilpa.data.AppDatabase
import com.example.hastashilpa.data.MaterialDao
import com.example.hastashilpa.data.MaterialRecord
import kotlinx.coroutines.launch

class MaterialViewModel(application: Application) : AndroidViewModel(application) {
    private val dao: MaterialDao = AppDatabase.getDatabase(application).materialDao()
    val allRecords: LiveData<List<MaterialRecord>> = dao.getAllRecords()

    fun insert(record: MaterialRecord) = viewModelScope.launch {
        dao.insert(record)
    }

    fun update(record: MaterialRecord) = viewModelScope.launch {
        dao.update(record)
    }

    fun delete(record: MaterialRecord) = viewModelScope.launch {
        dao.delete(record)
    }
}