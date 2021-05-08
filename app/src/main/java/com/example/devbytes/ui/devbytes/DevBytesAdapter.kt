package com.example.devbytes.ui.devbytes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.devbytes.databinding.VideoListItemBinding
import com.example.devbytes.network.DevBytesProperty

class DevBytesAdapter : ListAdapter<DevBytesProperty, DevBytesAdapter.ViewHolder>(DiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DevBytesAdapter.ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: DevBytesAdapter.ViewHolder, position: Int) {
        val devBytesProperty = getItem(position)
        holder.bind(devBytesProperty)
    }

    class ViewHolder private constructor(val binding : VideoListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(devBytesProperty : DevBytesProperty){
            binding.property = devBytesProperty
            binding.executePendingBindings()
        }

        companion object{
            fun from(parent: ViewGroup) : ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = VideoListItemBinding.inflate(layoutInflater,parent,false)
                return ViewHolder(binding)
            }
        }
    }

}
class DiffUtilCallback : DiffUtil.ItemCallback<DevBytesProperty>(){
    override fun areItemsTheSame(oldItem: DevBytesProperty, newItem: DevBytesProperty): Boolean {
        return oldItem.videos == newItem.videos
    }

    override fun areContentsTheSame(oldItem: DevBytesProperty, newItem: DevBytesProperty): Boolean {
        return oldItem == newItem
    }

}