package appcentralpet.com.newcentralpet.Vacinas;


import android.app.Dialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import appcentralpet.com.newcentralpet.BancoMeusPets.Pet;
import appcentralpet.com.newcentralpet.BancoMeusPets.PetList;
import appcentralpet.com.newcentralpet.BancoMeusPets.PetListAdapter;
import appcentralpet.com.newcentralpet.BancoMeusPets.SQLiteHelper;
import appcentralpet.com.newcentralpet.MainActivity;
import appcentralpet.com.newcentralpet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Vacinas extends Fragment {

    private Toolbar toolbar_vacinas;
    
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

        toolbar_vacinas = (Toolbar) view.findViewById(R.id.toolbar_vacinas);
        toolbar_vacinas.setTitle("Vacinas");
        
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


        lista = new ArrayList<>();
        Cursor cursor = MainActivity.sqLiteHelper.getData("SELECT name FROM PET");

        //MainActivity.sqLiteHelper.getData("SELECT name = ? FROM PET");

        //final String[] nomes = new String[]{cursor.getString(cursor.getColumnIndex("name"))};

        String[] nomes = new String[] {cursor.toString()};
        //final String[] NOMES = new String[]{c.toString()};

        ArrayAdapter<String> adp = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, nomes );

        AutoCompleteTextView nomepet = (AutoCompleteTextView) dialog.findViewById(R.id.nomePet);
        nomepet.setAdapter(adp);


        int width = (int) (getActivity().getResources().getDisplayMetrics().widthPixels * 0.95);
        int height = (int) (getActivity().getResources().getDisplayMetrics().heightPixels * 0.7);
        dialog.getWindow().setLayout(width, height);
        dialog.show();


    }

}
