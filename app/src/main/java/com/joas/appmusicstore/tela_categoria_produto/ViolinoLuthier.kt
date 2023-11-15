package com.joas.appmusicstore.tela_categoria_produto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.joas.appmusicstore.databinding.ActivityViolinoLuthierBinding
import com.joas.appmusicstore.tela_principal.fragments.CarrinhoProdutos

class ViolinoLuthier : AppCompatActivity() {

    private lateinit var binding : ActivityViolinoLuthierBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViolinoLuthierBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbarPesquisarViolinoLuthier
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(" ")

        binding.buttonAdicionarCarrinho.setOnClickListener {
            Toast.makeText(this,  "Adicionado com sucesso ao carrinho", Toast.LENGTH_SHORT).show()
            AdicionarProduto.vioLutMostrar = true
            CarrinhoProdutos.valortotal += 3200f
        }
    }
}