package appcentralpet.com.newcentralpet.newBancoDados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import appcentralpet.com.newcentralpet.BancoMeusPets.Pet;

/**
 * Created by Jadson on 13/09/2017.
 */
public class RepositorioPet  {

    private SQLiteDatabase conn;

    public RepositorioPet(SQLiteDatabase conn){
        this.conn = conn;
    }

    public void inserir(Pets pets){
        ContentValues values = new ContentValues();
        values.put("name", pets.getName());
        values.put("sexo", pets.getSexo());
        values.put("raca", pets.getRaca());
        values.put("tipo", pets.getTipo());
        values.put("idade", pets.getIdade());
        values.put("image", pets.getImage());

        conn.insertOrThrow("PET", null, values);
    }

    public ArrayAdapter<Pets> buscaPet(Context context){

        ArrayAdapter<Pets> adpPet = new ArrayAdapter<Pets>(context, android.R.layout.simple_list_item_1);

        Cursor cursor = conn.query("PET", null, null, null, null, null, null);

        if(cursor.getCount() > 0 ){

            cursor.moveToFirst();

            do {
                Pets pets = new Pets();
                pets.setId(cursor.getLong(0));
                pets.setName(cursor.getString(1));
                pets.setSexo(cursor.getString(2));
                pets.setRaca(cursor.getString(3));
                pets.setTipo(cursor.getString(4));
                pets.setIdade(cursor.getString(5));
                pets.setImage(cursor.getBlob(6));

                adpPet.add(pets);

            }while (cursor.moveToNext());
        }

        return adpPet;
    }
}
