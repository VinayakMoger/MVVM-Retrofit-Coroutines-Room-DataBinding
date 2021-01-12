package com.implantaire.architectureflow.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.implantaire.architectureflow.repository.api.ApiService
import com.implantaire.architectureflow.repository.room.AppDatabase
import com.implantaire.architectureflow.repository.room.ProfileDao
import com.implantaire.architectureflow.utility.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class ProfileViewModel(private val apiService: ApiService,context: Context):ViewModel() {
    private val databaseController : AppDatabase = AppDatabase.getDatabase(context)
    private val profileDao: ProfileDao = databaseController.profileDao()
    fun getUsers() = liveData(Dispatchers.IO){
        emit(Resource.loading(data = null))
        try {
            profileDao.deleteProfileData()
            profileDao.insertAll(apiService.getUsers())
            emit(Resource.success(data=apiService.getUsers()))
        }catch (exception: Exception){
            emit(Resource.error(data=null,message = exception.message?:"Error occurred"))
        }
    }

}

