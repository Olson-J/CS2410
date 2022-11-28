package com.a02363064.usucsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.a02363064.usucsapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.goToFaculty.setOnClickListener{
            findNavController().navigate(R.id.home_to_faculty)
        }
        binding.goToResearch.setOnClickListener{
            findNavController().navigate(R.id.home_to_research)
        }
        return binding.root
    }
}