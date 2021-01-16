package com.implantaire.architectureflow.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.implantaire.architectureflow.databinding.AdapterProfileBinding
import com.implantaire.architectureflow.models.ProfileModel

class ProfileListAdapter (listProfile: ArrayList<ProfileModel>) : RecyclerView.Adapter<ProfileListAdapter.MyViewHolder>() {
    private val listProfileData : ArrayList<ProfileModel> = listProfile
    var onItemClick: ((ProfileModel) -> Unit)? = null


    inner class MyViewHolder(private val binding: AdapterProfileBinding) : RecyclerView.ViewHolder(binding.root) {
       fun bind(profileModel: ProfileModel) {
           with(binding) {
               profile = profileModel
           }
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterProfileBinding.inflate(inflater)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listProfileData.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) = holder.bind(listProfileData[position])

}