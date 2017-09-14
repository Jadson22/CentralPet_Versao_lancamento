package appcentralpet.com.newcentralpet.newBancoDados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import appcentralpet.com.newcentralpet.R;

public class ModeloPerfil extends AppCompatActivity {

    EditText edtName, edtRaca, edtIdade;
    RadioGroup radioGroupSexo, radioGroupTipo;
    RadioButton rbSexoEscolhido, rbTipoEscolhido;
    ImageView imageView;

    private Pets pets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modelo_perfil);

        edtName = (EditText) findViewById(R.id.editartName);
        edtRaca = (EditText) findViewById(R.id.editarRaca);
        edtIdade = (EditText) findViewById(R.id.editarIdade);
        imageView = (ImageView) findViewById(R.id.imageView);

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


        Bundle bundle = getIntent().getExtras();
        if((bundle != null)&&(bundle.containsKey("PET"))){
            pets = (Pets) bundle.getSerializable("PET");
            preencheDados();
        }else{
            pets = new Pets();
        }
    }

    private void preencheDados() {

    }
}
