package com.a02363064.groceryapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.a02363064.groceryapp.databinding.FragmentAddItemBinding


class AddItem : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAddItemBinding.inflate(inflater, container, false)

        val viewModel = ItemCreationViewModel()

        // button from add item to browse
        binding.browseButtonOnAddListTab.setOnClickListener{
            findNavController().navigate(R.id.add_item_to_browse_catalogue)
        }

        //button from add item to select list
        binding.viewListsButtonOnAddListTab.setOnClickListener{
            findNavController().navigate(R.id.add_item_to_select_list)
        }

        // button to add item to inventory
        binding.AddItemButton.setOnClickListener{
            viewModel.createItem(binding.addItemNameTextBox.text.toString(),
                binding.addItemAisleTextBox.text.toString(), binding.addItemPriceTextBox.text.toString())
        }

        return binding.root
    }
}