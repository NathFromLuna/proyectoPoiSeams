package fcfm.poi.proyectoFinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        val btnRegistro = findViewById<Button>(R.id.btnRegistro);
        val btnEntrar = findViewById<Button>(R.id.btnEntrar);

        btnRegistro.setOnClickListener {
            val intent=(Intent (this,crearcuenta::class.java ))
            startActivity(intent)
        }
        btnEntrar.setOnClickListener {
            val intent=(Intent (this,MainActivity::class.java ))
            startActivity(intent)
        }
    }
}