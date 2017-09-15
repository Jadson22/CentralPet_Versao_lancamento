package appcentralpet.com.newcentralpet.Vacinas;


import android.app.Dialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
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


    public Vacinas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vacinas, container, false);


        return view;
    }

    private void ShowDialogAdd() {

        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.add_vacinas);
        dialog.setTitle("Adicionar");

        //RECUPERANDO OS CAMPOS PARA O BANCO
        final EditText edtVacina = (EditText) dialog.findViewById(R.id.edtVacina);
        final EditText edtData = (EditText) dialog.findViewById(R.id.edtData);
        final EditText edtRetorno = (EditText) dialog.findViewById(R.id.edtRetorno);
        Cursor c = Cadastro.sqLiteHelper.getData("SELECT * FROM PET");
        ArrayAdapter<String> arrID = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line);
        while (c.moveToNext()){
            arrID.add(c.getString(1));
        }
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
        MenuItem item = menu.findItem(R.id.addic);
        item.setVisible(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.addic) {
            ShowDialogAdd();
        }
        return super.onOptionsItemSelected(item);
    }
}
