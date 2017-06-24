package una.ac.cr.git;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PerfilUsuario extends AppCompatActivity {
    TextView nombre,edad,peso,altura,sexo,clave;
    private Cursor fil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        Toolbar toolbar;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        nombre= (TextView)findViewById(R.id.txtNombre);
        edad=(TextView)findViewById(R.id.txtEdad);
        peso=(TextView)findViewById(R.id.txtPeso);
        altura=(TextView)findViewById(R.id.txtAltura);
        sexo=(TextView)findViewById(R.id.txtSexo);
        clave=(TextView)findViewById(R.id.txtClave);
        setSupportActionBar(toolbar);

    }

    public  void MostrarDatos(View v) {
        DBHelper admin = new DBHelper(this, "pressapp.db", null, 1);
        SQLiteDatabase db = admin.getReadableDatabase();
        String usuario = nombre.getText().toString();
        String contrasena = clave.getText().toString();
        fil = db.rawQuery("select usuario,contrasena from usuarios where usuario='" + usuario + "' " +
                "and contrasena='" + contrasena + "'", null);


        if (fil.moveToFirst()) {
            String usua = fil.getString(0);
            String pass = fil.getString(1);

            if (usuario.equals(usua) && contrasena.equals(pass)) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                nombre.getText();
                edad.getText();
                peso.getText();
                altura.getText();
                sexo.getText();
                clave.getText();

            } else {

                Toast.makeText(getApplicationContext(), "¡No hay datos del usuario!", Toast.LENGTH_LONG).show();
            }

        }
    }
     /*MENU PRINCIPAL*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.tomas:
                Tomas();
                return true;
            case R.id.perfilUsuarios:
                PerfilDeUsuarios();
                return true;
            case R.id.historialTomas:
                HistorialDeTomas();
                return true;
            case R.id.tipsSalud:
                TipsDeSalud();
                return true;
            case R.id.numEmergencias:
                NumDeEmergencias();
                return true;
            case R.id.acercaDe:
                AcercaDe();
                return true;
            case R.id.cerrar:
                CerrarApp();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void Tomas() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void NumDeEmergencias() {
        Intent intent = new Intent(this,NumEmergencias.class);
        startActivity(intent);
    }

    private void HistorialDeTomas() {
        Intent intent = new Intent(this,HistorialTomas.class);
        startActivity(intent);
    }

    private void TipsDeSalud() {
        Intent intent = new Intent(this,TipsSalud.class);
        startActivity(intent);
    }

    private void PerfilDeUsuarios() {

    }

    private void AcercaDe() {
        Intent intent = new Intent(this,Acerca.class);
        startActivity(intent);
    }


    private void CerrarApp() {
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }


}
