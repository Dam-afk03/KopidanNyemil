package lat.pam.kopidannyemil

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class RegisterFragment : Fragment(R.layout.fragment_register) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnRegisterSubmit = view.findViewById<Button>(R.id.btnRegisterSubmit)
        val etNamaLengkap = view.findViewById<EditText>(R.id.etNamaLengkap)
        val etUsernameReg = view.findViewById<EditText>(R.id.etUsernameReg)

        btnRegisterSubmit.setOnClickListener {
            val nama = etNamaLengkap.text.toString()
            val username = etUsernameReg.text.toString()

            // Simpan data pendaftaran ke DummyData (opsional)
            if (nama.isNotEmpty() || username.isNotEmpty()) {
                DummyData.currentUser = User(
                    name = if (nama.isNotEmpty()) nama else "User Baru",
                    username = username,
                    password = ""
                )
            }

            // Navigasi dari Register kembali/lanjut ke Login
            findNavController().navigate(R.id.action_register_to_login)
        }
    }
}