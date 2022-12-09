package com.a02363064.groceryapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.a02363064.groceryapp.databinding.FragmentAddListBinding

class AddList : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAddListBinding.inflate(inflater, container, false)

        // browse button
        binding.browseButtonAddList.setOnClickListener{
            findNavController().navigate(R.id.add_list_to_browse_catalogue)
        }

        // add item button
        binding.addItemButtonAddList.setOnClickListener{
            findNavController().navigate(R.id.add_list_to_add_item)
        }

        // select list button
        binding.viewListsButtonAddList.setOnClickListener{
            findNavController().navigate(R.id.add_list_to_select_list)
        }

        // create list button
        binding.makeListButton.setOnClickListener{

        }

        return binding.root
    }
}