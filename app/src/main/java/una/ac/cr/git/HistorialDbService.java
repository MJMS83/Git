package una.ac.cr.git;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by josue on 17/06/17.
 */

public class HistorialDbService {
    Context context;
    HistorialDBHelper historialDBHelper;

    public HistorialDbService(Context context, HistorialDBHelper historialDBHelper) {
        this.context = context;
        this.historialDBHelper = historialDBHelper;
    }
    public void save(historial_tomas historial_tomas){
        SQLiteDatabase db = historialDBHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(HistorialContract.HistorialEntry.COLUMN_NAME_CONDICION,historial_tomas.getCondicion());
        values.put(HistorialContract.HistorialEntry.COLUMN_NAME_DIASTOLICA,historial_tomas.getDiastolica());
        values.put(HistorialContract.HistorialEntry.COLUMN_NAME_SISTOLICA,historial_tomas.getSistolica());

        if (consultarCondicion(historial_tomas.getCondicion())) {
            db.insert(HistorialContract.HistorialEntry.TABLE_NAME, null, values);
        } else {
            db.update(HistorialContract.HistorialEntry.TABLE_NAME,
                    values,
                    HistorialContract.HistorialEntry.COLUMN_NAME_CONDICION +" = ?",
                    new String[]{});
        }
    }

    /*
    * Condicion a ser buscada
    * return false si no existe la condicion de la toma de presion
     */
    public boolean consultarCondicion(String condicion) {
        SQLiteDatabase db = historialDBHelper.getReadableDatabase();
        //select valoracion from cancion where md5 = ?

        //Columnas a seleccionar
        String[] columnas = {HistorialContract.HistorialEntry.COLUMN_NAME_CONDICION};

        //Filtros del sql -> where md5 = ?
        String filtros = HistorialContract.HistorialEntry.COLUMN_NAME_CONDICION + " = ?";
        String[] valoresFiltro = {condicion};

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