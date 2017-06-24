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
        DBHelperTomas admin = new DBHelperTomas(this, "pressapp2.db", null, 2);
        SQLiteDatabase db = admin.getWritableDatabase();

        registros=db.rawQuery("select * from tomaspresion;", null);

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


                switch (((TomaPresion) activity_historial).getCondicion()) {
                    case "Optima":
                        txtSistolica.setClickable(true);
                        txtSistolica.setBackgroundColor(getResources().getColor(R.color.Normal));
                        txtDiastolica.setBackgroundColor(getResources().getColor(R.color.Normal));
                        txtCondicion.setBackgroundColor(getResources().getColor(R.color.Normal));
                        txtFecha.setBackgroundColor(getResources().getColor(R.color.Normal));


                        break;
                    case "Normal":
                        txtSistolica.setClickable(true);
                        txtSistolica.setBackgroundColor(getResources().getColor(R.color.Normal));
                        txtDiastolica.setBackgroundColor(getResources().getColor(R.color.Normal));
                        txtCondicion.setBackgroundColor(getResources().getColor(R.color.Normal));
                        txtFecha.setBackgroundColor(getResources().getColor(R.color.Normal));

                        break;
                    case "Normal-Alta":
                        txtSistolica.setBackgroundColor(getResources().getColor(R.color.NormalAlta));
                        txtDiastolica.setBackgroundColor(getResources().getColor(R.color.NormalAlta));
                        txtCondicion.setBackgroundColor(getResources().getColor(R.color.NormalAlta));
                        txtFecha.setBackgroundColor(getResources().getColor(R.color.NormalAlta));

                        break;
                    case "Fase 1":
                        txtSistolica.setBackgroundColor(getResources().getColor(R.color.fase1));
                        txtDiastolica.setBackgroundColor(getResources().getColor(R.color.fase1));
                        txtCondicion.setBackgroundColor(getResources().getColor(R.color.fase1));
                        txtFecha.setBackgroundColor(getResources().getColor(R.color.fase1));

                        break;
                    case "Fase 2":
                        txtSistolica.setBackgroundColor(getResources().getColor(R.color.Fase2));
                        txtDiastolica.setBackgroundColor(getResources().getColor(R.color.Fase2));
                        txtCondicion.setBackgroundColor(getResources().getColor(R.color.Fase2));
                        txtFecha.setBackgroundColor(getResources().getColor(R.color.Fase2));

                        break;
                    case "Fase 3":
                        txtSistolica.setBackgroundColor(getResources().getColor(R.color.Fase3));
                        txtDiastolica.setBackgroundColor(getResources().getColor(R.color.Fase3));
                        txtCondicion.setBackgroundColor(getResources().getColor(R.color.Fase3));
                        txtFecha.setBackgroundColor(getResources().getColor(R.color.Fase3));

                        break;
                    case "Sistolica Aislada":
                        txtSistolica.setBackgroundColor(getResources().getColor(R.color.SistoAislada));
                        txtSistolica.setTextColor(getResources().getColor(R.color.Titulo));
                        txtDiastolica.setBackgroundColor(getResources().getColor(R.color.SistoAislada));
                        txtDiastolica.setTextColor(getResources().getColor(R.color.Titulo));
                        txtCondicion.setBackgroundColor(getResources().getColor(R.color.SistoAislada));
                        txtCondicion.setTextColor(getResources().getColor(R.color.Titulo));
                        txtFecha.setBackgroundColor(getResources().getColor(R.color.SistoAislada));
                        txtFecha.setTextColor(getResources().getColor(R.color.Titulo));
                        break;
                }


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
