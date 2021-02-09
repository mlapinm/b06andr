package com.example.b655032navig

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController


class HomeFragment: Fragment(R.layout.fragment_home) {
    private var buttonLogin: Button? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonLogin = view.findViewById(R.id.buttonLogin)
        buttonLogin?.setOnClickListener {

            view.findNavController().navigate(R.id.action_homeFragment_to_loginFragment)

//            val action = HomeFragmentDirections.actionHomeFragmentToLoginFragment()
//            findNavController().navigate(action)
        }

    }
}