package una.ac.cr.git;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by WILLIAM on 22/06/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuarios(codigo varchar(25) primary key,usuario varchar(25),contrasena varchar(25));");
        db.execSQL("insert into usuarios values('01','admin','admin')");
        /*db.execSQL("CREATE TABLE usuarios(codigo varchar(25) primary key,usuario varchar(25),contrasena varchar(25),edad varchar(25),peso varchar(25),sexo varchar(25),nombre varchar(25),altura varchar(25));");
        db.execSQL("insert into usuarios values('01','admin','admin','23','65','Masculino','Administrador','1.70');");*/

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       /* db.execSQL("CREATE TABLE usuarios(codigo varchar(25) primary key,usuario varchar(25),contrasena varchar(25),edad varchar(25),peso varchar(25),sexo varchar(25),nombre varchar(25),altura varchar(25));");
        db.execSQL("insert into usuarios values('01','admin','admin','23','65','Masculino','Administrador','1.70');");*/
        db.execSQL("CREATE TABLE usuarios(codigo varchar(25) primary key,usuario varchar(25),contrasena varchar(25));");
        db.execSQL("insert into usuarios values('01','admin','admin')");
    }
}
