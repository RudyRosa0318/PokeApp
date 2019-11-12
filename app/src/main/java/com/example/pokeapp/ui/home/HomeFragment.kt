package com.example.pokeapp.ui.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.service.media.MediaBrowserService
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.pokeapp.MenuPoke
import com.example.pokeapp.PokeMenu
import com.example.pokeapp.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?



    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_selecciona)
        homeViewModel.text.observe(this, Observer {
            textView.text = "Seleccione su Pokemon"
            setUpAddComplaint(root = PokeMenu())

        }
        )
        return root


    }

fun setUpAddComplaint(root:PokeMenu)
    {
        root.buttonbulbasaur1.setOnClickListener {
                   activity ?.supportFragmentManager ?.beginTransaction()
                    ?.replace(R.id.nav_home,HomeFragment())
                    ?.commit()
            startActivity(Intent(context, PokeMenu::class.java))
        }
    }

}