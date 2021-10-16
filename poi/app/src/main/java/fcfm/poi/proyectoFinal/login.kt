package fcfm.poi.proyectoFinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.fcfm.poi.MainActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import fcfm.poi.proyectoFinal.clases.Usuario

class login : AppCompatActivity() {

    private val dataBase= FirebaseDatabase.getInstance()
    private val ramaUsuarios=dataBase.getReference("usuarios")

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
            //tomar valores para revisar si existe en la base de datos
            val correo= findViewById<EditText>(R.id.edtUsuario).text.toString()
            val contra= findViewById<EditText>(R.id.edtContrasena).text.toString()

            if (correo.isNotEmpty()&&contra.isNotEmpty()) {
                ramaUsuarios.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        //var existe = false
                        for (snap in snapshot.children){
                            val usuario: Usuario = snap.getValue(Usuario::class.java)as Usuario
                            if (correo==usuario.correo&&contra==usuario.contrasena){
                                //si los datos de las variables coinciden con las de la base de datos entra

                                //hay que hacer un if solo si existe el usuario


                                val intentoIntent=(Intent(this@login,fcfm.poi.proyectoFinal.MainActivity::class.java))
                                startActivity(intent)
                                intentoIntent.putExtra("idUsuario",usuario.id)
                                intentoIntent.putExtra("nombreUsuario",usuario.nombreUsuario)
                                intentoIntent.putExtra("correo",usuario.correo)
                                startActivity(intentoIntent)
                            }
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(this@login,"ocurrio un error, espera un momento",Toast.LENGTH_SHORT).show()
                    }
                })




            }


        }
    }
}