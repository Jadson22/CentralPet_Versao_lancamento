package appcentralpet.com.newcentralpet.Vacinas;


import android.app.Dialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import appcentralpet.com.newcentralpet.BancoMeusPets.Cadastro;
import appcentralpet.com.newcentralpet.BancoMeusPets.Pet;
import appcentralpet.com.newcentralpet.BancoMeusPets.PetList;
import appcentralpet.com.newcentralpet.BancoMeusPets.PetListAdapter;
import appcentralpet.com.newcentralpet.BancoMeusPets.SQLiteHelper;
import appcentralpet.com.newcentralpet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Vacinas extends Fragment {

    private Button btnAdd;

    ArrayList<Pet> lista;
    PetListAdapter adapterr = null;



    public Vacinas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vacinas, container, false);

        btnAdd = (Button) view.findViewById(R.id.btnadicionar);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialogAdd();
            }
        });
        
        
        return view;
    }

    private void ShowDialogAdd() {

        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.add_vacinas);
        dialog.setTitle("Adicionar");

        //final AutoCompleteTextView edtNome = (AutoCompleteTextView) dialog.findViewById(R.id.nomePet);
        final EditText edtVacina = (EditText) dialog.findViewById(R.id.edtVacina);
        final EditText edtData = (EditText) dialog.findViewById(R.id.edtData);
        final EditText edtRetorno = (EditText) dialog.findViewById(R.id.edtRetorno);

        Button btnAdd = (Button) dialog.findViewById(R.id.btnAdd);


       // lista = new ArrayList<>();
        Cursor cursor = Cadastro.sqLiteHelper.getData("SELECT name FROM PET");


        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables("PET");

        //Cursor cursor1 = queryBuilder.query(Cadastro.sqLiteHelper.getReadableDatabase(""));

        Cursor c = Cadastro.sqLiteHelper.getData("SELECT * FROM PET");

        ArrayAdapter<String> arrID = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line);
        while (c.moveToNext()){
            arrID.add(c.getString(1));
            //arrID.add(Cadastro.sqLiteHelper.getReadableDatabase().toString());
        }

       // final String[] nomes = new String[]{cursor.getString(cursor.getColumnIndex("name"))};

        String[] nomes = new String[] {cursor.toString()};
        //final String[] NOMES = new String[]{c.toString()};

        ArrayAdapter<Pet> adp = new ArrayAdapter<Pet>(getContext(), android.R.layout.simple_dropdown_item_1line);
        AutoCompleteTextView nomepet = (AutoCompleteTextView) dialog.findViewById(R.id.nomePet);
        nomepet.setAdapter(arrID);


        int width = (int) (getActivity().getResources().getDisplayMetrics().widthPixels * 0.95);
        int height = (int) (getActivity().getResources().getDisplayMetrics().heightPixels * 0.7);
        dialog.getWindow().setLayout(width, height);
        dialog.show();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_meuspets, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.adicionar);
        item.setVisible(false);
    }


}
