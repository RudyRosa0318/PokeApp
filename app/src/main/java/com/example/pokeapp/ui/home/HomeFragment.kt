package com.example.pokeapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.AdapterCustom
import com.example.pokeapp.Common.Common
import com.example.pokeapp.Common.ItemOffsetDecoration
import com.example.pokeapp.R
import com.example.pokeapp.Retrofit.IPokemonList
import com.example.pokeapp.Retrofit.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import tech.twentytwobits.recyclerviewexample.ClickListener
import tech.twentytwobits.recyclerviewexample.LongClickListener

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    internal var compositeDisposable = CompositeDisposable()
    internal var iPokemonList: IPokemonList
    internal lateinit var recyclerView: RecyclerView
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


        recyclerView = itemView.findViewById(R.id.pokemon_recycleview) as RecyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(activity!!, 3)
        val itemDecoration = ItemOffsetDecoration(activity!!,R.dimen.spacing)
        recyclerView.addItemDecoration(itemDecoration)
        fetchData()
        return itemView
    }

    private fun fetchData() {
        compositeDisposable.add(iPokemonList.listadoPokemon
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{ pokemones->
                Common.pokemonList = pokemones.pokemon!!
                  val adapter = AdapterCustom(activity!!, Common.pokemonList!!, object: ClickListener {
                    override fun onClick(view: View, index: Int) {
                        Log.d("CLICK", "click")
                    }
                }, object: LongClickListener {
                    override fun LongClickListener(view: View, index: Int) {
                        Log.d("LONGCLICK", "Longclick")
                    }
                })
                recyclerView.adapter = adapter
            }
        )
    }

}