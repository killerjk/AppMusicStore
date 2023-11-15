package com.joas.appmusicstore.tela_principal.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.joas.appmusicstore.databinding.FragmentCarrinhoBinding

class CarrinhoFragment : Fragment() {

    private var _binding : FragmentCarrinhoBinding? = null
    private val binding get() =_binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentCarrinhoBinding.inflate(inflater)

        binding.btPedidos.setOnClickListener {
            val telaPedidos = Intent(context, CarrinhoPedidos::class.java)
            startActivity(telaPedidos)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

