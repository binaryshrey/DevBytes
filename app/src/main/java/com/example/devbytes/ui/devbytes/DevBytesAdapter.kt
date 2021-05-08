package com.example.devbytes.ui.devbytes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.devbytes.databinding.VideoListItemBinding
import com.example.devbytes.domain.Model

class DevBytesAdapter(val clickListener : ClickListener) : ListAdapter<Model, DevBytesAdapter.ViewHolder>(DiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DevBytesAdapter.ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: DevBytesAdapter.ViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model,clickListener)
    }

    class ViewHolder private constructor(val binding: VideoListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: Model,clickListener : ClickListener) {
            binding.model = model
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }


        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = VideoListItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

}

class DiffUtilCallback : DiffUtil.ItemCallback<Model>() {
    override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
        return oldItem.url == newItem.url
    }

    override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
        return oldItem == newItem
    }

}

class ClickListener(val clickListener: (model : Model) -> Unit){
    fun onClick(model : Model) = clickListener(model)
}