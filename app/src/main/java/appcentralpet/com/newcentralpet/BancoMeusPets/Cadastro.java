package appcentralpet.com.newcentralpet.BancoMeusPets;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
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
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import appcentralpet.com.newcentralpet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Cadastro extends Fragment {

    EditText edtName, edtRaca, edtIdade;
    RadioGroup radioGroupSexo, radioGroupTipo;
    RadioButton rbSexoEscolhido, rbTipoEscolhido;
    ImageView imageView;

    Button btnSalvar;

    public static SQLiteHelper sqLiteHelper;
    final int REQUEST_CODE_GALLERY = 999;

    public Cadastro() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cadastro, container, false);

        btnSalvar = (Button) view.findViewById(R.id.btnSalvar);

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

        sqLiteHelper = new SQLiteHelper(getContext(), "PetDB.sqlite", null, 4);
        sqLiteHelper.queryData( "CREATE TABLE IF NOT EXISTS PET (Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name VARCHAR, " +
                "sexo VARCHAR, " +
                "raca VARCHAR, " +
                "tipo VARCHAR, " +
                "idade VARCHAR, " +
                "image BLOB)");

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                escolherImg();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionar();
            }
        });

        return view;
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

    public void adicionar() {

        try {
            if(edtName.getText().toString().length() == 0){
                edtName.setError("Digite um nome");
            }else {
                sqLiteHelper.insertData(
                        edtName.getText().toString().trim(),
                        rbSexoEscolhido.getText().toString().trim(),
                        edtRaca.getText().toString().trim(),
                        rbTipoEscolhido.getText().toString().trim(),
                        edtIdade.getText().toString().trim(),
                        imageViewToByte(imageView)
                );
                Snackbar snackbar = Snackbar.make(getView(), "Novo pet salvo!", Snackbar.LENGTH_SHORT);
                snackbar.show();
                edtName.setText("");
                edtRaca.setText("");
                edtIdade.setText("");
                imageView.setImageResource(R.drawable.novaphoto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.adicionar) {
            adicionar();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
