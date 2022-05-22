package org.modernism_in_architecture.mia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fragments
        val buildingFragment = BuildingFragment()
        val placesFragment = PlacesFragment()
        val architectsFragment = ArchitectsFragment()

        setCurrentFragment(buildingFragment)

        // Menu
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigation.setOnItemSelectedListener  {
            when(it.itemId){
                R.id.buildings->setCurrentFragment(buildingFragment)
                R.id.places->setCurrentFragment(placesFragment)
                R.id.architects->setCurrentFragment(architectsFragment)
            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }
    }
}