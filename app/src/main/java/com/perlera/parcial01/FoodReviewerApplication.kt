package com.perlera.parcial01

import android.app.Application
import com.perlera.parcial01.data.foods
import com.perlera.parcial01.repository.FoodRepository

class FoodReviewerApplication : Application() {
    val foodRepository: FoodRepository by lazy {
        FoodRepository(foods)
    }
}