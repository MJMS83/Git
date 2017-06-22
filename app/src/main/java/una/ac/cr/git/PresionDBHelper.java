package una.ac.cr.git;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by josue on 10/06/17.
 */

public class PresionDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Presion.db";

    public PresionDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION); //Le pasa el nombre de la base datos y la versión
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PresionContract.SQL_CREATE_ENTRIES);
    }

    @Override //Cuando modifico el esquema de base de datos, estos tienen un número de versión, por ejemplo si agrego un tercer
    //campo en la base de datos, donde se borra la anterior y se crea la nueva tabla
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(PresionContract.SQL_DELETE_ENTRIES); //Se elimina
        onCreate(db); //Se vuelve a crear llamando al onCreate que llama al
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(PresionContract.SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
