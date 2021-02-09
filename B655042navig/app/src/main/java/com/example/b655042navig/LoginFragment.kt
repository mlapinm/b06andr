package com.example.b655042navig

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class LoginFragment : Fragment(R.layout.fragment_login) {
    private var buttonConfirm: Button? = null
    private var editTextUsername: EditText? = null
    private var editTextPassword: EditText? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonConfirm = view.findViewById(R.id.buttonConfirm);
        editTextUsername = view.findViewById(R.id.editTextUsername)
        editTextPassword = view.findViewById(R.id.editTextPassword)

        buttonConfirm?.setOnClickListener {
            val username = editTextUsername?.text.toString()
            val password = editTextPassword?.text.toString()

            var args: Bundle = Bundle()
            args.putString("username", username)
            args.putString("password", password)
            view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment, args);
        }
    }

}