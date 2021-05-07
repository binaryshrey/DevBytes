package com.example.devbytes.ui.devbytes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.devbytes.R
import com.example.devbytes.databinding.FragmentDevBytesBinding

class DevBytesFragment : Fragment() {

    private lateinit var binding : FragmentDevBytesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_dev_bytes, container, false)

        return binding.root
    }


}