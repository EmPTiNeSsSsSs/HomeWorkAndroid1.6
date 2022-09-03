package com.example.homeworkandroid10.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.homeworkandroid10.R
import com.example.homeworkandroid10.databinding.FragmentRegistrationBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegistrationFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
        auth = Firebase.auth
        checkerUser()
    }

    private fun initClicker() {
        binding.btnStartRegistration.setOnClickListener {
            findNavController().navigate(R.id.authFragment)
        }
    }
    private fun checkerUser() {
        val firebaseUser = auth.currentUser
        if (firebaseUser != null) {
            findNavController().navigate(R.id.homeFragment)
        }
    }
}