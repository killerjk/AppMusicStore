package com.joas.appmusicstore.tela_principal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.joas.appmusicstore.databinding.ActivityTelaPrincipalBinding
import com.joas.appmusicstore.login_e_cadastro.TelaLogin

class TelaPrincipal : AppCompatActivity() {

    private lateinit var binding: ActivityTelaPrincipalBinding
    private var backPressedTime: Long = 0
    private val doubleClick: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = (supportFragmentManager.findFragmentById(binding.navTelaprincipal.id)) as NavHostFragment
        val navController = navHostFragment.navController
        binding.btNavView.setupWithNavController(navController)
        onBackPressedDispatcher.addCallback(this, onBackInvokedCallback)
    }
    private val onBackInvokedCallback = object : OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            val horaAtual = System.currentTimeMillis()
            if(horaAtual - backPressedTime < doubleClick) {
                finishAffinity()
            } else {
                Toast.makeText(this@TelaPrincipal, "Pressione novamente para sair", Toast.LENGTH_SHORT).show()
                backPressedTime = horaAtual
            }
        }
    }
}