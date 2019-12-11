package com.example.pokeapp.ui.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.service.media.MediaBrowserService
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.AdapterCustom
import com.example.pokeapp.Common.Common
import com.example.pokeapp.Common.ItemOffsetDecoration
import com.example.pokeapp.MenuPoke
import com.example.pokeapp.PokeMenu
import com.example.pokeapp.R
import com.example.pokeapp.Retrofit.IPokemonList
import com.example.pokeapp.Retrofit.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_seleccion.*
import kotlinx.android.synthetic.main.fragment_home.*
import tech.twentytwobits.recyclerviewexample.ClickListener
import tech.twentytwobits.recyclerviewexample.LongClickListener

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    internal var compositeDisposable = CompositeDisposable()
    internal var iPokemonList: IPokemonList
    internal lateinit var recycler_view: RecyclerView
    init {
        val retrofit = RetrofitClient.instances
        iPokemonList = retrofit.create(IPokemonList::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val itemView = inflater.inflate(R.layout.fragment_home, container, false)
        //val textView: TextView = itemView.findViewById(R.id.text_selecciona)

        homeViewModel.text.observe(this, Observer {
            //textView.text = "Seleccione su Pokemon"

            /*recycler_view = itemView.findViewById(R.id.recycleViewPokemon) as RecyclerView
            recycler_view.setHasFixedSize(true)
            recycler_view.layoutManager = GridLayoutManager(activity!!, 3)
            val itemDecoration = ItemOffsetDecoration(activity!!,R.dimen.spacing)
            recycler_view.addItemDecoration(itemDecoration)
            fetchData()*/


        })
/*
        swipeRefreshLayout.setOnRefreshListener {
            Log.d("REFRESH", "La información se ha refrescado")
            // Mentirita
            for (i in 1..100000000) {
            }
            swipeRefreshLayout.isRefreshing = false
        }*/
        return itemView
    }

    /*private fun fetchData() {
        compositeDisposable.add(iPokemonList.listadoPokemon
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{ pokemones->
                Common.pokemonList = pokemones.pokemones!!
                //val adapter = AdapterCustom(this!!,Common.pokemonList,object:ClickListener)
                val adapter = AdapterCustom(activity!!, Common.pokemonList, object: ClickListener {
                    override fun onClick(view: View, index: Int) {
                        Log.d("CLICK", "click")
                    }
                }, object: LongClickListener {
                    override fun LongClickListener(view: View, index: Int) {
                        Log.d("LONGCLICK", "Longclick")
                    }
                })
                recycler_view.adapter = adapter
            }
        )
    }*/


}