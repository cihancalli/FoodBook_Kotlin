package com.zerdasoftware.foodbook.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.room.Room
import com.zerdasoftware.foodbook.databinding.FragmentListBinding
import com.zerdasoftware.foodbook.roomdb.RecipeDAO
import com.zerdasoftware.foodbook.roomdb.RecipeDatabase

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var db : RecipeDatabase
    private lateinit var recipeDAO: RecipeDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = Room.databaseBuilder(requireContext(),RecipeDatabase::class.java,"Recipes").build()
        recipeDAO = db.recipeDAO()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatingActionButton.setOnClickListener { newAdd(it) }
    }

    fun newAdd(view: View){
        val action = ListFragmentDirections.actionListFragmentToRecipeFragment(info = "new", id = 0)
        Navigation.findNavController(view).navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}