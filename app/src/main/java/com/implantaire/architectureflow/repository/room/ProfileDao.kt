package com.implantaire.architectureflow.repository.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.implantaire.architectureflow.models.ProfileModel

@Dao
interface ProfileDao {
    @Query("SELECT * FROM profile")
     fun getAllData() : LiveData<List<ProfileModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertAll(profileList: List<ProfileModel>)
    @Query("DELETE FROM profile")
    fun deleteProfileData()
}