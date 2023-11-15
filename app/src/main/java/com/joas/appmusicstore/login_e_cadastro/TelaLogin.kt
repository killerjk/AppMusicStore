package com.joas.appmusicstore.login_e_cadastro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.joas.appmusicstore.databinding.ActivityTelaLoginBinding
import com.joas.appmusicstore.tela_principal.TelaPrincipal

class TelaLogin : AppCompatActivity() {

    private lateinit var binding: ActivityTelaLoginBinding
    private val auth = FirebaseAuth.getInstance()
    private var backPressedTime: Long = 0
    private val doubleClick: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Criando ação de click no botão
        binding.btEntrar.setOnClickListener {
            binding.progressBar.setVisibility(View.VISIBLE)
            val useremail = binding.editEmail.text.toString()
            val usersenha = binding.editSenha.text.toString()

            if(useremail.isEmpty() || usersenha.isEmpty()){
                Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show()
                binding.progressBar.setVisibility(View.INVISIBLE)
            }else{
                auth.signInWithEmailAndPassword(useremail, usersenha).addOnCompleteListener {validacao ->
                    if(validacao.isSuccessful){
                        IrTelaPrincipal()
                        Toast.makeText(this, "Login efetuado com sucesso.", Toast.LENGTH_SHORT).show()
                        binding.progressBar.setVisibility(View.INVISIBLE)
                    }

                }.addOnFailureListener {
                    Toast.makeText(this, "Email ou senha inválido.", Toast.LENGTH_SHORT).show()
                    binding.progressBar.setVisibility(View.INVISIBLE)
                }
            }
        }

        binding.btCriarconta.setOnClickListener{
            IrTelaCadastro()
        }

        onBackPressedDispatcher.addCallback(this, onBackInvokedCallback)
    }
    // Ir para tela principal
    private fun IrTelaPrincipal(){
        val telaPrincical = Intent(this, TelaPrincipal::class.java)
        startActivity(telaPrincical)
    }
    //Ir para tela de cadastro
    private fun IrTelaCadastro(){
        val telaCadastro = Intent(this, TelaCadastro::class.java)
        startActivity(telaCadastro)
    }

    override fun onStart() {
        super.onStart()
    
        val usuarioAtual = FirebaseAuth.getInstance().currentUser
        if(usuarioAtual != null){
            IrTelaPrincipal()
        }
    }
    private val onBackInvokedCallback = object : OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            val horaAtual = System.currentTimeMillis()
            if(horaAtual - backPressedTime < doubleClick) {
                finishAffinity()
            } else {
                Toast.makeText(this@TelaLogin, "Pressione novamente para sair", Toast.LENGTH_SHORT).show()
                backPressedTime = horaAtual
            }
        }
    }
}