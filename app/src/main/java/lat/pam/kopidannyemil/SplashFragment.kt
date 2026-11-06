package lat.pam.kopidannyemil

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnStartNow = view.findViewById<Button>(R.id.btnStartNow)

        // Tanda '?' dihapus agar fungsi setOnClickListener mengikat kuat ke tombol
        btnStartNow.setOnClickListener {
            findNavController().navigate(R.id.action_splash_to_signUp)
        }
    }
}