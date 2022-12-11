package com.a02363064.groceryapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.a02363064.groceryapp.databinding.FragmentBrowseCatalogueBinding
import com.a02363064.groceryapp.models.Item

class BrowseCatalogue : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBrowseCatalogueBinding.inflate(inflater, container, false)

        // select list button
        binding.viewListsButtonBrowse.setOnClickListener{
            findNavController().navigate(R.id.browse_catalogue_to_select_list)
        }
        // add item button
        binding.addItemButtonBrowse.setOnClickListener{
            findNavController().navigate(R.id.browse_catalogue_to_add_item)
        }

        val viewModel = ItemViewModel()
        binding.browseTabRecyclerView.adapter = BrowseCatalogueAdapter(viewModel.items) {
            viewModel.toggleItemClicked(it)
        }
        binding.browseTabRecyclerView.layoutManager = LinearLayoutManager(this.context)

        return binding.root
    }

}