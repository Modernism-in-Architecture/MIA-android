package org.modernism_in_architecture.mia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MiaActivity : AppCompatActivity(R.layout.activity_mia) {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        val navController = navHostFragment.navController
        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        findViewById<BottomNavigationView>(R.id.bottom_navigation)
            .setupWithNavController(navController)

        setSupportActionBar(toolbar)

        // setupActionBarWithNavController(navController)
    }
}

