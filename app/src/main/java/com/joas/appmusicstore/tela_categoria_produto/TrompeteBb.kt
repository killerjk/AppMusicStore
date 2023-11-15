package com.joas.appmusicstore.tela_categoria_produto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.joas.appmusicstore.databinding.ActivityTrompeteBbBinding
import com.joas.appmusicstore.tela_principal.fragments.CarrinhoProdutos

class TrompeteBb : AppCompatActivity() {

    private lateinit var binding : ActivityTrompeteBbBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrompeteBbBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbarPesquisarTrompeteBb
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(" ")

        binding.buttonAdicionarCarrinho.setOnClickListener {
            Toast.makeText(this,  "Adicionado com sucesso ao carrinho", Toast.LENGTH_SHORT).show()
            AdicionarProduto.tromBbMostrar = true
            CarrinhoProdutos.valortotal += 23300f
        }
    }
}