package com.example.pokeapp.Retrofit




import com.example.pokeapp.Models.PokeList
import io.reactivex.Observable
import retrofit2.http.GET


interface IPokemonList {
    @get:GET("pokelist.json")
    val listadoPokemon:Observable<PokeList>
}