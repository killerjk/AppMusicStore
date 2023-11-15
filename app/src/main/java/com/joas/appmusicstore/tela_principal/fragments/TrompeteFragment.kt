package com.joas.appmusicstore.tela_principal.fragments

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.joas.appmusicstore.databinding.FragmentTrompeteBinding
import com.joas.appmusicstore.tela_categoria_produto.TrompeteBb
import com.joas.appmusicstore.tela_categoria_produto.TrompeteC

class TrompeteFragment: AppCompatActivity() {

    private lateinit var binding: FragmentTrompeteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentTrompeteBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val toolbar = binding.toolbarPesquisarTrompete
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Trompete")

        binding.vejaMaisTrompeteBb.setOnClickListener {
            val telaTrompeteBb = Intent(this, TrompeteBb::class.java)
            startActivity(telaTrompeteBb)
        }

        binding.vejaMaisTrompeteC.setOnClickListener {
            val telaTrompeteC = Intent(this, TrompeteC::class.java)
            startActivity(telaTrompeteC)
        }
    }

}