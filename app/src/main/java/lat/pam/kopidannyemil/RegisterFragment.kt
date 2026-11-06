package lat.pam.kopidannyemil

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class RegisterFragment : Fragment(R.layout.fragment_register) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Pastikan ID di bawah ini sesuai dengan ID Button di fragment_register.xml
        val btnRegisterSubmit = view.findViewById<Button>(R.id.btnRegisterSubmit)

        btnRegisterSubmit.setOnClickListener {
            // Berpindah dari Register ke Login
            findNavController().navigate(R.id.action_register_to_login)
        }
    }
}