package lat.pam.kopidannyemil

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnLoginSubmit = view.findViewById<Button>(R.id.btnLoginSubmit)
        // Gunakan TextInputEditText agar ID etUsername tidak bernilai null
        val etUsername = view.findViewById<TextInputEditText>(R.id.etUsername)

        btnLoginSubmit?.setOnClickListener {
            // Ambil teks username yang diketik pengguna
            val inputUsername = etUsername?.text?.toString()?.trim() ?: ""

            // JIKA USERNAME DIISI, PAKAI USERNAME KETIKAN TERSEBUT SEBAGAI NAMA TAMPILAN
            // JIKA KOSONG, BARU GUNAKAN NAMA DEFAULT "User"
            val namaTampil = if (inputUsername.isNotEmpty()) inputUsername else "User"

            // Simpan data ke DummyData.currentUser
            DummyData.currentUser = User(
                name = namaTampil,
                username = inputUsername,
                password = ""
            )

            // Pindah ke Home Fragment
            findNavController().navigate(R.id.action_login_to_home)
        }
    }
}