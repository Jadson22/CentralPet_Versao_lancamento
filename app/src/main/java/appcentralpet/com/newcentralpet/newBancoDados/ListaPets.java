package appcentralpet.com.newcentralpet.newBancoDados;


import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;

import appcentralpet.com.newcentralpet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaPets extends Fragment implements AdapterView.OnItemClickListener, Serializable{

    ListView listView;

    private DataBase dataBase;
    private SQLiteDatabase conn;
    private RepositorioPet repositorioPet;

    private ArrayAdapter<Pets> adpPet;

    public ListaPets() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_pets, container, false);

        listView = (ListView) view.findViewById(R.id.listView11);

        listView.setOnItemClickListener(this);

        try {
            dataBase = new DataBase(getContext());
            conn = dataBase.getWritableDatabase();

            repositorioPet = new RepositorioPet(conn);

            adpPet = repositorioPet.buscaPet(getContext());

            listView.setAdapter(adpPet);


        }catch (SQLException e){

            AlertDialog.Builder dlg = new AlertDialog.Builder(getContext());
            dlg.setMessage("erro " + e.getMessage());
            dlg.setNeutralButton("Ok", null );
            dlg.show();

        }

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //AQUI ------------------

        CadastroMeusPets cadastroMeusPets = new CadastroMeusPets();
        ListaPets listaPets = new ListaPets();


        Pets pets = adpPet.getItem(position);
        Fragment cadastroMP = new CadastroMeusPets();

        Bundle arguments = new Bundle();
        arguments.putString("PET", pets.toString());
        cadastroMP.setArguments(arguments);

        final FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameprincipal, cadastroMP).commit();


    }
}
