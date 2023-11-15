package com.joas.appmusicstore.tela_categoria_produto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.joas.appmusicstore.databinding.ActivitySaxofoneTenorBinding
import com.joas.appmusicstore.tela_principal.fragments.CarrinhoProdutos

class SaxofoneTenor : AppCompatActivity() {

    private lateinit var binding : ActivitySaxofoneTenorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySaxofoneTenorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbarPesquisarSaxofoneTenor
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(" ")

        binding.buttonAdicionarCarrinho.setOnClickListener {
            Toast.makeText(this,  "Adicionado com sucesso ao carrinho", Toast.LENGTH_SHORT).show()
            AdicionarProduto.saxTenorMostrar = true
            CarrinhoProdutos.valortotal += 8200f
        }
    }
}