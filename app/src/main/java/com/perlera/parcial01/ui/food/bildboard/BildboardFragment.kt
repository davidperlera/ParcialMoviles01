package com.perlera.parcial01.ui.food.bildboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.perlera.parcial01.R
import com.perlera.parcial01.data.models.FoodModel
import com.perlera.parcial01.databinding.FragmentBildboardBinding
import com.perlera.parcial01.ui.food.bildboard.recycleview.FoodRecyclerViewAdapter
import com.perlera.parcial01.ui.food.bildboard.recycleview.FoodRecyclerViewHolder
import com.perlera.parcial01.ui.food.viewmodell.FoodViewModel

class BildboardFragment : Fragment() {

    private lateinit var binding: FragmentBildboardBinding
    private lateinit var adapter : FoodRecyclerViewAdapter

    private val viewmodel: FoodViewModel by activityViewModels {
        FoodViewModel.Factory
    }

    private fun showSelectedFood(food: FoodModel){
        viewmodel.setSelectedFood(food)
        findNavController().navigate(R.id.action_bildboardFragment_to_foodFragment)
    }

    private fun displayFoods(){
        adapter.setData(viewmodel.getFoods())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View){
        binding.foodRecyclerview.layoutManager = LinearLayoutManager(view.context)

        adapter = FoodRecyclerViewAdapter { selectedFood ->
            showSelectedFood(selectedFood)
        }

        binding.foodRecyclerview.adapter = adapter
        displayFoods()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentBildboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)


        binding.actionToCreateFood.setOnClickListener{
            viewmodel.clearData()
            findNavController().navigate(R.id.action_bildboardFragment_to_newFoodFragment)
        }
    }

}