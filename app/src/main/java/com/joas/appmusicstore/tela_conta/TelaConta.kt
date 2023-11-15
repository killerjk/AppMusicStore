package com.joas.appmusicstore.tela_conta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY
import com.google.android.material.progressindicator.BaseProgressIndicator.HideAnimationBehavior
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.joas.appmusicstore.databinding.ActivityTelaContaBinding
import com.joas.appmusicstore.tela_principal.TelaPrincipal
import com.joas.appmusicstore.tela_principal.fragments.ContaFragment

class TelaConta : AppCompatActivity() {

    private lateinit var binding: ActivityTelaContaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaContaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val auth = FirebaseAuth.getInstance()
        val db = FirebaseFirestore.getInstance()
        val usuarioUI = auth.currentUser?.uid
        val DocumentoReference : DocumentReference = db.collection("Usuários").document(usuarioUI.toString())
        DocumentoReference.get().addOnSuccessListener{
                if(it.exists()){
                    val nome = it.getString("nome")
                    val email = it.getString("email")
                    val senha = it.getString("senha")
                    binding.txtNome.text = "Nome: $nome"
                    binding.txtEmail.text = "Email: $email"
                    binding.txtSenha.text = "$senha"
                }
            }

        binding.btVoltar.setOnClickListener {
            finish()
        }

        binding.toggleButton.setOnCheckedChangeListener { _, isChecked ->
            val passwordEditText = binding.txtSenha
            if (isChecked) {
                // Mostrar a senha
                passwordEditText.inputType = android.text.InputType.TYPE_CLASS_TEXT
            } else {
                // Ocultar a senha
                passwordEditText.inputType = android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }
    }
}