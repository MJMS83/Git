package una.ac.cr.git;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by josue on 17/06/17.
 */

public class PerfilDbService {
    Context context;
    PresionDBHelper presionDBHelper;
    ArrayList<perfil_de_Usuario> registrosUsuarios = new ArrayList<perfil_de_Usuario>();
    SQLiteDatabase db;

    public PerfilDbService(Context context) {
        this.context = context;
        presionDBHelper =new PresionDBHelper(context);
    }

    /**
     * Guarda o actualiza una canción
     * @param perfil_de_usuario Cancion a ser guardada
     */
    public void save(perfil_de_Usuario perfil_de_usuario) { //recibe un registro  para guardarlo o actualizarla

        db= presionDBHelper.getWritableDatabase();
        ContentValues values=new ContentValues();

        //SE VAN A AGREGAR LOS DATOS DEL REGISTRO QUE TRAJE POR PARAMETROS AL CONTENTVALUES
        values.put(PresionContract.PresionEntry.COLUMN_NAME_NOMBRE,perfil_de_usuario.getNombre());
        values.put(PresionContract.PresionEntry.COLUMN_NAME_APELLIDO,perfil_de_usuario.getApellido());
        values.put(PresionContract.PresionEntry.COLUM_NAME_EDAD,perfil_de_usuario.getEdad());
        values.put(PresionContract.PresionEntry.COLUM_NAME_PESO,perfil_de_usuario.getPeso());
        values.put(PresionContract.PresionEntry.COLUM_NAME_ALTURA,perfil_de_usuario.getAltura());
        values.put(PresionContract.PresionEntry.COLUMN_NAME_SEXO,perfil_de_usuario.getSexo());
        values.put(PresionContract.PresionEntry.COLUM_NAME_CORREO,perfil_de_usuario.getCorreo());
        values.put(PresionContract.PresionEntry.COLUM_NAME_CONTRASENA,perfil_de_usuario.getContrasena());
        //AHORA SE INSERTARA EL REGISTRO
        db.insert(PresionContract.PresionEntry.TABLE_NAME, null, values);

    }

    /**
     * EN ESTE METODO HAY QUE HACER QUE RETORNE UN ARRAY DE LOS REGISTROS EXISTENTES
     *
     */
    public ArrayList<perfil_de_Usuario> cargarRegistros(){

        String nombre,apellido,edad,peso,altura,sexo,correo,contrasena;
        db=presionDBHelper.getReadableDatabase();

        Cursor  cursor = db.rawQuery("select * from "+ PresionContract.PresionEntry.TABLE_NAME+" ORDER BY "+ PresionContract.PresionEntry.COLUMN_NAME_NOMBRE+" ASC, "+ PresionContract.PresionEntry.COLUM_NAME_EDAD,null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {

                nombre = cursor.getString(cursor.getColumnIndex(PresionContract.PresionEntry.COLUMN_NAME_NOMBRE));
                apellido = cursor.getString(cursor.getColumnIndex(PresionContract.PresionEntry.COLUMN_NAME_APELLIDO));
                edad = cursor.getString(cursor.getColumnIndex(PresionContract.PresionEntry.COLUM_NAME_EDAD));
                altura=cursor.getString(cursor.getColumnIndex(PresionContract.PresionEntry.COLUM_NAME_ALTURA));
                peso=cursor.getString(cursor.getColumnIndex(PresionContract.PresionEntry.COLUM_NAME_PESO));
                sexo=cursor.getString(cursor.getColumnIndex(PresionContract.PresionEntry.COLUMN_NAME_SEXO));
                correo=cursor.getString(cursor.getColumnIndex(PresionContract.PresionEntry.COLUM_NAME_CORREO));
                contrasena=cursor.getString(cursor.getColumnIndex(PresionContract.PresionEntry.COLUM_NAME_CONTRASENA));
                //Instancia un registro
                perfil_de_Usuario pU = new perfil_de_Usuario(nombre,apellido,correo,contrasena,edad,altura,peso,sexo);

                //Añade la instancia al array de registros
                registrosUsuarios.add(pU);
                cursor.moveToNext();
            }
        }

        return registrosUsuarios;
    }
public void limpiar(){
        // Define 'where' part of query.
        context.deleteDatabase(presionDBHelper.DATABASE_NAME);
    }
}


