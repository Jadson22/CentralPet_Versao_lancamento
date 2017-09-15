package appcentralpet.com.newcentralpet.Vacinas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by Jadson on 15/09/2017.
 */
public class SQLiteHelperVacinas extends SQLiteOpenHelper {

    public SQLiteHelperVacinas(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL(sql);
    }

    public void insertData(String nomePet, String nomeVacina, String pData, String sData){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "INSERT INTO VACINAS VALUES (NULL, ?, ?, ?, ?)";

        SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, nomePet);
        statement.bindString(2, nomeVacina);
        statement.bindString(3, pData);
        statement.bindString(4, sData);

        statement.executeInsert();
    }

    public void updateData( String nomePet, String nomeVacina, String pData, String sData, int id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        String sql = "UPDATE VACINAS SET nome = ?, vacina = ?, pdata = ?, sdata = ? WHERE id = ?";
        SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);

        statement.bindString(1, nomePet);
        statement.bindString(2, nomeVacina);
        statement.bindString(3, pData);
        statement.bindString(4, sData);
        statement.bindDouble(5, (double)id);

        statement.execute();
        sqLiteDatabase.close();
    }

    public void deleteData(int id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        String sql = "DELETE FROM VACINAS WHERE id = ?";
        SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double)id);

        statement.execute();
        statement.close();
    }

    public Cursor getData(String sql){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
