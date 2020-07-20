package com.kcb.android.tourismguide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kcb.android.tourismguide.ui.culinary.CulinaryFragment
import com.kcb.android.tourismguide.ui.home.HomeFragment
import com.kcb.android.tourismguide.ui.tour.TourFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menu_bottom.setItemSelected(R.id.home)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_view, HomeFragment()).commit()
        menu_bottom.setOnItemSelectedListener { id ->
            when(id){
                R.id.home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_view, HomeFragment()).commit()
                }
                R.id.tour -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_view, TourFragment()).commit()
                }
                R.id.culinary -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_view, CulinaryFragment()).commit()
                }
            }
        }
    }
}