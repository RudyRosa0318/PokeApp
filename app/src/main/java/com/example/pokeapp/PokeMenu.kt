package com.example.pokeapp

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.pokeapp.Models.ApiResponse
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_poke_menu.*


class PokeMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poke_menu)

        verifyAndConnect()

    }

    private fun verifyAndConnect() {
        if (Network.verifyConnection(this)) {
            httpVolley(getUrlApi())
        } else {
            toast("¡No tienes conexión a Internet!")
        }

    }

    private fun httpVolley(url: String) {
        val queue = Volley.newRequestQueue(this)

        // Obtener un string de respuesta desde la URL enviada
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                Log.d("HTTPVolley",  response)
                toast("Conexión establecida")
                //
               jsonToObject(response)

            },
            Response.ErrorListener {
                Log.d("HTTPVolley", "Error en la URL $url")
                toast("¡Ha ocurrido un error en la conexión!")
            })

        // Agregar la peticion a la cola de peticiones
        queue.add(stringRequest)

    }

    private fun jsonToObject(response: String) {
        // Inicializar los valores de tipo Gson
        val gson = Gson()
        val apiResponse = gson.fromJson(response, ApiResponse::class.java)

        // Verificar si la solicitud HTTP a la API es correcta (code 200)
        if (apiResponse.cod == 200) {

        textviewname.text = apiResponse.species?.get(0)?.name.toString()
        //textviewname.text = getString(R.string.text_view_name, apiResponse.name)
        toast("Datos obtenidos correctamente")
        }
    }

    private fun getUrlApi():String {
        return "https://pokeapi.co/api/v2/pokemon/1/"

    }


}
