package com.zerdasoftware.foodbook.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.zerdasoftware.foodbook.adapter.RecipeAdapter
import com.zerdasoftware.foodbook.databinding.FragmentListBinding
import com.zerdasoftware.foodbook.model.RecipeModel
import com.zerdasoftware.foodbook.roomdb.RecipeDAO
import com.zerdasoftware.foodbook.roomdb.RecipeDatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var db : RecipeDatabase
    private lateinit var recipeDAO: RecipeDAO
    private  val mDisposable = CompositeDisposable()

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
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        getData()

    }

    private fun getData() {
        mDisposable.add(
            recipeDAO.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse)
        )
    }

    private fun handleResponse(recipes:List<RecipeModel>) {
        val adapter = RecipeAdapter(recipes)
        binding.recyclerView.adapter = adapter
    }

    fun newAdd(view: View){
        val action = ListFragmentDirections.actionListFragmentToRecipeFragment(info = "new", id = -1)
        Navigation.findNavController(view).navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        mDisposable.clear()
    }


}