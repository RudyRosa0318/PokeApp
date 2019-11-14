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
        val pkmenu = PokeMenu()

        buttonbulbasaur1.setOnClickListener{
            val menuScreen = Intent(this, PokeMenu :: class.java)
            val valuePokemon = 1
            menuScreen.putExtra("valorPK",valuePokemon)
            startActivity(menuScreen)
        }

        buttonivysaur2.setOnClickListener{
            val menuScreen = Intent(this, PokeMenu :: class.java)
            val valuePokemon = 2
            menuScreen.putExtra("valorPK",valuePokemon)
            startActivity(menuScreen)
        }

        buttonvenusaur3.setOnClickListener{
            val menuScreen = Intent(this, PokeMenu :: class.java)
            val valuePokemon = 3
            menuScreen.putExtra("valorPK",valuePokemon)
            startActivity(menuScreen)
        }
    }


}
