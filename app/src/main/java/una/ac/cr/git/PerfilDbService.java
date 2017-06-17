package una.ac.cr.git;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by josue on 17/06/17.
 */

public class PerfilDbService {
    Context context;
    PresionDBHelper presionDBHelper;

    public PerfilDbService(Context context, PresionDBHelper presionDBHelper) {
        this.context = context;
        this.presionDBHelper = presionDBHelper;
    }

    public void save(perfil_de_Usuario perfil_de_usuario) {

        SQLiteDatabase db = presionDBHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(PresionContract.PresionEntry.COLUM_NAME_CONTRASENA,perfil_de_usuario.getCorreo());
        values.put(PresionContract.PresionEntry.COLUMN_NAME_NOMBRE,perfil_de_usuario.getNombre());
        values.put(PresionContract.PresionEntry.COLUMN_NAME_APELLIDO,perfil_de_usuario.getApellido());
        values.put(PresionContract.PresionEntry.COLUMN_NAME_SEXO,perfil_de_usuario.getSexo());
        values.put(PresionContract.PresionEntry.COLUM_NAME_EDAD,perfil_de_usuario.getEdad());
        values.put(PresionContract.PresionEntry.COLUM_NAME_PESO,perfil_de_usuario.getPeso());
        values.put(PresionContract.PresionEntry.COLUM_NAME_ALTURA,perfil_de_usuario.getAltura());
        if (consultarNombre(perfil_de_usuario.getNombre())) {
            db.insert(PresionContract.PresionEntry.TABLE_NAME, null, values);
        } else {
            db.update(PresionContract.PresionEntry.TABLE_NAME,
                    values,
                    PresionContract.PresionEntry.COLUMN_NAME_NOMBRE +" = ?",
                    new String[]{});
        }
    }

    /*
    * Nombre del usuario
    * return false si no existe el nombre  del usuario
     */
    public boolean consultarNombre(String nombre) {
        SQLiteDatabase db = presionDBHelper.getReadableDatabase();
        //select valoracion from cancion where md5 = ?

        //Columnas a seleccionar
        String[] columnas = {PresionContract.PresionEntry.COLUMN_NAME_NOMBRE};

        //Filtros del sql -> where md5 = ?
        String filtros = PresionContract.PresionEntry.COLUMN_NAME_NOMBRE + " = ?";
        String[] valoresFiltro = {nombre};

        Cursor c = db.query(
                PresionContract.PresionEntry.TABLE_NAME,
                columnas,
                filtros,
                valoresFiltro,
                null, //group by
                null, //filtros por grupo
                null //Orden
        );

        if (c != null) {
            c.moveToFirst();
            //return c.getFloat(0);
        } else {
            return false;
        }

        return false;
    }
}


