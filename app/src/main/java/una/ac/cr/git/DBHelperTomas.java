package una.ac.cr.git;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by WILLIAM on 23/06/2017.
 */

public class DBHelperTomas extends SQLiteOpenHelper{


    public DBHelperTomas(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE tomaspresion(tsistolica varchar(25),tdiastolica varchar(25),tcondicion varchar(25),tfecha varchar(40))");
        db.execSQL("insert into tomaspresion values('120','80','Normal','20-06-2017')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TABLA DE TOMAS DE PRESION
        db.execSQL("drop table tomaspresion");
        db.execSQL("CREATE TABLE tomaspresion(tsistolica varchar(25),tdiastolica varchar(25),tcondicion varchar(25),tfecha varchar(25))");
        db.execSQL("insert into tomaspresion values('120','80','Normal','20-06-2017')");

    }
}
