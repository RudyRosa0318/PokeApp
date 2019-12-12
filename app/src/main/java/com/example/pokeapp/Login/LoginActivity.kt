package com.example.pokeapp.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.example.pokeapp.MenuPoke
import com.example.pokeapp.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private  lateinit var txtUser: EditText
    private  lateinit var txtPassword1: EditText
    private  lateinit var progressBar: ProgressBar
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        txtUser = findViewById(R.id.txtUser)
        txtPassword1 = findViewById(R.id.txtPassword)
        progressBar = findViewById(R.id.progressBar1)
        auth= FirebaseAuth.getInstance()
    }

    fun forgotPassword(view : View)
    {
        startActivity(Intent(this, ForgotActivity::class.java))
    }

    fun register(view : View)    {
    startActivity(Intent(this, RegisterActivity::class.java))
    }

    fun login(view : View)
    {
        loginUser()
    }

    private fun loginUser(){
        val user:String = txtUser.text.toString()
        val password:String = txtPassword.text.toString()

        if (!TextUtils.isEmpty(user) && !TextUtils.isEmpty(password) ){
            progressBar.visibility = View.VISIBLE
            auth.signInWithEmailAndPassword(user, password)
                    .addOnCompleteListener {
                        task ->
                        if(task.isSuccessful){
                            action()
                        }
                        else{
                            Toast.makeText(this,"Error en la autenticacion", Toast.LENGTH_LONG).show()
                        }
                    }
        }
    }

    /*
    supportaccionbar.title
    https://console.firebase.google.com/project/bdpoke-4f597/database/bdpoke-4f597/data~2F
    https://www.youtube.com/watch?v=xf-LNA6m97g*/

    private fun action(){
        startActivity(Intent(this,MenuPoke::class.java))
    }
}
