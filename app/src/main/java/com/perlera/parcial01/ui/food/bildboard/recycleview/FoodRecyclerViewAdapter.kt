package com.perlera.parcial01.ui.food.bildboard.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.perlera.parcial01.data.models.FoodModel
import com.perlera.parcial01.databinding.FoodItemBinding

class FoodRecyclerViewAdapter (
    private val clickListener: (FoodModel) -> Unit) : RecyclerView.Adapter<FoodRecyclerViewHolder>() {

    private val foods = ArrayList<FoodModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodRecyclerViewHolder {
        val binding = FoodItemBinding.inflate(LayoutInflater.from(parent.context), parent , false)
        return FoodRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodRecyclerViewHolder, position: Int) {
        val food = foods[position]
        holder.bind(food, clickListener)
    }

    override fun getItemCount(): Int {
        return foods.size
    }

    fun setData(foodsList: List<FoodModel>) {
        foods.clear()
        foods.addAll(foodsList)
    }


}