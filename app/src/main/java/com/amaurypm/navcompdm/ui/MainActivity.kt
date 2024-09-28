package com.amaurypm.navcompdm.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.amaurypm.navcompdm.R
import com.amaurypm.navcompdm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //Instanciando el NavHost
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container)
                    as NavHostFragment

        //Instanciamos el NavController
        navController = navHostFragment.navController

        //Para usar el actionbar en la navegación
        NavigationUI.setupActionBarWithNavController(this, navController)

    }

    override fun onNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null)
    }
}