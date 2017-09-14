package appcentralpet.com.newcentralpet.newBancoDados;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import appcentralpet.com.newcentralpet.R;

public class CadastroPets extends AppCompatActivity {

    EditText edtName, edtRaca, edtIdade;
    RadioGroup radioGroupSexo, radioGroupTipo;
    RadioButton rbSexoEscolhido, rbTipoEscolhido;
    ImageView imageView;

    final int REQUEST_CODE_GALLERY = 999;

    private DataBase dataBase;
    private SQLiteDatabase conn;
    private RepositorioPet repositorioPet;
    private Pets pets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pets);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Adicionar Pet");


        edtName = (EditText) findViewById(R.id.editartName);
        edtRaca = (EditText) findViewById(R.id.editarRaca);
        edtIdade = (EditText) findViewById(R.id.editarIdade);

        radioGroupSexo = (RadioGroup) findViewById(R.id.radioSexo);
        radioGroupTipo = (RadioGroup) findViewById(R.id.radioTipo);

        int idRbSexoEscolhido = radioGroupSexo.getCheckedRadioButtonId();
        if(idRbSexoEscolhido > 0 ){
            rbSexoEscolhido = (RadioButton) findViewById(idRbSexoEscolhido);
        }

        int idRbTipoEscolhido = radioGroupTipo.getCheckedRadioButtonId();
        if(idRbTipoEscolhido > 0 ){
            rbTipoEscolhido = (RadioButton) findViewById(idRbTipoEscolhido);
        }

        imageView = (ImageView) findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                escolherImg();
            }
        });

        try {
            dataBase = new DataBase(this);
            conn = dataBase.getWritableDatabase();

            repositorioPet = new RepositorioPet(conn);

        }catch (SQLException e){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("erro " + e.getMessage());
            dlg.setNeutralButton("Ok", null );
            dlg.show();
        }

    }

    public void escolherImg(){
        ActivityCompat.requestPermissions(
                CadastroPets.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
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
                Snackbar snackbar = Snackbar.make(findViewById(R.id.v), "Você não tem permissão para acessar os arquivos!", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();


            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);

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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cadstromeuspets, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.adicionar:
                if(pets == null){
                    inserir();
                }
        }
        return true;
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

                Snackbar snackbar = Snackbar.make(findViewById(R.id.v), "Salvo!", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }

            repositorioPet.inserir(pets);
        }catch (Exception e){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
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
