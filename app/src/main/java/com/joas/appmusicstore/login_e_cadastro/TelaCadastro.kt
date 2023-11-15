package com.joas.appmusicstore.login_e_cadastro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.joas.appmusicstore.databinding.ActivityTelaCadastroBinding


class TelaCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityTelaCadastroBinding
    private val auth = Firebase.auth
    private var usuarioID: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCriarconta.setOnClickListener {

            val username = binding.editNome.text.toString()
            val useremail = binding.editEmail.text.toString()
            val usersenha = binding.editSenha.text.toString()

            if(username.isEmpty() || useremail.isEmpty() || usersenha.isEmpty()){
                Toast.makeText(this, "Preencha todos do campos.", Toast.LENGTH_SHORT).show()

            }else {
                auth.createUserWithEmailAndPassword(useremail, usersenha).addOnCompleteListener { cadastro ->
                    if (cadastro.isSuccessful) {
                        Toast.makeText(this, "Conta cadastrada com sucesso.", Toast.LENGTH_SHORT).show()
                        IrTelaLogin()
                        SalvarDadosUsuario()
                    }

                } .addOnFailureListener {exception ->

                    val mensagemErro = when(exception){
                        is FirebaseAuthWeakPasswordException -> "A senha precisa ter no mínimo 6 caracteres."
                        is FirebaseAuthInvalidCredentialsException -> "Email inválido."
                        is FirebaseAuthUserCollisionException -> "Conta com o email já existe."
                        is FirebaseNetworkException -> "Verifique sua conexão com a internet."
                        else -> "Erro ao cadastrar o usuário."
                    }
                    Toast.makeText(this, "$mensagemErro", Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.btCancelar.setOnClickListener{
            IrTelaLogin()
        }
    }

    private fun SalvarDadosUsuario(){
        val nome = binding.editNome.text.toString()
        val email = binding.editEmail.text.toString()
        val senha = binding.editSenha.text.toString()

        val db = FirebaseFirestore.getInstance()

        val usuarios = hashMapOf<String, String>()
        usuarios["nome"] = nome
        usuarios["email"] = email
        usuarios["senha"] = senha

        usuarioID = FirebaseAuth.getInstance().currentUser?.uid

        val documentReference: DocumentReference = db.collection("Usuários").document(usuarioID.toString())
        documentReference.set(usuarios).addOnCompleteListener{
            Log.d("db", "Sucesso ao salvar os dados do usuário")
        }
        .addOnFailureListener{
            Log.d("db_error", "Erro ao salvar os dados")
        }
    }

    private fun IrTelaLogin(){

        val telaLogin = Intent(this, TelaLogin::class.java)
        startActivity(telaLogin)
    }

}