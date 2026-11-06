package lat.pam.kopidannyemil

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var btnHome: Button
    private lateinit var btnOrder: Button
    private lateinit var btnProfile: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val bottomNavContainer = findViewById<View>(R.id.bottomNavContainer)
        btnHome = findViewById(R.id.navBtnHome)
        btnOrder = findViewById(R.id.navBtnOrder)
        btnProfile = findViewById(R.id.navBtnProfile)

        // Pantau perpindahan halaman untuk menyembunyikan/memunculkan navbar
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashFragment, R.id.signUpFragment, R.id.loginFragment, R.id.registerFragment -> {
                    bottomNavContainer.visibility = View.GONE
                }
                else -> {
                    bottomNavContainer.visibility = View.VISIBLE
                    // Otomatis update style tombol sesuai halaman aktif
                    when (destination.id) {
                        R.id.homeFragment -> updateNavStyle(btnHome)
                        R.id.addressFragment -> updateNavStyle(btnOrder)
                        R.id.profileFragment -> updateNavStyle(btnProfile)
                    }
                }
            }
        }

        btnHome.setOnClickListener {
            navController.navigate(R.id.homeFragment)
        }

        btnOrder.setOnClickListener {
            navController.navigate(R.id.addressFragment)
        }

        btnProfile.setOnClickListener {
            navController.navigate(R.id.profileFragment)
        }
    }

    private fun updateNavStyle(selected: Button) {
        listOf(btnHome, btnOrder, btnProfile).forEach { btn ->
            btn.setTypeface(null, android.graphics.Typeface.NORMAL)
            btn.setTextColor(Color.parseColor("#666666"))
        }
        selected.setTypeface(null, android.graphics.Typeface.BOLD)
        selected.setTextColor(Color.parseColor("#222222"))
    }

    // Fungsi updateBadge jika Anda menggunakan BottomNavigationView bawaan
    fun updateBadge() {
        // Jika navbar bawah Anda menggunakan BottomNavigationView:
        // val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        // val count = DummyData.cartCount()
        // val badge = bottomNav.getOrCreateBadge(R.id.addressFragment)
        // badge.isVisible = count > 0
        // badge.number = count
    }
}