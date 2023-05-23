package com.perlera.parcial01.data

import com.perlera.parcial01.data.models.FoodModel

val name = "Pupusas"
val origin = "El Salvador"

val name2 = "Tacos"
val origin2 = "Mexico"

val foods = mutableListOf(
    FoodModel(name, origin),
    FoodModel(name2, origin2)
)