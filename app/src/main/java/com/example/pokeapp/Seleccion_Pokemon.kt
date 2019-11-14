package com.example.pokeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_seleccion__pokemon.*

class Seleccion_Pokemon : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seleccion__pokemon)

        buttonbulbasaur1.setOnClickListener{
            val menuScreen = Intent(this, PokeMenu :: class.java)
            startActivity(menuScreen)
        }
    }


}
