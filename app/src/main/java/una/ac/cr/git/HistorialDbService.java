package una.ac.cr.git;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by josue on 17/06/17.
 */

public class HistorialDbService {
    HistorialDBHelper historialDBHelper;
    Context context;
    ArrayList<TomaPresion> registroTP = new ArrayList<TomaPresion>();
    SQLiteDatabase db;

    public HistorialDbService(Context context) {
        this.context = context;
        historialDBHelper =new HistorialDBHelper(context);
    }

    /**
     * Guarda o actualiza una canción
     * @param tomaPresion Cancion a ser guardada
     */
    public void save(TomaPresion tomaPresion) { //recibe un registro  para guardarlo o actualizarla

        db= historialDBHelper.getWritableDatabase();
        ContentValues values=new ContentValues();


        //SE VAN A AGREGAR LOS DATOS DEL REGISTRO QUE TRAJE POR PARAMETROS AL CONTENTVALUES
        values.put(HistorialContract.HistorialEntry.COLUMN_NAME_CONDICION,tomaPresion.getCondicion());
        values.put(HistorialContract.HistorialEntry.COLUMN_NAME_SISTOLICA,tomaPresion.getDiastolica());
        values.put(HistorialContract.HistorialEntry.COLUMN_NAME_SISTOLICA,tomaPresion.getDiastolica());
        values.put(HistorialContract.HistorialEntry.COLUMN_NAME_FECHA,tomaPresion.getFechaToma());
        values.put(HistorialContract.HistorialEntry.COLUMN_NAME_Nombre_USUARIO,tomaPresion.getNombreDeUsuario());
        //AHORA SE INSERTARA EL REGISTRO
        db.insert(HistorialContract.HistorialEntry.TABLE_NAME, null, values);

        //else { //La cancion ya existe, debo modificar
        //    db.update(RegistroContract.CancionEntry.TABLE_NAME, values,
        //            RegistroContract.CancionEntry.COLUMN_NAME_MD5+" = ?",
        //            new String[] {juego.getMd5()});
        //}
    }

    /**
     * EN ESTE METODO HAY QUE HACER QUE RETORNE UN ARRAY DE LOS REGISTROS EXISTENTES
     *
     */
    public ArrayList<TomaPresion> cargarRegistros(){

        String nombre,condicion,diastolica,sistolica,fecha;
        db=historialDBHelper.getReadableDatabase();

        Cursor  cursor = db.rawQuery("select * from "+HistorialContract.HistorialEntry.TABLE_NAME+" ORDER BY "+HistorialContract.HistorialEntry.COLUMN_NAME_Nombre_USUARIO+" ASC, "+
                HistorialContract.HistorialEntry.COLUMN_NAME_CONDICION,null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {

                nombre = cursor.getString(cursor.getColumnIndex(HistorialContract.HistorialEntry.COLUMN_NAME_Nombre_USUARIO));
                condicion = cursor.getString(cursor.getColumnIndex(HistorialContract.HistorialEntry.COLUMN_NAME_CONDICION));
                diastolica = cursor.getString(cursor.getColumnIndex(HistorialContract.HistorialEntry.COLUMN_NAME_DIASTOLICA));
                sistolica = cursor.getString(cursor.getColumnIndex(HistorialContract.HistorialEntry.COLUMN_NAME_SISTOLICA));
                fecha =cursor.getString(cursor.getColumnIndex(HistorialContract.HistorialEntry.COLUMN_NAME_FECHA));
                //Instancia un registro
                TomaPresion tp = new TomaPresion(nombre,condicion,diastolica,sistolica,fecha);

                //Añade la instancia al array de registros
                registroTP.add(tp);
                cursor.moveToNext();
            }
        }

        return registroTP;
    }

    public void limpiar(){
        // Define 'where' part of query.
        context.deleteDatabase(historialDBHelper.DATEBASE_NAME);
    }
}