package lat.pam.kopidannyemil

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnLogin = view.findViewById<Button>(R.id.btnLogin)
        val btnRegister = view.findViewById<Button>(R.id.btnRegister)

        btnLogin?.setOnClickListener {
            findNavController().navigate(R.id.action_signUp_to_login)
        }

        btnRegister?.setOnClickListener {
            findNavController().navigate(R.id.action_signUp_to_register)
        }
    }
}