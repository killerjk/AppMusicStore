package com.joas.appmusicstore.tela_principal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.joas.appmusicstore.R
import com.joas.appmusicstore.databinding.FragmentCategoriaBinding

class CategoriaFragment : Fragment() {

    private var _binding : FragmentCategoriaBinding? = null
    private val binding get() =_binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoriaBinding.inflate(inflater)

        binding.btClarinete.setOnClickListener {
            findNavController().navigate(R.id.fromCategoriaToClarineteFragment)
        }

        binding.btTrompete.setOnClickListener {
            findNavController().navigate((R.id.fromCategoriaToTrompeteFragment))
        }

        binding.btSaxofone.setOnClickListener {
            findNavController().navigate((R.id.fromCategoriaToSaxofoneFragment))
        }

        binding.btViolino.setOnClickListener {
            findNavController().navigate((R.id.fromCategoriaToViolinoFragment))
        }

        binding.btPiano.setOnClickListener {
            findNavController().navigate((R.id.fromCategoriaToPianoFragment))
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}