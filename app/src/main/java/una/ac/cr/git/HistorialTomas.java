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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HistorialTomas extends AppCompatActivity {
    ListView lista;
    private Cursor registros;
    //ArrayAdapter adapter;
   // ArrayList item;

    final ArrayList<TomaPresion> datos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_tomas);

        Toolbar toolbar;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lista = (ListView) findViewById(R.id.listaTomas);

        //DBHelper admin = new DBHelper(this, "pressapp.db", null, 1);

       // lista = admin.llenar_lv();
        //adapter = new ArrayAdapter(this, R.layout.lista_historial_tomas,lista);
       // listView.setAdapter(adapter);
       conexionDatos();


    }


    private void conexionDatos(){
        DBHelperTomas admin = new DBHelperTomas(this, "pressapp.db", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        registros=db.rawQuery("select * from tomas;", null);

        /*String q = "select * from tomas;";
        Cursor registros = db.rawQuery(q,null);*/
        String sis = "",dias="",con="",fec="";

          if (registros.moveToFirst()){
            do {
                sis = registros.getString(0);//sistolica
                dias = registros.getString(1);//diastolica
                con = registros.getString(2);//condicion
                fec = registros.getString(3);//fecha

                datos.add(new TomaPresion(sis,dias,con,fec));


            }while (registros.moveToNext());
        }


        lista.setAdapter(new Lista_Adaptador(this,R.layout.lista_historial_tomas, datos) {
            @Override
            public void onEntrada(Object activity_historial, View view) {
                TextView txtSistolica = (TextView) view.findViewById(R.id.textSistolica);
                txtSistolica.setText(((TomaPresion) activity_historial).getSistolica());

                TextView txtDiastolica = (TextView) view.findViewById(R.id.textDiastolica);
                txtDiastolica.setText(((TomaPresion) activity_historial).getDiastolica());

                TextView txtCondicion = (TextView) view.findViewById(R.id.textCondicion);
                txtCondicion.setText(((TomaPresion) activity_historial).getCondicion());

                TextView txtFecha = (TextView) view.findViewById(R.id.textFecha);
                txtFecha.setText(((TomaPresion) activity_historial).getFechaToma());

            }
        });


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
        Intent intent = new Intent(this,Acerca.class);
        startActivity(intent);
    }


    private void CerrarApp() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            finishAffinity();
        }
    }


}
