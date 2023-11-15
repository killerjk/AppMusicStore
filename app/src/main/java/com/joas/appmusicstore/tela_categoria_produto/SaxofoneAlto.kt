package com.joas.appmusicstore.tela_categoria_produto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.joas.appmusicstore.databinding.ActivitySaxofoneAltoBinding
import com.joas.appmusicstore.tela_principal.fragments.CarrinhoProdutos

class SaxofoneAlto : AppCompatActivity() {

    private lateinit var binding : ActivitySaxofoneAltoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySaxofoneAltoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbarPesquisarSaxofoneAlto
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(" ")

        binding.buttonAdicionarCarrinho.setOnClickListener {
            Toast.makeText(this,  "Adicionado com sucesso ao carrinho", Toast.LENGTH_SHORT).show()
            AdicionarProduto.saxAltoMostrar = true
            CarrinhoProdutos.valortotal += 6050f
        }
    }
}