package appcentralpet.com.newcentralpet.newBancoDados;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import appcentralpet.com.newcentralpet.BancoMeusPets.SQLiteHelper;
import appcentralpet.com.newcentralpet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CadastroMeusPets extends Fragment {

    EditText edtName, edtRaca, edtIdade;
    RadioGroup radioGroupSexo, radioGroupTipo;
    RadioButton rbSexoEscolhido, rbTipoEscolhido;
    ImageView imageView;

    final int REQUEST_CODE_GALLERY = 999;

    private DataBase dataBase;
    private SQLiteDatabase conn;
    private RepositorioPet repositorioPet;
    private Pets pets;


    public CadastroMeusPets() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cadastro_meus_pets, container, false);

        edtName = (EditText) view.findViewById(R.id.editartName);
        edtRaca = (EditText) view.findViewById(R.id.editarRaca);
        edtIdade = (EditText) view.findViewById(R.id.editarIdade);

        radioGroupSexo = (RadioGroup) view.findViewById(R.id.radioSexo);
        radioGroupTipo = (RadioGroup) view.findViewById(R.id.radioTipo);

        int idRbSexoEscolhido = radioGroupSexo.getCheckedRadioButtonId();
        if(idRbSexoEscolhido > 0 ){
            rbSexoEscolhido = (RadioButton) view.findViewById(idRbSexoEscolhido);
        }

        int idRbTipoEscolhido = radioGroupTipo.getCheckedRadioButtonId();
        if(idRbTipoEscolhido > 0 ){
            rbTipoEscolhido = (RadioButton) view.findViewById(idRbTipoEscolhido);
        }

        imageView = (ImageView) view.findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                escolherImg();
            }
        });

        try {
            dataBase = new DataBase(getContext());
            conn = dataBase.getWritableDatabase();

            repositorioPet = new RepositorioPet(conn);

        }catch (SQLException e){

            AlertDialog.Builder dlg = new AlertDialog.Builder(getContext());
            dlg.setMessage("erro " + e.getMessage());
            dlg.setNeutralButton("Ok", null );
            dlg.show();
        }

        return view;

        //Bundle bundle = this.getArguments();
        //if(bundle != null){
        //    String recu = bundle.getString("PET");
        //}

    }

    public void escolherImg(){
        requestPermissions(
                new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},
                REQUEST_CODE_GALLERY
        );
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CODE_GALLERY){
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
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
        if(requestCode == REQUEST_CODE_GALLERY && resultCode == getActivity().RESULT_OK && data != null){
            Uri uri = data.getData();


            try {
                InputStream inputStream = getActivity().getContentResolver().openInputStream(uri);

                Glide.with(this)
                        .load(uri)
                        .asBitmap()
                        .centerCrop()
                        .into(imageView);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_cadstromeuspets, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.adicionar);
        item.setVisible(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.adicionar) {
                inserir();
        }
        return super.onOptionsItemSelected(item);
    }

    private void inserir(){

        try{

        pets = new Pets();

        if(edtName.getText().toString().length() == 0){
            edtName.setError("Digite um nome");
        }else {

            pets.setName(edtName.getText().toString());
            pets.setRaca(edtRaca.getText().toString());
            pets.setIdade(edtIdade.getText().toString());
            pets.setSexo(rbSexoEscolhido.getText().toString());
            pets.setTipo(rbTipoEscolhido.getText().toString());
            pets.setImage(imageViewToByte(imageView));

            edtName.setText("");
            edtRaca.setText("");
            edtIdade.setText("");
            imageView.setImageResource(R.drawable.novaphoto);

            Snackbar snackbar = Snackbar.make(getView(), "Salvo!", Snackbar.LENGTH_SHORT);
            snackbar.show();
        }

        repositorioPet.inserir(pets);
        }catch (Exception e){

            AlertDialog.Builder dlg = new AlertDialog.Builder(getContext());
            dlg.setMessage("erro ao inserir os dados " + e.getMessage());
            dlg.setNeutralButton("Ok", null );
            dlg.show();
        }
    }

    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

}
