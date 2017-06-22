package una.ac.cr.git;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by josue on 17/06/17.
 */

public class HistorialDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATEBASE_NAME = "Presion.db";

    public HistorialDBHelper(Context context) {
        super(context, DATEBASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(HistorialContract.SQL_CREATE_ENTRIES);
    }

    @Override //Cuando modifico el esquema de base de datos, estos tienen un número de versión, por ejemplo si agrego un tercer
    //campo en la base de datos, donde se borra la anterior y se crea la nueva tabla
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(HistorialContract.SQL_DELETE_ENTRIES); //Se elimina
        onCreate(db); //Se vuelve a crear llamando al onCreate que llama al
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(HistorialContract.SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
