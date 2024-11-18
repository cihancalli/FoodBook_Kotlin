package com.zerdasoftware.foodbook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zerdasoftware.foodbook.databinding.FragmentRecipeBinding


class RecipeFragment : Fragment() {

    private var _binding: FragmentRecipeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentRecipeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveButton.setOnClickListener { save(it) }
        binding.deleteButton.setOnClickListener { delete(it) }
        binding.imageView.setOnClickListener { selectImage(it) }

        arguments?.let {
            val id = RecipeFragmentArgs.fromBundle(it).id
            val info = RecipeFragmentArgs.fromBundle(it).info

            if (info == "new"){
                binding.deleteButton.visibility = View.GONE
                binding.saveButton.visibility = View.VISIBLE

                binding.foodNameEditText.setText("")
                binding.foodIngredientsEditText.setText("")
            } else {
                binding.deleteButton.visibility = View.VISIBLE
                binding.saveButton.visibility = View.GONE
            }
        }
    }

    fun save (view: View) {

    }

    fun delete (view: View) {

    }



    fun selectImage (view: View) {

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}