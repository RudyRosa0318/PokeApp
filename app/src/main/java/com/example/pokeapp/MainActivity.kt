package com.example.pokeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.example.pokeapp.Login.LoginActivity
import com.example.pokeapp.Login.RegisterActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Contador para salir del activity
    var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        centerbtn.setOnClickListener{
            val menuScreen = Intent(this, LoginActivity :: class.java)
            startActivity(menuScreen)
        }

    }
    override fun onBackPressed() {

        if (contador == 0) {
            Toast.makeText(this, "Presione de nuevo para salir", Toast.LENGTH_SHORT).show()
            contador = 1

        } else {
            super.onBackPressed()
        }
        object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                contador = 0
            }
        }.start()
    }




}
