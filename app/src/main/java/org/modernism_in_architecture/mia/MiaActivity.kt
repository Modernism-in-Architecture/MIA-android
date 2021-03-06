package org.modernism_in_architecture.mia

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MiaActivity : AppCompatActivity(R.layout.activity_mia) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val navController = navHostFragment.navController

        setSupportActionBar(toolbar)
        setupBottomNavMenu(navController)

        // handleIntent(intent)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu.findItem(R.id.search).actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }

        return true
    }

    private fun setupBottomNavMenu(navController: NavController) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav?.let {
            NavigationUI.setupWithNavController(it, navController)
        }
    }

//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        val navController = Navigation.findNavController(this, R.id.nav_host)
//        val navigated = NavigationUI.onNavDestinationSelected(item!!, navController)
//        return navigated || super.onOptionsItemSelected(item)
//    }

    private fun handleIntent(intent: Intent) {

        if (Intent.ACTION_SEARCH == intent.action) {
            val query = intent.getStringExtra(SearchManager.QUERY)
            if (query != null) {
                Log.v("INTENT", query)
            }
            //use the query to search your data somehow
        }
    }

}

