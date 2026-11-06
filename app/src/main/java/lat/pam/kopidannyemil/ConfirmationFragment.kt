package lat.pam.kopidannyemil

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ConfirmationFragment : Fragment(R.layout.fragment_confirmation) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = DummyData.currentUser?.name ?: "Tamu"
        view.findViewById<TextView>(R.id.tvConfirmationGreeting).text = "Halo $name,"

        val btnOke = view.findViewById<Button>(R.id.btnOkeConfirmation)

        btnOke.setOnClickListener {
            // Bersihkan keranjang belanja setelah selesai pesan
            DummyData.cart.clear()

            // Perbarui badge di MainActivity
            (activity as? MainActivity)?.updateBadge()

            // Kembali ke halaman Home
            findNavController().navigate(R.id.action_confirmation_to_home)
        }
    }
}