package com.joas.appmusicstore.tela_categoria_produto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.joas.appmusicstore.databinding.ActivityTrompeteCBinding
import com.joas.appmusicstore.tela_principal.fragments.CarrinhoProdutos

class TrompeteC : AppCompatActivity() {

    private lateinit var binding : ActivityTrompeteCBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrompeteCBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbarPesquisarTrompeteC
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(" ")

        binding.buttonAdicionarCarrinho.setOnClickListener {
            Toast.makeText(this,  "Adicionado com sucesso ao carrinho", Toast.LENGTH_SHORT).show()
            AdicionarProduto.tromCMostrar = true
            CarrinhoProdutos.valortotal += 42683f
        }
    }
}