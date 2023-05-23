package com.perlera.parcial01.ui.food.bildboard.recycleview

import androidx.recyclerview.widget.RecyclerView
import com.perlera.parcial01.data.models.FoodModel
import com.perlera.parcial01.databinding.FoodItemBinding
import com.perlera.parcial01.databinding.FragmentNewFoodBinding

class FoodRecyclerViewHolder(private val binding: FoodItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(food: FoodModel, clickListener: (FoodModel) -> Unit) {
        binding.nameTextView.text = food.name
        binding.originTextView.text = food.origin

        binding.foodCard.setOnClickListener{
            clickListener(food)
        }
    }
}