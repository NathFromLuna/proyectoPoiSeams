package fcfm.poi.proyectoFinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import fcfm.poi.proyectoFinal.R

class logInSeams : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val btnEntrar=findViewById<Button>(R.id.btnEntrar)

        btnEntrar.setOnClickListener {
           val miIntent= Intent(this,pantallaPrincipalSeams::class.java)
            startActivity(miIntent)
        }
    }
}