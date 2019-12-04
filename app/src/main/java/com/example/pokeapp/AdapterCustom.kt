package com.example.pokeapp

import android.content.Context
//import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.Models.Sprites
import com.example.pokeapp.ModelsDefintition.Pokemon
import tech.twentytwobits.recyclerviewexample.ClickListener
import tech.twentytwobits.recyclerviewexample.LongClickListener

class AdapterCustom(var context: Context, var items: ArrayList<Pokemon>, var clickListener: ClickListener, var longClickListener: LongClickListener): RecyclerView.Adapter<AdapterCustom.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.template_pokemon, parent, false)
        return ViewHolder(view, clickListener, longClickListener)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        internal var imgPoke: ImageView
        internal var txtPokemon: TextView
        init {
            imgPoke = itemView.findViewById(R.id.imageViewPokemon) as ImageView
            txtPokemon = itemView.findViewById(R.id.textViewnombre) as TextView
        }
    }


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        // Mapeo
        holder.nombre.text = item.name

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

        var nombre: TextView


        init {
            this.nombre = view.findViewById(R.id.textViewnombre)


            view.setOnClickListener(this)
            view.setOnLongClickListener(this)
        }
    }

}