package com.fcfm.poi

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import fcfm.poi.proyectoFinal.R

class gpochat : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnconversacion = findViewById<Button>(R.id.btnconversacion)
        val btnpubli = findViewById<Button>(R.id.btnpubli)

        btnconversacion.setOnClickListener {
            cambiar(conversación(),"conversación")
        }
        btnpubli.setOnClickListener {
            cambiar(publi(),"publi")
        }
    }
    private fun cambiar(nuevo: Fragment, etiqueta: String){

        supportFragmentManager.beginTransaction()
            .replace(R.id.contenido,nuevo,etiqueta)
            .commit()
    }

}