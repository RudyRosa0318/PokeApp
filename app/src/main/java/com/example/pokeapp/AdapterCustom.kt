package com.example.pokeapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokeapp.Models.ApiResponse
import tech.twentytwobits.recyclerviewexample.ClickListener
import tech.twentytwobits.recyclerviewexample.LongClickListener

class AdapterCustom(var context: Context, var pokemonList: List<ApiResponse>, var clickListener: ClickListener, var longClickListener: LongClickListener): RecyclerView.Adapter<AdapterCustom.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.template_pokemon, parent, false)
        return ViewHolder(view, clickListener, longClickListener)
    }


    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(pokemonList[position].sprites.front_default).into(holder.img_Poke)
        holder.txtPokemon.text = pokemonList[position].name
    }

    // Mapear las variables de cada item dentro de items con los
    // widgets correspondientes dentro de la vista
    class ViewHolder(var view: View, var clickListener: ClickListener, var longClickListener: LongClickListener): RecyclerView.ViewHolder(view), View.OnClickListener, View.OnLongClickListener {
        override fun onLongClick(v: View?): Boolean {
            longClickListener.LongClickListener(view, adapterPosition)

            return true
        }

        override fun onClick(v: View?) {
            clickListener.onClick(view, adapterPosition)
        }

        internal var img_Poke: ImageView
        internal var txtPokemon: TextView

        init {
            img_Poke = itemView.findViewById(R.id.imageViewPokemon) as ImageView
            txtPokemon = itemView.findViewById(R.id.textViewnombre) as TextView
            view.setOnClickListener(this)
            view.setOnLongClickListener(this)
        }
    }


}