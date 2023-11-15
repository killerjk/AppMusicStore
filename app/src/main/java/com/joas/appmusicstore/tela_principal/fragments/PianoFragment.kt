package com.joas.appmusicstore.tela_principal.fragments

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.joas.appmusicstore.databinding.FragmentPianoBinding
import com.joas.appmusicstore.tela_categoria_produto.PianoKawai
import com.joas.appmusicstore.tela_categoria_produto.PianoTokai

class PianoFragment: AppCompatActivity() {

    private lateinit var binding: FragmentPianoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentPianoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val toolbar = binding.toolbarPesquisarPiano
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Piano")

        binding.vejaMaisPianoTokai.setOnClickListener {
            val telaPianoTokai = Intent(this, PianoTokai::class.java)
            startActivity(telaPianoTokai)
        }

        binding.vejaMaisPianoKawai.setOnClickListener {
            val telaPianoKawai = Intent(this, PianoKawai::class.java)
            startActivity(telaPianoKawai)
        }
    }

}