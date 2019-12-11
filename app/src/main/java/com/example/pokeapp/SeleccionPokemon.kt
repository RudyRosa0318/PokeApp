package com.example.pokeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.Common.Common
import com.example.pokeapp.Common.ItemOffsetDecoration
import com.example.pokeapp.Retrofit.IPokemonList
import com.example.pokeapp.Retrofit.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_seleccion.*
import kotlinx.android.synthetic.main.fragment_menu_seleccion_pokemon.*
import tech.twentytwobits.recyclerviewexample.ClickListener
import tech.twentytwobits.recyclerviewexample.LongClickListener


class SeleccionPokemon : AppCompatActivity() {
  /*  private lateinit var layoutManager: RecyclerView.LayoutManager
    internal var compositeDisposable = CompositeDisposable()
    internal var iPokemonList:IPokemonList
    internal lateinit var recycler_view:RecyclerView
    init {
        val retrofit = RetrofitClient.instances
        iPokemonList = retrofit.create(IPokemonList::class.java)
    }
*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_seleccion)

       // layoutManager = GridLayoutManager(this, 3)

/*
        //recycler_view = itemView.findViewById(R.id.recycleViewPokemon)
        recycleViewPokemon.setHasFixedSize(true)
        recycleViewPokemon.layoutManager = layoutManager
        //recycleViewPokemon.adapter = adapter
        val itemDecoration = ItemOffsetDecoration(this!!,R.dimen.spacing)
        recycleViewPokemon.addItemDecoration(itemDecoration)
        fetchData()

        swipeRefreshLayout.setOnRefreshListener {
            Log.d("REFRESH", "La información se ha refrescado")

            // Mentirita
            for (i in 1..100000000) {

            }
            swipeRefreshLayout.isRefreshing = false

        }*/
    }

  /*  private fun fetchData() {
        compositeDisposable.add(iPokemonList.listadoPokemon
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{ pokemones->
                Common.pokemonList = pokemones.pokemones!!
                //val adapter = AdapterCustom(this!!,Common.pokemonList,object:ClickListener)
                val adapter = AdapterCustom(this, Common.pokemonList, object: ClickListener {
                    override fun onClick(view: View, index: Int) {
                        Log.d("CLICK", "click")
                    }
                }, object: LongClickListener {
                    override fun LongClickListener(view: View, index: Int) {
                        Log.d("LONGCLICK", "Longclick")
                    }
                })
                pokemon_recycleview.adapter = adapter
            }
        );
    }*/

}
