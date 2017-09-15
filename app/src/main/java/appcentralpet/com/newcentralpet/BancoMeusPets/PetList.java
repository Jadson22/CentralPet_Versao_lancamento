package appcentralpet.com.newcentralpet.BancoMeusPets;


import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;

import appcentralpet.com.newcentralpet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PetList extends Fragment implements Serializable{

    ListView listView;
    ArrayList<Pet> list;
    PetListAdapter adapter = null;

    Pet pet;
    private SQLiteHelper sqLiteHelper;
    private SQLiteDatabase conn;


    public PetList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pet_list, container, false);


        listView = (ListView) view.findViewById(R.id.listView11);
        list = new ArrayList<>();
        adapter = new PetListAdapter(getContext(), R.layout.pet_itens, list);
        listView.setAdapter(adapter);


        Cadastro cadastro= new Cadastro();
        //cadastro.sqLiteHelper.getReadableDatabase();
        //sqLiteHelper.getData("SELECT * FROM PET");

        //sqLiteHelper = new SQLiteHelper(getContext(), "PetDB.sqlite", null, 4);
        //conn = sqLiteHelper.getWritableDatabase();


        cadastro.getActivity();


        Cursor cursor = Cadastro.sqLiteHelper.getData("SELECT * FROM PET");
        list.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String sexo = cursor.getString(2);
            String raca = cursor.getString(3);
            String tipo = cursor.getString(4);
            String idade = cursor.getString(5);
            byte[] image = cursor.getBlob(6);

            list.add(new Pet(id, name, sexo, raca, tipo, idade, image));
        }
        adapter.notifyDataSetChanged();

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {
                CharSequence[] itens = {"Editar", "Excluir"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());

                dialog.setTitle("Alterar");
                dialog.setItems(itens, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int item) {
                        if(item == 0 ){
                            //editar
                            Cursor c = Cadastro.sqLiteHelper.getData("SELECT id FROM PET");
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while (c.moveToNext()){
                                arrID.add(c.getInt(0));
                            }
                            showDialogUpdate(getActivity(), arrID.get(position));

                        }else{
                            //apagar
                            Cursor c = Cadastro.sqLiteHelper.getData("SELECT id FROM PET");
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while (c.moveToNext()){
                                arrID.add(c.getInt(0));
                            }
                            showDialogDelete(arrID.get(position));
                        }
                    }
                });
                dialog.show();
                return true;
            }
        });

        return view;
    }


    ImageView imgPet;
    RadioGroup upradioSexo, upradioTipo;
    RadioButton rbSexoEscolhido, rbTipoEscolhido;

    private void showDialogUpdate(Activity activity, final int position){

        final Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.editar_pet);
        dialog.setTitle("Editar");

        imgPet = (ImageView) dialog.findViewById(R.id.upfoto);
        final EditText edtName = (EditText) dialog.findViewById(R.id.upnome);
        final EditText edtRaca = (EditText) dialog.findViewById(R.id.upraca);
        final EditText edtIdade = (EditText) dialog.findViewById(R.id.upidade);

        upradioSexo = (RadioGroup) dialog.findViewById(R.id.upradioSexo);
        upradioTipo = (RadioGroup) dialog.findViewById(R.id.upradioTipo);

        int idRbSexoEscolhido = upradioSexo.getCheckedRadioButtonId();
        if(idRbSexoEscolhido > 0 ){
            rbSexoEscolhido = (RadioButton) dialog.findViewById(idRbSexoEscolhido);
        }

        int idRbTipoEscolhido = upradioTipo.getCheckedRadioButtonId();
        if(idRbTipoEscolhido > 0 ){
            rbTipoEscolhido = (RadioButton) dialog.findViewById(idRbTipoEscolhido);
        }

        Button btnUpdate = (Button) dialog.findViewById(R.id.btn_up);

        //tamanho da caixa dialog
        int width = (int) (activity.getResources().getDisplayMetrics().widthPixels * 0.95);
        int height = (int) (activity.getResources().getDisplayMetrics().heightPixels * 0.7);
        dialog.getWindow().setLayout(width, height);
        dialog.show();

        imgPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // request photo library
                requestPermissions(
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        888
                );
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(edtName.getText().toString().length() == 0 ){
                        edtName.setError("Digite um nome");
                    }else {
                        Cadastro.sqLiteHelper.updateData(
                                edtName.getText().toString().trim(),
                                rbSexoEscolhido.getText().toString().trim(),
                                edtRaca.getText().toString().trim(),
                                rbTipoEscolhido.getText().toString().trim(),
                                edtIdade.getText().toString().trim(),
                                Cadastro.imageViewToByte(imgPet),
                                position
                        );
                        dialog.dismiss();
                        Snackbar snackbar = Snackbar.make(getView(), "Editado com sucesso!", Snackbar.LENGTH_SHORT);
                        snackbar.show();
                    }
                }catch (Exception error) {
                    Log.e("Update error", error.getMessage());
                }
                editarPet();

            }
        });
    }

    private void showDialogDelete(final int idPet){
        final AlertDialog.Builder dialogDelete = new AlertDialog.Builder(getContext());

        dialogDelete.setTitle("Atenção!");
        dialogDelete.setMessage("Apagar Pet?");
        dialogDelete.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    Cadastro.sqLiteHelper.deleteData(idPet);
                    Snackbar snackbar = Snackbar.make(getView(), "Excluido com sucesso!", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                } catch (Exception e){
                    Log.e("error", e.getMessage());
                }
                editarPet();
            }
        });

        dialogDelete.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogDelete.show();
    }

    private void editarPet(){
        // get all data from sqlite
        Cursor cursor = Cadastro.sqLiteHelper.getData("SELECT * FROM PET");
        list.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String raca = cursor.getString(3);
            String idade = cursor.getString(5);

            String sexo = cursor.getString(2);
            String tipo = cursor.getString(4);

            byte[] image = cursor.getBlob(6);

            list.add(new Pet(id, name, sexo, raca, tipo, idade, image));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == 888){
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 888);
            }
            else {
                Snackbar snackbar = Snackbar.make(getView(), "Você não tem permissão para acessar os arquivos!", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 888 && resultCode == getActivity().RESULT_OK && data != null){
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContext().getContentResolver().openInputStream(uri);

                Glide.with(this)
                        .load(uri)
                        .asBitmap()
                        .centerCrop()
                        .into(imgPet);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

}
