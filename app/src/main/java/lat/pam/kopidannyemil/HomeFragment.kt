package lat.pam.kopidannyemil

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var adapter: MenuAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Menampilkan nama pengguna yang sedang login
        val name = DummyData.currentUser?.name ?: "Tamu"
        view.findViewById<TextView>(R.id.tvGreeting).text = "Halo $name,"

        val rvMenu = view.findViewById<RecyclerView>(R.id.rvMenu)
        rvMenu.layoutManager = LinearLayoutManager(requireContext())

        // Inisialisasi Adapter dengan seluruh data menu
        adapter = MenuAdapter(DummyData.menu) { selectedItem ->
            DummyData.addToCart(selectedItem)
            findNavController().navigate(R.id.action_home_to_address)
        }
        rvMenu.adapter = adapter

        // Referensi Tombol Kategori di XML
        val btnSemua = view.findViewById<Button>(R.id.btnSemua)       // Beri id di xml jika belum ada
        val btnMinuman = view.findViewById<Button>(R.id.btnMinuman) // Beri id di xml jika belum ada
        val btnMakanan = view.findViewById<Button>(R.id.btnMakanan) // Beri id di xml jika belum ada

        // Fungsi bantu untuk mengubah warna tombol yang aktif
        fun setCategoryStyle(activeBtn: Button) {
            listOf(btnSemua, btnMinuman, btnMakanan).forEach { btn ->
                btn?.setBackgroundColor(Color.parseColor("#FFFFFF"))
                btn?.setTextColor(Color.parseColor("#444444"))
            }
            activeBtn.setBackgroundColor(Color.parseColor("#FFE0B2"))
            activeBtn.setTextColor(Color.parseColor("#D84315"))
        }

        // Aksi klik tombol "Semua"
        btnSemua?.setOnClickListener {
            setCategoryStyle(btnSemua)
            adapter.updateList(DummyData.menu)
        }

        // Aksi klik tombol "Minuman"
        btnMinuman?.setOnClickListener {
            setCategoryStyle(btnMinuman)
            val filteredList = DummyData.menu.filter { it.category == "Minuman" }
            adapter.updateList(filteredList)
        }

        // Aksi klik tombol "Makanan"
        btnMakanan?.setOnClickListener {
            setCategoryStyle(btnMakanan)
            val filteredList = DummyData.menu.filter { it.category == "Makanan" }
            adapter.updateList(filteredList)
        }
    }
}