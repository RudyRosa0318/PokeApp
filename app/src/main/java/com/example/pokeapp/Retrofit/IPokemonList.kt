package com.example.pokeapp.Retrofit

import com.example.pokeapp.Initial.Pokedex
import io.reactivex.Observable
import retrofit2.http.GET


interface IPokemonList {
    @get:GET("pokedex.json")
    val listadoPokemon:Observable<Pokedex>
}