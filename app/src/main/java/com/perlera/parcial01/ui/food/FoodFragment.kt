package com.perlera.parcial01.ui.food

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.perlera.parcial01.R
import com.perlera.parcial01.databinding.FoodItemBinding
import com.perlera.parcial01.databinding.FragmentFoodBinding
import com.perlera.parcial01.ui.food.viewmodell.FoodViewModel

class FoodFragment : Fragment() {

    private lateinit var binding: FragmentFoodBinding

    private val viewmodel : FoodViewModel by activityViewModels {
        FoodViewModel.Factory
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
    }

    private fun setViewModel(){
        binding.viewmodel = viewmodel
    }

}