package com.zerdasoftware.foodbook

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
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
        if (ContextCompat.checkSelfPermission(requireContext(),Manifest.permission.READ_EXTERNAL_STORAGE )!= PackageManager.PERMISSION_GRANTED) {
            //izin verilmemiş, izin istememiz gerekiyor.
            if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(),Manifest.permission.READ_EXTERNAL_STORAGE)) {
                //snackbar göstermemiz lazım, kullanıcıdan neden izin istediğimizi bir kez daha söyleyerek izin istememmiz lazım
                Snackbar.make(view,"Galeriye ulaşıp görsel seçmemiz lazım!",Snackbar.LENGTH_INDEFINITE).setAction(
                    "İzin Ver",
                    View.OnClickListener {
                        //izin isteyeceğiz
                    }
                ).show()
            } else {
                //izin isteyeceğiz
            }
        }else {
            //izin verilmiş, galeriye gidebilirim
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}