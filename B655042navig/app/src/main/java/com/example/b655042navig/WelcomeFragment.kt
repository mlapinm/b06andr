package com.example.b655042navig

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {
    private var buttonOk : Button? = null
    private var textViewUsername : TextView? = null
    private var textViewPassword : TextView? = null

    private val args: Bundle = Bundle()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonOk = view.findViewById(R.id.buttonOk)
        textViewUsername = view.findViewById(R.id.textViewUsername)
        textViewPassword = view.findViewById(R.id.textViewPassword)


        val username = arguments?.getString("username", "")
        val password = arguments?.getString("password", "")
        textViewUsername?.text = username
        textViewPassword?.text = password


        buttonOk?.setOnClickListener {
             val tv = view.findNavController()
                .navigate(R.id.action_welcomeFragment_to_homeFragment)



        }

    }
}