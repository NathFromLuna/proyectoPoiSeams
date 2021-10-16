package com.fcfm.poi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import fcfm.poi.proyectoFinal.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnchat = findViewById<Button>(R.id.btnchat)
        val btngpo = findViewById<Button>(R.id.btngpo)
        val btntarea = findViewById<Button>(R.id.btntarea)

        cambiar(grupo(),"grupo")
        btnchat.setOnClickListener {
            cambiar(chats(),"chats")

        }
        btngpo.setOnClickListener {
            cambiar(grupo(),"grupo")
        }
        btntarea.setOnClickListener {
            cambiar(tarea(),"tarea")
        }
    }
    private fun cambiar(nuevo: Fragment,etiqueta: String){

        supportFragmentManager.beginTransaction()
            .replace(R.id.contenido,nuevo,etiqueta)
            .commit()
    }
}