package lat.pam.kopidannyemil

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Pastikan ID di bawah ini sesuai dengan ID Button di fragment_login.xml
        val btnLoginSubmit = view.findViewById<Button>(R.id.btnLoginSubmit)

        btnLoginSubmit.setOnClickListener {
            val inputUsername = view.findViewById<EditText>(R.id.etUsername).text.toString()

            // SIMPAN DATA NAMA KE DUMMYDATA AGAR TERBACA DI HOME
            // (Jika user mengosongkan inputan, kita beri nama sesuai ketikan atau default "Adi Karunia")
            DummyData.currentUser = User(
                name = if (inputUsername.isNotEmpty()) inputUsername else "Adi Karunia",
                username = inputUsername,
                password = ""
            )

            // Pindah ke halaman Home
            findNavController().navigate(R.id.action_login_to_home)
        }
    }
}