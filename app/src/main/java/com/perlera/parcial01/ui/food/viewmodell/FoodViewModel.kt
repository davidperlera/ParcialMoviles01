package com.perlera.parcial01.ui.food.viewmodell

import  androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.perlera.parcial01.FoodReviewerApplication
import com.perlera.parcial01.data.models.FoodModel
import com.perlera.parcial01.repository.FoodRepository

class FoodViewModel(private val repository: FoodRepository): ViewModel() {
    var name: MutableLiveData<String> = MutableLiveData("")
    var origin = MutableLiveData("")
    var status = MutableLiveData("")

    fun getFoods() = repository.getFoods()
    fun addFood(food: FoodModel) = repository.addFood(food)

    private fun validateData(): Boolean{
        when {
            name.value.isNullOrEmpty() -> return false
            origin.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun createFood() {

        if(!validateData()){
            status.value = WRONG_DATA
            return
        }
        val newfood = FoodModel(
            name.value.toString(),
            origin.value.toString(),
        )

        addFood(newfood)
        status.value = FOOD_CREATED
    }

    fun clearData() {
        name.value = ""
        origin.value = ""
    }

    fun clearStatus() {
        status.value = BASE_STATE
    }

    fun setSelectedFood (food: FoodModel){
        name.value = food.name
        origin.value = food.origin
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as FoodReviewerApplication
                FoodViewModel(app.foodRepository)
            }
        }
        const val FOOD_CREATED = "Food created"
        const val WRONG_DATA = "Wrong Data"
        const val BASE_STATE = ""
    }
}