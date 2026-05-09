package com.example.hastashilpa.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MaterialDao {
    @Query("SELECT * FROM material_records ORDER BY date DESC")
    fun getAllRecords(): LiveData<List<MaterialRecord>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(record: MaterialRecord)

    @Update
    suspend fun update(record: MaterialRecord)

    @Delete
    suspend fun delete(record: MaterialRecord)
}