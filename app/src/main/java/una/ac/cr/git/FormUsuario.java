package una.ac.cr.git;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class FormUsuario extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    EditText id, correo, txtcontrasena, txtEdad,txtPeso, txtNombre, txtAltura;
    private String selection;
    private int position;

        //FORMULARIO DE USUARIO
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_usuario);

        //SPINNER PARA SELECCIONAR SEXO
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sexo, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //spinner.setOnItemClickListener(this);
        spinner.setOnItemSelectedListener(this);



        id = (EditText) findViewById(R.id.cedula);
        correo = (EditText) findViewById(R.id.email);
        txtcontrasena = (EditText) findViewById(R.id.txtpassword);
        txtEdad = (EditText) findViewById(R.id.txtedad);
        txtPeso = (EditText) findViewById(R.id.txtpeso);
        //Sexo
        txtNombre = (EditText) findViewById(R.id.nomcompleto);
        txtAltura = (EditText) findViewById(R.id.txtaltura);





    }



    public void CancelarRegistro(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void Registrar(View view) {

        DBHelper admin = new DBHelper(this,"pressapp.db",null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = id.getText().toString();
        String usuario = correo.getText().toString();
        String contrasena = txtcontrasena.getText().toString();
        String edad = txtEdad.getText().toString();
        String peso = txtPeso.getText().toString();
        String sexo = selection.toString();
        String nombre = txtNombre.getText().toString();
        String altura = txtAltura.toString();


        ContentValues values = new ContentValues();
        values.put("codigo",codigo);
        values.put("usuario",usuario);
        values.put("contrasena",contrasena);
        values.put("edad",edad);
        values.put("peso",peso);
        values.put("sexo",sexo);
        values.put("nombre", nombre);
        values.put("altura", altura);


        //INSERTAR LOS DATOS A LA TABLA USUARIOS
        db.insert("usuarios",null,values);
        db.close();

       Toast.makeText(getApplicationContext(), "¡Gracias por registrarse!", Toast.LENGTH_LONG).show();


        Intent intent = new Intent(this, Login.class);
        startActivity(intent);



    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Salvar la posición y valor del item actual
        this.position = position;
         selection = parent.getItemAtPosition(position).toString();

        //Mostramos la selección actual del Spinner
        //Toast.makeText(this,"Selección actual: "+selection,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this,"Debe seleccionar un sexo", Toast.LENGTH_SHORT);
    }
}
