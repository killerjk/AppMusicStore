package com.joas.appmusicstore.tela_categoria_produto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.joas.appmusicstore.databinding.ActivityClarineteEbBinding
import com.joas.appmusicstore.tela_principal.fragments.CarrinhoProdutos

class ClarineteEb : AppCompatActivity() {

    private lateinit var binding : ActivityClarineteEbBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClarineteEbBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbarPesquisarClarineteEb
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(" ")

        binding.buttonAdicionarCarrinho.setOnClickListener {
            Toast.makeText(this,  "Adicionado com sucesso ao carrinho", Toast.LENGTH_SHORT).show()
            AdicionarProduto.claEbMostrar = true
            CarrinhoProdutos.valortotal += 20035f
        }
    }
}