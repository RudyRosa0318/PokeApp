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

        buttoncharmander4.setOnClickListener{
            val menuScreen = Intent(this, PokeMenu :: class.java)
            val valuePokemon = 4
            menuScreen.putExtra("valorPK",valuePokemon)
            startActivity(menuScreen)
        }

        buttoncharmeleon5.setOnClickListener{
            val menuScreen = Intent(this, PokeMenu :: class.java)
            val valuePokemon = 5
            menuScreen.putExtra("valorPK",valuePokemon)
            startActivity(menuScreen)
        }

        buttoncharizard6.setOnClickListener{
            val menuScreen = Intent(this, PokeMenu :: class.java)
            val valuePokemon = 6
            menuScreen.putExtra("valorPK",valuePokemon)
            startActivity(menuScreen)
        }

        buttonsquirtle7.setOnClickListener{
            val menuScreen = Intent(this, PokeMenu :: class.java)
            val valuePokemon = 7
            menuScreen.putExtra("valorPK",valuePokemon)
            startActivity(menuScreen)
        }

        buttonwartortle8.setOnClickListener{
            val menuScreen = Intent(this, PokeMenu :: class.java)
            val valuePokemon = 8
            menuScreen.putExtra("valorPK",valuePokemon)
            startActivity(menuScreen)
        }

        buttonblastoise9.setOnClickListener{
            val menuScreen = Intent(this, PokeMenu :: class.java)
            val valuePokemon = 9
            menuScreen.putExtra("valorPK",valuePokemon)
            startActivity(menuScreen)
        }

        buttoncaterpie10.setOnClickListener{
            val menuScreen = Intent(this, PokeMenu :: class.java)
            val valuePokemon = 10
            menuScreen.putExtra("valorPK",valuePokemon)
            startActivity(menuScreen)
        }
    }


}
