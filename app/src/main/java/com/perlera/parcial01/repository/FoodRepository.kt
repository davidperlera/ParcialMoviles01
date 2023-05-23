package com.perlera.parcial01.repository

import com.perlera.parcial01.data.models.FoodModel

class FoodRepository(private val foods: MutableList<FoodModel>) {
    fun getFoods() = foods
    fun addFood(newFood: FoodModel) = foods.add(newFood)
}