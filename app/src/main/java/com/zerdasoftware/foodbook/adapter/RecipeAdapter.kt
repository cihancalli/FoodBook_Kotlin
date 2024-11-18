package com.zerdasoftware.foodbook.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.zerdasoftware.foodbook.databinding.RecyclerRowBinding
import com.zerdasoftware.foodbook.model.RecipeModel
import com.zerdasoftware.foodbook.view.ListFragmentDirections

class RecipeAdapter(val recipeList: List<RecipeModel>):RecyclerView.Adapter<RecipeAdapter.RecipeHolder>() {

    class RecipeHolder(val binding: RecyclerRowBinding) :RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder {
        val recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RecipeHolder(recyclerRowBinding)
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        holder.binding.recyclerViewTextView.text = recipeList[position].name
        holder.itemView.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToRecipeFragment(info = "old", id = recipeList[position].id)
            Navigation.findNavController(it).navigate(action)
        }

    }
}