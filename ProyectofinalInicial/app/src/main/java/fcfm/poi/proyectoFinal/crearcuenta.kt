package fcfm.poi.proyectoFinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class crearcuenta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cuentanueva)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener {
            val intent=(Intent (this,MainActivity::class.java ))
            startActivity(intent)
        }

    }
}