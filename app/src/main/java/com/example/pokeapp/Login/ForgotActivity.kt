package com.example.pokeapp.Login

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pokeapp.MainActivity
import com.example.pokeapp.R
import com.google.firebase.auth.FirebaseAuth

class ForgotActivity : AppCompatActivity() {
    private  lateinit var txtEmail: EditText
    private  lateinit var auth: FirebaseAuth
    private  lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)
        txtEmail = findViewById(R.id.txtEmailForgot)
        auth = FirebaseAuth.getInstance()
        progressBar = findViewById(R.id.progressBar2)
    }
    fun send (view: View){
        val email = txtEmail.text.toString()
        if(!TextUtils.isEmpty(email)) {
            auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener {
                        task ->

                        if(task.isSuccessful)
                        {
                            progressBar.visibility=View.VISIBLE
                            startActivity(Intent(this, LoginActivity::class.java))}
                        else
                        {
                            Toast.makeText(this,"Error al enviar el Email", Toast.LENGTH_LONG).show()}
                    }
        }

    }
}
