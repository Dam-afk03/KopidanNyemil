package lat.pam.kopidannyemil

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText

class AddressFragment : Fragment(R.layout.fragment_address) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvSummary = view.findViewById<TextView>(R.id.tvOrderSummary)
        val tvTotal = view.findViewById<TextView>(R.id.tvOrderTotal)
        val etNama = view.findViewById<TextInputEditText>(R.id.etNamaLengkapAlamat)
        val etAlamat = view.findViewById<TextInputEditText>(R.id.etAlamat)
        val etDetail = view.findViewById<TextInputEditText>(R.id.etDetailAlamat)
        val btnOrderKirim = view.findViewById<Button>(R.id.btnOrderKirim)

        // Isi rincian pesanan dari DummyData.cart
        if (DummyData.cart.isNotEmpty()) {
            val summaryText = StringBuilder()
            DummyData.cart.forEach { (item, qty) ->
                summaryText.append("${qty}x  ${item.name}  -  ${DummyData.rupiah(item.price * qty)}\n")
            }
            tvSummary.text = summaryText.toString().trim()
            tvTotal.text = "Total: ${DummyData.rupiah(DummyData.cartTotal())}"
        } else {
            tvSummary.text = "Belum ada item di keranjang"
            tvTotal.text = "Total: Rp 0"
        }

        // Auto-fill nama dari user yang sedang login
        etNama?.setText(DummyData.currentUser?.name ?: "")

        // Klik Tombol Order dan Kirim
        btnOrderKirim.setOnClickListener {
            if (DummyData.cart.isEmpty()) {
                Toast.makeText(requireContext(), "Keranjang Anda masih kosong!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val alamat = etAlamat.text.toString()
            if (alamat.isEmpty()) {
                etAlamat.error = "Alamat tidak boleh kosong"
                return@setOnClickListener
            }

            // Pindah ke halaman konfirmasi
            findNavController().navigate(R.id.action_address_to_confirmation)
        }
    }
}