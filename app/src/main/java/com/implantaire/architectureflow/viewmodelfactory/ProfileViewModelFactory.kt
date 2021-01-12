package com.implantaire.architectureflow.viewmodelfactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.implantaire.architectureflow.repository.api.ApiService
import com.implantaire.architectureflow.viewmodel.ProfileViewModel

@Suppress("UNCHECKED_CAST")
class ProfileViewModelFactory(private val apiService: ApiService, private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ProfileViewModel::class.java)){
            return ProfileViewModel(apiService,context = context)as T
        }

        throw IllegalArgumentException("Unknown class name")
    }
}