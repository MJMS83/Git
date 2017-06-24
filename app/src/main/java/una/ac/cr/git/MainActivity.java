package una.ac.cr.git;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    //La pantalla principal es la de tomas de presion
    TextView sistolica;
    TextView diastolica;
    TextView fecha;
    ListView lista;
    Button calcular;

    //PARA OBTENER LA FECHA ACUAL
    final Calendar calendar = Calendar.getInstance();
    int anio = calendar.get(Calendar.YEAR);
    int mes = calendar.get(Calendar.MONTH);
    int dia = calendar.get(Calendar.DAY_OF_MONTH);

    final ArrayList<TomaPresion> datos = new ArrayList<>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sistolica = (TextView) findViewById(R.id.txtSistolica);
        diastolica = (TextView) findViewById(R.id.txtDiastolica);
        fecha = (TextView) findViewById(R.id.txtFecha);
        lista = (ListView) findViewById(R.id.ListViewTomas);
        calcular = (Button) findViewById(R.id.calcular);

        //PARTE DE LA FECHA
        mes = mes + 1;
        fecha.setText(dia + "/" + mes + "/" + anio);


        lista.setAdapter(new Lista_Adaptador(this, R.layout.entrada, datos) {
            @Override
            public void onEntrada(Object activity_main, View view) {
                TextView txtsistolica = (TextView) view.findViewById(R.id.ViewSistolica);
                txtsistolica.setText(((TomaPresion) activity_main).getSistolica());

                TextView txtDiastolica = (TextView) view.findViewById(R.id.ViewDiastolica);
                txtDiastolica.setText(((TomaPresion) activity_main).getDiastolica());

                TextView txtCondicion = (TextView) view.findViewById(R.id.ViewCondicion);
                txtCondicion.setText(((TomaPresion) activity_main).getCondicion());


                switch (((TomaPresion) activity_main).getCondicion()) {
                    case "Optima":
                        txtsistolica.setClickable(true);
                        txtsistolica.setBackgroundColor(getResources().getColor(R.color.Normal));
                        txtDiastolica.setBackgroundColor(getResources().getColor(R.color.Normal));
                        txtCondicion.setBackgroundColor(getResources().getColor(R.color.Normal));
                        // Toast.makeText(getApplicationContext(), "¡La condición de su presión es: "+Condicion()+"! Visita nuestros tips de salud, para seguir con una buena presión arterial.", Toast.LENGTH_LONG).show();


                        break;
                    case "Normal":
                        txtsistolica.setClickable(true);
                        txtsistolica.setBackgroundColor(getResources().getColor(R.color.Normal));
                        txtDiastolica.setBackgroundColor(getResources().getColor(R.color.Normal));
                        txtCondicion.setBackgroundColor(getResources().getColor(R.color.Normal));

                        break;
                    case "Normal-Alta":
                        txtsistolica.setBackgroundColor(getResources().getColor(R.color.NormalAlta));
                        txtDiastolica.setBackgroundColor(getResources().getColor(R.color.NormalAlta));
                        txtCondicion.setBackgroundColor(getResources().getColor(R.color.NormalAlta));

                        break;
                    case "Fase 1":
                        txtsistolica.setBackgroundColor(getResources().getColor(R.color.fase1));
                        txtDiastolica.setBackgroundColor(getResources().getColor(R.color.fase1));
                        txtCondicion.setBackgroundColor(getResources().getColor(R.color.fase1));

                        break;
                    case "Fase 2":
                        txtsistolica.setBackgroundColor(getResources().getColor(R.color.Fase2));
                        txtDiastolica.setBackgroundColor(getResources().getColor(R.color.Fase2));
                        txtCondicion.setBackgroundColor(getResources().getColor(R.color.Fase2));

                        break;
                    case "Fase 3":
                        txtsistolica.setBackgroundColor(getResources().getColor(R.color.Fase3));
                        txtDiastolica.setBackgroundColor(getResources().getColor(R.color.Fase3));
                        txtCondicion.setBackgroundColor(getResources().getColor(R.color.Fase3));

                        break;
                    case "Sistolica Aislada":
                        txtsistolica.setBackgroundColor(getResources().getColor(R.color.SistoAislada));
                        txtsistolica.setTextColor(getResources().getColor(R.color.Titulo));
                        txtDiastolica.setBackgroundColor(getResources().getColor(R.color.SistoAislada));
                        txtDiastolica.setTextColor(getResources().getColor(R.color.Titulo));
                        txtCondicion.setBackgroundColor(getResources().getColor(R.color.SistoAislada));
                        txtCondicion.setTextColor(getResources().getColor(R.color.Titulo));
                        break;
                }

            }
        });

        lista.clearAnimation();

    }//FINAL ONCREATE


    public String Condicion() {

         /*Convertir los valores del testview a enteros*/
        int sisto = sistolica.getText().toString() != null && !sistolica.getText().toString().equals("") ? Integer.parseInt(sistolica.getText().toString()) : -1;
        int diasto = sistolica.getText().toString() != null && !diastolica.getText().toString().equals("") ? Integer.parseInt(diastolica.getText().toString()) : -1;

        for (int i = 0; i < 3; i++) {
            if ((sisto < 0) && (diasto < 0)) {
                return "Vacio";
            } else if ((sisto < 120) && (diasto < 80)) {
                // BackgroundColorSpan b = new BackgroundColorSpan(color);
                return "Optima";
            } else /*NORMAL*/ {
                if ((sisto < 130 && sisto >= 120) && (diasto >= 80 && diasto < 85)) {
                    return "Normal";

                } else /*NORMAL-ALTA*/
                    if ((sisto >= 130 && sisto < 140) && (diasto >= 85 && diasto < 90)) {
                        return "Normal-Alta";
                    } else /*GRADO1*/
                        if ((sisto >= 140 && sisto < 160) && (diasto >= 90 && diasto < 100)) {
                            return "Fase 1";
                        } else /*GRADO2*/
                            if ((sisto >= 160 && sisto < 180) && (diasto >= 100 && diasto < 109)) {
                                return "Fase 2";
                            } else
                            /*GRADO3*/
                                if ((sisto >= 180) && (diasto >= 110)) {
                                    return "Fase 3";
                                } else /*SISTOLICA AISLADA*/
                                    if ((sisto >= 140) && (diasto < 90)) {
                                        return "Sistolica Aislada";
                                    } else { /*MUESTRA UN ERROR SI NO SE DAN LAS CONDICIONES*/
                                        return "Error";
                                    }
            }
        }
        return "";
    }


    /*MENU PRINCIPAL*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
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
        //Vacío porque ya está en la pantalla de tomas
        /*Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);*/
    }

    private void NumDeEmergencias() {
        Intent intent = new Intent(this, NumEmergencias.class);
        startActivity(intent);
    }

    private void HistorialDeTomas() {
        Intent intent = new Intent(this, HistorialTomas.class);
        startActivity(intent);
    }

    private void TipsDeSalud() {
        Intent intent = new Intent(this, TipsSalud.class);
        startActivity(intent);
    }

    private void PerfilDeUsuarios() {
        Intent intent = new Intent(this, PerfilUsuario.class);
        startActivity(intent);
    }

    private void AcercaDe() {
        Intent intent = new Intent(this, Acerca.class);
        startActivity(intent);
    }


    private void CerrarApp() {
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            finishAffinity();
        }*/
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }


    public void IngresarTomas(View view) {
        if (Condicion() == "Vacio") {
            Toast toast1 = Toast.makeText(getApplicationContext(), "Ha dejado campos vacíos", Toast.LENGTH_SHORT);
            toast1.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);
            toast1.show();
        } else if (Condicion() == "Error") {
            Toast toast1 = Toast.makeText(getApplicationContext(), "Los datos son incorrectos", Toast.LENGTH_SHORT);
            toast1.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);
            toast1.show();
        } else {

            datos.add(new TomaPresion(sistolica.getText().toString(), diastolica.getText().toString(), Condicion(), fecha.getText().toString()));
            //Ocultar el boton para que pueda ingresar solo una vez los datos
            calcular.setVisibility(View.INVISIBLE);

            //OCULTA EL TECLADO AL DAR CLIC
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);


            Toast.makeText(getApplicationContext(), "¡La condición de su presión es: " + Condicion() + "! Visita nuestros tips de salud, para tener una buena presión arterial.", Toast.LENGTH_LONG).show();

            //BASE DE DATOS
            DBHelperTomas admin = new DBHelperTomas(this, "pressapp2.db", null, 2);
            SQLiteDatabase db = admin.getWritableDatabase();

            String tsistolica = sistolica.getText().toString();
            String tdiastolica = diastolica.getText().toString();
            String tcondicion = Condicion();
            String tfecha = fecha.getText().toString();

            ContentValues values = new ContentValues();
            values.put("tsistolica",tsistolica);
            values.put("tdiastolica",tdiastolica);
            values.put("tcondicion", tcondicion);
            values.put("tfecha",tfecha);

            db.insert("tomaspresion",null,values);
            //db.close();

            Toast.makeText(getApplicationContext(), "¡Su registro ha sido guardado con éxito!", Toast.LENGTH_LONG).show();



        }



    }
}
