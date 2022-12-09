package com.a02363064.groceryapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.a02363064.groceryapp.databinding.FragmentSelectListBinding

// "home" screen of app
class SelectList : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentSelectListBinding.inflate(inflater, container, false)
        // select list to browse
        binding.browseButton.setOnClickListener{
            findNavController().navigate(R.id.select_list_to_browse_catalogue)
        }
        // select list to add item
        binding.addItemButton.setOnClickListener{
            findNavController().navigate(R.id.select_list_to_add_item)
        }
        // select list to add list
        binding.newListButton.setOnClickListener{
            findNavController().navigate(R.id.select_list_to_add_list)
        }

        // choose a list


        val shoppingLists = arrayOf<String>("My list", "My Second List", "My Third List")
        val listOfLists = (shoppingLists.indices).map {
            ShoppingLists(shoppingLists[it])
        }.toList()

        binding.SelectListRecyclerView.adapter = SelectListAdapter(listOfLists)
        binding.SelectListRecyclerView.layoutManager = LinearLayoutManager(this.context)
        return binding.root
    }
}