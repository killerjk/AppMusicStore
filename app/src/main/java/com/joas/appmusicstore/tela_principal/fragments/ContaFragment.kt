package com.joas.appmusicstore.tela_principal.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.joas.appmusicstore.databinding.FragmentContaBinding
import com.joas.appmusicstore.login_e_cadastro.TelaLogin
import com.joas.appmusicstore.tela_conta.TelaConta

class ContaFragment : Fragment() {

    private var _binding : FragmentContaBinding? = null
    private val binding get() =_binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContaBinding.inflate(inflater)

        binding.btDeslogar.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val telaLogin = Intent(context, TelaLogin::class.java)
            startActivity(telaLogin)
        }

        binding.btConta.setOnClickListener {
            val telaConta = Intent(context, TelaConta::class.java)
            startActivity(telaConta)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}