package com.perlera.parcial01.ui.food.newfood

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.perlera.parcial01.R
import com.perlera.parcial01.databinding.FragmentNewFoodBinding
import com.perlera.parcial01.ui.food.viewmodell.FoodViewModel


class NewFoodFragment : Fragment() {

    private lateinit var binding: FragmentNewFoodBinding

    private val viewmodel: FoodViewModel by activityViewModels {
        FoodViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewFoodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        setObserver()
    }

    private fun setViewModel(){
        binding.viewmodel = viewmodel
    }

    private fun setObserver() {
        viewmodel.status.observe(viewLifecycleOwner){status ->
            when {
                status.equals(FoodViewModel.FOOD_CREATED) -> {
                    Log.d("TAG APP", status)
                    Log.d("TAG APP", viewmodel.getFoods().toString())

                    viewmodel.clearStatus()
                    viewmodel.clearData()

                    findNavController().popBackStack()
                }
                status.equals(FoodViewModel.WRONG_DATA) -> {
                    Log.d("APP TAP", status)
                    viewmodel.clearStatus()
                }
            }
        }
    }


}