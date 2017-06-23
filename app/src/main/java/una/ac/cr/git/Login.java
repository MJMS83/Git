package una.ac.cr.git;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText correo, txtcontrasena;
    private Cursor fila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        correo = (EditText) findViewById(R.id.TextCorreo);
        txtcontrasena = (EditText) findViewById(R.id.TextContrasena);

    }



    public void RegistrarUsuarios(View view) {

        Intent FormularioSiguiente=new Intent(Login.this,FormUsuario.class );
        startActivity(FormularioSiguiente);
    }



    public void CerrarApp(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            finishAffinity();
        }
    }

    public void IngresarApp(View v){
        DBHelper admin = new DBHelper(this, "pressapp.db", null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String usuario=correo.getText().toString();
        String contrasena= txtcontrasena.getText().toString();
        fila=db.rawQuery("select usuario,contrasena from usuarios where usuario='"+usuario+"' and contrasena='"+contrasena+"'", null);
       // fila=db.rawQuery("select * from usuarios where usuario='"+usuario+"' and contrasena='"+contrasena+"'", null);

        if (fila.moveToFirst()==true){
            String usua=fila.getString(0);
            String pass=fila.getString(1);

            if (usuario.equals(usua)&&contrasena.equals(pass)){
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                correo.setText("");
                txtcontrasena.setText("");
            }else {

                Toast.makeText(getApplicationContext(), "¡Usuario o contraseña incorrectos!", Toast.LENGTH_LONG).show();
            }

        }else{Toast.makeText(getApplicationContext(), "¡Usuario o contraseña incorrectos!", Toast.LENGTH_LONG).show();}



    }

}
