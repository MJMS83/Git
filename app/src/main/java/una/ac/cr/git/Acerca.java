package una.ac.cr.git;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Acerca extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca);

        Toolbar toolbar;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
        Intent intent = new Intent(this,PerfilUsuario.class);
        startActivity(intent);
    }

    private void AcercaDe() {

    }


    private void CerrarApp() {
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }


}
