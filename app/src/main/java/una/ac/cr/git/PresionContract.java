package una.ac.cr.git;

import android.provider.BaseColumns;

/**
 * Created by josue on 10/06/17.
 */

public class PresionContract {

    public static String SQL_CREATE_ENTRIES =
            //CREATE TABLE cancion (md5 TEXT PRIMARY KEY, valoracion INTEGER)
            "CREATE TABLE " + PresionEntry.TABLE_NAME + " ( " +
                    PresionEntry.COLUM_NAME_CORREO +
                    PresionEntry.COLUMN_NAME_NOMBRE + "PRIMARY KEY," +
                    PresionEntry.COLUMN_NAME_APELLIDO+
                    PresionEntry.COLUMN_NAME_SEXO+
                    PresionEntry.COLUM_NAME_EDAD + "INTEGER"+
                    PresionEntry.COLUM_NAME_ALTURA + "FLOAT"+
                    PresionEntry.COLUM_NAME_PESO + "FLOAT"+
                    PresionEntry.COLUM_NAME_CONTRASENA +"INTEGER)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PresionEntry.TABLE_NAME;


    public static class PresionEntry implements BaseColumns {
        public static String TABLE_NAME = "usuario";
        public static String COLUMN_NAME_NOMBRE = "nombre";
        public static String COLUMN_NAME_APELLIDO = "apellido";
        public static String COLUMN_NAME_SEXO="sexo";
        public static String COLUM_NAME_CORREO="correo";
        public static String COLUM_NAME_PESO="peso";
        public static String COLUM_NAME_ALTURA="altura";
        public static String COLUM_NAME_EDAD="edad";
        public static String COLUM_NAME_CONTRASENA="contrasena";

    }
}
