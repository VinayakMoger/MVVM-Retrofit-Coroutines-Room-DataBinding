package com.implantaire.architectureflow.repository.api

import com.implantaire.architectureflow.models.ProfileModel
import retrofit2.http.GET

interface ApiService {
    @GET("users/hadley/orgs")
    suspend fun getUsers(): List<ProfileModel>
}