package appcentralpet.com.newcentralpet;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import appcentralpet.com.newcentralpet.BancoMeusPets.PetList;
import appcentralpet.com.newcentralpet.BancoMeusPets.SQLiteHelper;
import appcentralpet.com.newcentralpet.ListExpansivel.DuvFrequentes;
import appcentralpet.com.newcentralpet.mapa.MapaClinicaActivity;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    EditText edtName, edtRaca, edtIdade;
    RadioGroup radioGroupSexo, radioGroupTipo;
    RadioButton rbSexoEscolhido, rbTipoEscolhido;
    ImageView imageView;

    public static SQLiteHelper sqLiteHelper;
    final int REQUEST_CODE_GALLERY = 999;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbarMain);
        toolbar.setTitle("Cadastrar Pet");
        setSupportActionBar(toolbar);

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Adicionar Pet").withIcon(getResources().getDrawable(R.drawable.ic_add));
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("Meus Pets").withIcon(getResources().getDrawable(R.drawable.newdog));
        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(3).withName("Vacinas").withIcon(getResources().getDrawable(R.drawable.ic_seringa));
        PrimaryDrawerItem item4 = new PrimaryDrawerItem().withIdentifier(4).withName("Clínicas e Pet Shops").withIcon(getResources().getDrawable(R.drawable.ic_clinicas));
        PrimaryDrawerItem item5 = new PrimaryDrawerItem().withIdentifier(5).withName("Dúvidas Frequentes").withIcon(getResources().getDrawable(R.drawable.ic_duvidas));
        DividerDrawerItem item6 = new DividerDrawerItem();
        SecondaryDrawerItem item7 = new SecondaryDrawerItem().withIdentifier(7).withName("Suporte").withIcon(getResources().getDrawable(R.drawable.ic_build));
        SectionDrawerItem item8 = new SectionDrawerItem().withName("Apoie");
        PrimaryDrawerItem item9 = new PrimaryDrawerItem().withIdentifier(9).withName("ONG - Anjos de 4 Patas").withIcon(getResources().getDrawable(R.drawable.ic_ong));


        //create the drawer and remember the `Drawer` result object
        final Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1, item2, item3, item4, item5, item6,
                        item7, item8, item9
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                        switch (position){
                            case 1:
                                Intent it = new Intent(MainActivity.this, MainActivity.class);
                                startActivity(it);
                                finish();
                                break;
                            case 2:
                                PetList petList = new PetList();
                                fragmentTransaction.add(R.id.rlprincipal, petList);
                                fragmentTransaction.commit();
                                break;
                            case 3:
                                break;
                            case 4:
                                Intent intent = new Intent(MainActivity.this, MapaClinicaActivity.class);
                                startActivity(intent);
                                break;
                            case 5:
                                DuvFrequentes duvFrequentes = new DuvFrequentes();
                                fragmentTransaction.add(R.id.rlprincipal, duvFrequentes);
                                fragmentTransaction.commit();
                                break;
                            case 7:
                                Suporte suporte = new Suporte();
                                fragmentTransaction.add(R.id.rlprincipal, suporte);
                                fragmentTransaction.commit();
                                break;
                            case 9:
                                Intent ong = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/anjosdequatrop4tas"));
                                startActivity(ong);
                                break;
                        }
                        return true;
                    }
                })
                .build();




        //BANCO DE DADOS

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


        sqLiteHelper = new SQLiteHelper(this, "PetDB.sqlite", null, 3);
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
                ActivityCompat.requestPermissions(
                        MainActivity.this,
                        new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });


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
                Toast.makeText(getApplicationContext(), "Você não tem permissão para acessar os arquivos!", Toast.LENGTH_SHORT).show();
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

                //Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                //imageView.setImageBitmap(bitmap);

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

    private void adicionar() {

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
                Toast.makeText(getApplicationContext(), "Adicionado com sucesso!", Toast.LENGTH_SHORT).show();
                edtName.setText("");
                edtRaca.setText("");
                edtIdade.setText("");
                imageView.setImageResource(R.drawable.fotoperfil);
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
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cadstromeuspets, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.adicionar:
                adicionar();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
