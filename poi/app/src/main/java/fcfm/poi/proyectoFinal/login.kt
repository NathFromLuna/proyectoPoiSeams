package fcfm.poi.proyectoFinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        val btnRegistro = findViewById<Button>(R.id.btnRegistro);
        val btnEntrar = findViewById<Button>(R.id.btnEntrar);
        //tomar valores para revisar si existe en la base de datos
        val correo= findViewById<EditText>(R.id.edtUsuario).text.toString()
        val contra= findViewById<EditText>(R.id.edtContrasena).text.toString()

        btnRegistro.setOnClickListener {

            val intent=(Intent (this,crearcuenta::class.java ))
            startActivity(intent)
        }
        btnEntrar.setOnClickListener {

            //hay que hacer un if solo si existe
            val intent=(Intent (this,MainActivity::class.java ))
            startActivity(intent)
        }
    }
}