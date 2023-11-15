package com.joas.appmusicstore.tela_principal.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.database.FirebaseDatabase
import com.joas.appmusicstore.R
import com.joas.appmusicstore.databinding.FragmentLojaBinding
import com.joas.appmusicstore.tela_categoria_produto.ClarineteBb
import com.joas.appmusicstore.tela_categoria_produto.ClarineteEb
import com.joas.appmusicstore.tela_categoria_produto.PianoKawai
import com.joas.appmusicstore.tela_categoria_produto.PianoTokai
import com.joas.appmusicstore.tela_categoria_produto.SaxofoneAlto
import com.joas.appmusicstore.tela_categoria_produto.SaxofoneTenor
import com.joas.appmusicstore.tela_categoria_produto.TrompeteBb
import com.joas.appmusicstore.tela_categoria_produto.TrompeteC
import com.joas.appmusicstore.tela_categoria_produto.ViolinoLuthier
import com.joas.appmusicstore.tela_categoria_produto.ViolinoRolim

class LojaFragment : Fragment() {

    private var _binding: FragmentLojaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLojaBinding.inflate(inflater)

        binding.ClaBb.setOnClickListener {
            val intent = Intent(context, ClarineteBb::class.java)
            startActivity(intent)
        }

        binding.ClaEb.setOnClickListener {
            val intent = Intent(context, ClarineteEb::class.java)
            startActivity(intent)
        }

        binding.TromBb.setOnClickListener {
            val intent = Intent(context, TrompeteBb::class.java)
            startActivity(intent)
        }

        binding.TromC.setOnClickListener {
            val intent = Intent(context, TrompeteC::class.java)
            startActivity(intent)
        }

        binding.SaxAlto.setOnClickListener {
            val intent = Intent(context, SaxofoneAlto::class.java)
            startActivity(intent)
        }

        binding.SaxTenor.setOnClickListener {
            val intent = Intent(context, SaxofoneTenor::class.java)
            startActivity(intent)
        }

        binding.VioLut.setOnClickListener {
            val intent = Intent(context, ViolinoLuthier::class.java)
            startActivity(intent)
        }

        binding.VioRol.setOnClickListener {
            val intent = Intent(context, ViolinoRolim::class.java)
            startActivity(intent)
        }

        binding.PiaKaw.setOnClickListener {
            val intent = Intent(context, PianoKawai::class.java)
            startActivity(intent)
        }

        binding.PiaTok.setOnClickListener {
            val intent = Intent(context, PianoTokai::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}