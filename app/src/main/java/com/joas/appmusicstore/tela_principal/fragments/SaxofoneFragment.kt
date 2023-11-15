package com.joas.appmusicstore.tela_principal.fragments

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.joas.appmusicstore.databinding.FragmentSaxofoneBinding
import com.joas.appmusicstore.tela_categoria_produto.SaxofoneAlto
import com.joas.appmusicstore.tela_categoria_produto.SaxofoneTenor

class SaxofoneFragment: AppCompatActivity() {

    private lateinit var binding: FragmentSaxofoneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentSaxofoneBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val toolbar = binding.toolbarPesquisarSaxofone
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Saxofone")

        binding.vejaMaisSaxofoneAlto.setOnClickListener {
            val telaSaxofoneAlto = Intent(this, SaxofoneAlto::class.java)
            startActivity(telaSaxofoneAlto)
        }

        binding.vejaMaisSaxofoneTenor.setOnClickListener {
            val telaSaxofoneTenor = Intent(this, SaxofoneTenor::class.java)
            startActivity(telaSaxofoneTenor)
        }
    }

}