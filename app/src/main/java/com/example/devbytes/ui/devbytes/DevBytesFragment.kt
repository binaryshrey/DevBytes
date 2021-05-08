package com.example.devbytes.ui.devbytes

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.devbytes.R
import com.example.devbytes.databinding.FragmentDevBytesBinding

class DevBytesFragment : Fragment() {

    private lateinit var binding: FragmentDevBytesBinding
    private lateinit var viewModel: DevBytesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dev_bytes, container, false)
        viewModel = ViewModelProvider(this).get(DevBytesViewModel::class.java)
        binding.devBytesViewModel = viewModel

        val adapter = DevBytesAdapter(ClickListener { it ->
            Toast.makeText(context, "${it.title}",Toast.LENGTH_SHORT).show()
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(it.url))
            startActivity(intent)

        })
        binding.listRV.adapter = adapter

        viewModel.property.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it.videos.toMutableList())
            }
        })


        return binding.root
    }


}