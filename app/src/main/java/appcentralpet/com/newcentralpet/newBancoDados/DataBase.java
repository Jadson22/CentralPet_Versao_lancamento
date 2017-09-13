package appcentralpet.com.newcentralpet.newBancoDados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jadson on 13/09/2017.
 */
public class DataBase extends SQLiteOpenHelper {

    public DataBase(Context context){
        super(context, "PET", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ScriptSQL.getCreatePet());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
