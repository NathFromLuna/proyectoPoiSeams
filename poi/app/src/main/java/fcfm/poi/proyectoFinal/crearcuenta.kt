package fcfm.poi.proyectoFinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.database.FirebaseDatabase
import fcfm.poi.proyectoFinal.clases.Usuario

class crearcuenta : AppCompatActivity() {

    private val dataBase=FirebaseDatabase.getInstance()
    private val ramaUsuarios=dataBase.getReference("usuarios")

    //databaseReference=Firebase.database.getReference("Users")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cuentanueva)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener {

            //tomar datos de los inputs, revisar si el correo no existe antes
            val correo= findViewById<EditText>(R.id.edtCorreo).text.toString()
            val usuario= findViewById<EditText>(R.id.edtUsuario).text.toString()
            val contrasena= findViewById<EditText>(R.id.edtContrasena).text.toString()

            if(correo.isNotEmpty()){
                if(usuario.isNotEmpty()){
                    if(contrasena.isNotEmpty()){
                        val usu= Usuario("",correo,usuario,contrasena)
                        crearUsuario(usu)
                        val intent=(Intent (this,MainActivity::class.java ))

                        startActivity(intent)
                    }else{
                        Toast.makeText(this,"escriba una contraseña",Toast.LENGTH_LONG).show()
                    }
                }else{
                    Toast.makeText(this,"escriba un usuario",Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this,"escriba un correo",Toast.LENGTH_LONG).show()
            }

        }

    }

    private fun crearUsuario(usuario: Usuario){
        val nuevoUsuario=ramaUsuarios.push()
        usuario.id=nuevoUsuario.key ?: ""
        nuevoUsuario.setValue(usuario)

    }
}