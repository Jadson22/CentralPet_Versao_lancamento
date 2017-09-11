package appcentralpet.com.newcentralpet.BancoMeusPets;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

import appcentralpet.com.newcentralpet.R;

public class EditarPet extends AppCompatActivity {

    EditText edtName, edtRaca, edtIdade;
    RadioGroup radioGroupSexo, radioGroupTipo;
    RadioButton rbSexoEscolhido, rbTipoEscolhido;
    ImageView imageView;
    Button btnSalvar;

    Pet pet;

    public static SQLiteHelper sqLiteHelper;
    final int REQUEST_CODE_GALLERY = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_pet);

        btnSalvar = (Button) findViewById(R.id.btnSalvar);

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

        Cursor c = Cadastro.sqLiteHelper.getData("SELECT id FROM PET");
        ArrayList<Integer> arrID = new ArrayList<Integer>();
        while (c.moveToNext()){
            arrID.add(c.getInt(0));
        }

        /*Bundle bundle = getIntent().getExtras();
        if((bundle != null) && (bundle.containsKey("PEET"))){

            c = (Cursor) bundle.getSerializable("PEET");
            //preenchedados();
        }else {

        } */
    }

   /* private void preenchedados() {
        edtName.setText(pet.getName());
        //rbSexoEscolhido.setSelected(Integer.parseInt(pet.getSexo()));
        edtRaca.setText(pet.getRaca());
        //rbTipoEscolhido.set
        edtIdade.setText(pet.getIdade());
        //imageView.setImageBitmap(pet.getImage());

    } */


}
