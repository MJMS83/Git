package una.ac.cr.git;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }



    public void RegistrarUsuarios(View view) {

        Intent FormularioSiguiente=new Intent(Login.this,FormUsuario.class );
        startActivity(FormularioSiguiente);
    }

    public void Ingresar(View view) {
        //METODO DE VALIDACION DE USUARIOS

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }

    public void CerrarApp(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            finishAffinity();
        }
    }
}
