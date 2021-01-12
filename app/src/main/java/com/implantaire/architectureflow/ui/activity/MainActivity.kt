package com.implantaire.architectureflow.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.implantaire.architectureflow.databinding.ActivityMainBinding
import com.implantaire.architectureflow.models.ProfileModel
import com.implantaire.architectureflow.repository.api.ApiClient
import com.implantaire.architectureflow.repository.api.ApiService
import com.implantaire.architectureflow.ui.adapter.ProfileListAdapter
import com.implantaire.architectureflow.utility.Status
import com.implantaire.architectureflow.viewmodel.ProfileViewModel
import com.implantaire.architectureflow.viewmodelfactory.ProfileViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    private lateinit var viewModel: ProfileViewModel
    private lateinit var adapter:ProfileListAdapter
    var profileList = ArrayList<ProfileModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewModel()
        setUpObserver()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ProfileViewModelFactory(ApiClient.apiClient().create(ApiService::class.java),this)
        ).get(ProfileViewModel::class.java)

    }

    private fun setUpObserver() {
        viewModel.getUsers().observe(this,  {
            it?.let { resource ->
                when (resource.status) {

                    Status.SUCCESS -> {
                        showProgress(false)
                        resource.data?.let { users ->retrieveList(users) }
                    }
                    Status.ERROR -> {
                        showProgress(false)
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        showProgress(true)
                    }
                }

            }
        })
    }
    private fun retrieveList(users: List<ProfileModel>) {
        if (users.isNotEmpty()) {
            profileList.addAll(users)
            val viewManager = LinearLayoutManager(this)
            adapter = ProfileListAdapter(profileList)
            adapter.onItemClick={
                Toast.makeText(this,it.login,Toast.LENGTH_SHORT).show()
            }
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = viewManager

            adapter.notifyDataSetChanged()
        }
    }
    private fun showProgress(status: Boolean) {
        if (status) {
           binding.showProgress.visibility = View.VISIBLE
        } else {
            binding.showProgress.visibility = View.GONE
        }
    }
}