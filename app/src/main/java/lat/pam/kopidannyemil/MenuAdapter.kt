package lat.pam.kopidannyemil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(
    private var listMenu: List<MenuItem>,
    private val onItemClick: (MenuItem) -> Unit
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNama: TextView = itemView.findViewById(R.id.tvNamaMenu)
        val tvDeskripsi: TextView = itemView.findViewById(R.id.tvDeskripsiMenu)
        val tvHarga: TextView = itemView.findViewById(R.id.tvHargaMenu)
        val tvEmoji: TextView = itemView.findViewById(R.id.tvEmojiMenu) // Penampung emoji
        val btnAddItem: ImageButton = itemView.findViewById(R.id.btnAddItem) // Tombol tambah
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val menu = listMenu[position]

        holder.tvNama.text = menu.name
        holder.tvDeskripsi.text = menu.desc
        holder.tvHarga.text = DummyData.rupiah(menu.price)
        holder.tvEmoji.text = menu.emoji // Memunculkan emoji dari DummyData

        holder.btnAddItem.setOnClickListener {
            onItemClick(menu)
        }

        holder.itemView.setOnClickListener {
            onItemClick(menu)
        }
    }

    override fun getItemCount(): Int = listMenu.size

    fun updateList(newList: List<MenuItem>) {
        this.listMenu = newList
        notifyDataSetChanged()
    }
}