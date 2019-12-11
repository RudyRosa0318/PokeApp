package com.example.pokeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.pokeapp.Models.ApiResponse
import com.example.pokeapp.ModelsDefintition.SpeciesResponse
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pokemon_detail.*

class Poke : AppCompatActivity() {
    var pokeid:Int=0
    var pokeimagen: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)
        val objetoIntent = intent
        pokeid = objetoIntent.getIntExtra("valorPK",0)

        verifyAndConnect()
        //verifyAndConnect2()

    }

    private fun verifyAndConnect() {
        if (Network.verifyConnection(this)) {
            httpVolley(getUrlApi())

        }
        else if (Network.verifyConnection(this)) {
            httpVolley(getUrlApi2())}

        else {
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
        val speciesResponse = gson.fromJson(response, SpeciesResponse ::class.java)

        // Verificar si la solicitud HTTP a la API es correcta (code 200)
//        if (apiResponse.cod == 200) {

       textviewname.text = apiResponse.name
       //textViewdatos1.text = speciesResponse.genera[2].genus[2].toString()
        textViewdatos1.text = apiResponse.id.toString()
        textViewdatos2.text = apiResponse.height.toString()
        textViewdatos3.text = apiResponse.stats[0].base_stat.toString()
        textViewdatos4.text = apiResponse.moves[0].move.name


        Picasso.get()
            .load(apiResponse.sprites.front_default)
            .resize(800, 800)
            .into(imageviewpokemon)

        toast("Datos obtenidos correctamente")
  //      }
    }


        fun getUrlApi():String {
        return "https://pokeapi.co/api/v2/pokemon/$pokeid/"

    }

    fun getUrlApi2():String {
            return "https://pokeapi.co/api/v2/pokemon-species/$pokeid//"
    }


}
