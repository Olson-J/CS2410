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

//data class FoodItems(
//    val name: String,
//    val location: String,
//    val cost: String
//)

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

//        val itemNames = arrayOf<String>("Whole Milk, 1 gal.", "Chocolate Milk, 1 gal.",
//            "Honey Nut Cheerios, 18.8 oz", "Lucky Charms, 18.6 oz", "Frosted Flakes, 24 oz",
//            "Bananas", "Pomegranate", "Fresh Raspberries, 12 oz", "Red Seedless Grapes",
//            "Red Grapefruit", "Salted Butter, 16 oz", "Eggs, 12 ct", "Eggs, 6 ct",
//            "Heavy Cream, 16 oz", "Cream Cheese, 8 oz", "Cream Cheese, 16 oz",
//            "Chicken Bouillon, 8 oz")
//
//        val itemLocations = arrayOf<String>("A38", "A38", "A19", "A19", "A19", "A1", "A1", "A1",
//            "A1", "A1", "A38", "A28", "A28", "A38", "A38", "A38", "A13")
//
//        val itemCosts = arrayOf<String>("$3.04", "$3.04", "$4.78", "$4.78", "$4.48", "$0.27 each",
//            "$1.98 each", "$5.64", "$4.60", "$1.18 each", "$4.48", "$3.76", "$2.16", "$2.98",
//            "$1.68", "$3.18", "$4.28")
//        val foodItems = (0 until 16).map{
//            Item(0, itemNames[it], itemLocations[it], itemCosts[it], "")
//        }.toList()

        val viewModel = ItemViewModel()
        binding.browseTabRecyclerView.adapter = BrowseCatalogueAdapter(viewModel.items) {

        }
        binding.browseTabRecyclerView.layoutManager = LinearLayoutManager(this.context)

        return binding.root
    }

}