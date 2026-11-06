package lat.pam.kopidannyemil

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = DummyData.currentUser?.name ?: "Tamu"

        val tvGreeting = view.findViewById<TextView>(R.id.tvProfileGreeting)
        val tvAvatar = view.findViewById<TextView>(R.id.tvAvatar)
        val etNama = view.findViewById<EditText>(R.id.etProfileNama)
        val btnSave = view.findViewById<Button>(R.id.btnSaveProfile)
        val btnLogout = view.findViewById<Button>(R.id.btnLogout)

        // Pasang data pengguna
        tvGreeting.text = "Halo $name,"
        tvAvatar.text = name.take(1).uppercase()
        etNama.setText(name)

        // Tombol Simpan Perubahan Nama
        btnSave.setOnClickListener {
            val updatedName = etNama.text.toString()
            if (updatedName.isNotEmpty()) {
                DummyData.currentUser?.name = updatedName
                tvGreeting.text = "Halo $updatedName,"
                tvAvatar.text = updatedName.take(1).uppercase()
                Toast.makeText(requireContext(), "Profil berhasil diperbarui!", Toast.LENGTH_SHORT).show()
            }
        }

        // Tombol Logout -> Reset data dan kembali ke halaman Login
        btnLogout.setOnClickListener {
            // 1. Reset data pengguna & keranjang
            DummyData.currentUser = null
            DummyData.cart.clear()

            // 2. Reset badge navbar jika ada
            (activity as? MainActivity)?.updateBadge()

            // 3. Navigasi ke halaman awal (SignUp/Splash)
            try {
                findNavController().navigate(R.id.action_profile_to_signUp)
            } catch (e: Exception) {
                // Alternatif aman jika action-id bermasalah:
                findNavController().navigate(R.id.signUpFragment)
            }
        }
    }
}