package com.joas.appmusicstore.tela_principal.fragments

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.joas.appmusicstore.databinding.FragmentViolinoBinding
import com.joas.appmusicstore.tela_categoria_produto.ViolinoLuthier
import com.joas.appmusicstore.tela_categoria_produto.ViolinoRolim

class ViolinoFragment: AppCompatActivity() {

    private lateinit var binding: FragmentViolinoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentViolinoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val toolbar = binding.toolbarPesquisarViolino
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Violino")

        binding.vejaMaisViolinoRolim.setOnClickListener {
            val telaViolinoRolim = Intent(this, ViolinoRolim::class.java)
            startActivity(telaViolinoRolim)
        }

        binding.vejaMaisViolinoLuthier.setOnClickListener {
            val telaViolinoLuthier = Intent(this, ViolinoLuthier::class.java)
            startActivity(telaViolinoLuthier)
        }
    }

}