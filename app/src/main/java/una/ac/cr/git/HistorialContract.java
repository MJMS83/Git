package una.ac.cr.git;

import android.provider.BaseColumns;

/**
 * Created by josue on 17/06/17.
 */

public class HistorialContract {
    public static String SQL_CREATE_ENTRIES =
            "CREATE TABLE "+ HistorialEntry.TABLE_NAME + "(" +
                    HistorialEntry.COLUMN_NAME_CONDICION + "PRIMARY KEY "+
                    HistorialEntry.COLUMN_NAME_DIASTOLICA+
                    HistorialEntry.COLUMN_NAME_SISTOLICA +
                    HistorialEntry.COLUMN_NAME_FECHA+
                    HistorialEntry.COLUMN_NAME_Nombre_USUARIO+ "FOREIGN KEY"+
                    "(nombreU)"+"REFERENCES"+"usuario"+"nombre"+"(nombre)"+")";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + HistorialEntry.TABLE_NAME;


    public static class HistorialEntry implements BaseColumns {
        public static String TABLE_NAME = "historial";
        public static String COLUMN_NAME_CONDICION = "condicion";
        public static String COLUMN_NAME_SISTOLICA = "sistolica";
        public static String COLUMN_NAME_DIASTOLICA="diastolica";
        public static String COLUMN_NAME_FECHA="fecha";
        public static String COLUMN_NAME_Nombre_USUARIO="nombreU";
    }
}
