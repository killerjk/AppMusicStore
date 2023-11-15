package com.joas.appmusicstore.tela_principal.fragments

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.joas.appmusicstore.databinding.FragmentClarineteBinding
import com.joas.appmusicstore.tela_categoria_produto.ClarineteBb
import com.joas.appmusicstore.tela_categoria_produto.ClarineteEb

class ClarineteFragment : AppCompatActivity() {

    private lateinit var binding : FragmentClarineteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentClarineteBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val toolbar = binding.toolbarPesquisarClarinete
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Clarinete")

        binding.vejaMaisClarineteBb.setOnClickListener {
            val telaClarineteBb = Intent(this, ClarineteBb::class.java)
            startActivity(telaClarineteBb)
        }

        binding.vejaMaisClarineteEb.setOnClickListener {
            val telaClarineteEb = Intent(this, ClarineteEb::class.java)
            startActivity(telaClarineteEb)
        }
    }

}