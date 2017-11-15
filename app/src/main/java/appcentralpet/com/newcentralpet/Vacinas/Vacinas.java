package appcentralpet.com.newcentralpet.Vacinas;


import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import appcentralpet.com.newcentralpet.BancoMeusPets.Cadastro;
import appcentralpet.com.newcentralpet.NavigationDrawer;
import appcentralpet.com.newcentralpet.R;
import br.com.jansenfelipe.androidmask.MaskEditTextChangedListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class Vacinas extends Fragment implements Serializable {

    public static SQLiteHelperVacinas sqLiteHelperVacinas;

    EditText edtData, edtRetorno;
    AutoCompleteTextView nomepet, edtVacina;
    ListView listaVacinas;
    ArrayList<Vacina> list;
    VacinaListAdapter adapter = null;


    public Vacinas() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vacinas, container, false);



        sqLiteHelperVacinas = new SQLiteHelperVacinas(getContext(), "PetVacina.sqlite", null, 1);
        sqLiteHelperVacinas.queryData("CREATE TABLE IF NOT EXISTS VACINAS " +
                                    "(Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                    "nome VARCHAR, " +
                                    "vacina VARCHAR, " +
                                    "pdata VARCHAR, " +
                                    "sdata VARCHAR)" );

        listaVacinas = (ListView) view.findViewById(R.id.list_vacinas);

        list = new ArrayList<>();
        adapter = new VacinaListAdapter(getContext(), R.layout.vacina_itens, list);
        listaVacinas.setAdapter(adapter);

        Cursor cursor = sqLiteHelperVacinas.getData("SELECT * FROM VACINAS");
        list.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String nomePet = cursor.getString(1);
            String nomeVacina = cursor.getString(2);
            String pData = cursor.getString(3);
            String sData = cursor.getString(4);

            list.add(new Vacina(id, nomePet, nomeVacina, pData, sData));
        }
        adapter.notifyDataSetChanged();

        listaVacinas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                CharSequence[] itens = {"Editar", "Excluir"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());

                dialog.setTitle("Alterar");
                dialog.setItems(itens, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int item) {
                        if(item == 0 ){
                            //editar
                            Cursor cur = sqLiteHelperVacinas.getData("SELECT id FROM VACINAS");
                            ArrayList<Integer> arrayId = new ArrayList<Integer>();
                            while (cur.moveToNext()){
                                arrayId.add(cur.getInt(0));
                            }
                            showDialogUpdate(getActivity(), arrayId.get(position));

                        }else{
                            //apagar
                            Cursor cur = sqLiteHelperVacinas.getData("SELECT id FROM VACINAS");
                            ArrayList<Integer> arrayId = new ArrayList<Integer>();
                            while (cur.moveToNext()){
                                arrayId.add(cur.getInt(0));
                            }
                            showDialogDelete(arrayId.get(position));
                        }
                    }
                });
                dialog.show();
                return true;
            }
        });

        return view;
    }

    private void showDialogUpdate(Activity activity, final int position) {

        final Dialog dialogEdit = new Dialog(activity);
        dialogEdit.setContentView(R.layout.add_vacinas);
        dialogEdit.setTitle("Editar");

        final AutoCompleteTextView editarVacina = (AutoCompleteTextView) dialogEdit.findViewById(R.id.edtVacina);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, VACINAS);
        editarVacina.setAdapter(arrayAdapter);
        final EditText editarPdata = (EditText) dialogEdit.findViewById(R.id.edtData);
        MaskEditTextChangedListener maskpData = new MaskEditTextChangedListener("##/##/####", editarPdata);
        editarPdata.addTextChangedListener(maskpData);
        final EditText editarSData = (EditText) dialogEdit.findViewById(R.id.edtRetorno);
        MaskEditTextChangedListener masksData = new MaskEditTextChangedListener("##/##/####", editarSData);
        editarSData.addTextChangedListener(masksData);
        Button btnEditar = (Button) dialogEdit.findViewById(R.id.btnAdd);

        Cursor c = NavigationDrawer.sqLiteHelper.getData("SELECT * FROM PET");
        ArrayAdapter<String> arrID = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line);
        while (c.moveToNext()){
            arrID.add(c.getString(1));
        }
        final AutoCompleteTextView editarNomePet = (AutoCompleteTextView) dialogEdit.findViewById(R.id.nomePet);
        editarNomePet.setAdapter(arrID);

        int width = (int) (getActivity().getResources().getDisplayMetrics().widthPixels * 0.95);
        int height = (int) (getActivity().getResources().getDisplayMetrics().heightPixels * 0.7);
        dialogEdit.getWindow().setLayout(width, height);
        dialogEdit.show();

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if((editarNomePet.getText().toString().length() == 0) || (editarVacina.getText().toString().length() == 0)){
                        if(editarNomePet.getText().toString().length() == 0) {
                            editarNomePet.setError("Preencha um nome");
                        }else {
                            editarVacina.setError("Selecione uma vacina");
                        }
                    }else{
                        sqLiteHelperVacinas.updateData(
                                editarNomePet.getText().toString().trim(),
                                editarVacina.getText().toString().trim(),
                                editarPdata.getText().toString().trim(),
                                editarSData.getText().toString().trim(),
                                position
                        );
                    }
                    dialogEdit.dismiss();
                    Snackbar snackbar = Snackbar.make(getView(), "Editado com sucesso!", Snackbar.LENGTH_SHORT);
                    snackbar.show();

                }catch (Exception error){
                    Log.e("Update erro: ", error.getMessage());
                }
                atualizarListView();
            }
        });

    }

    private void showDialogDelete(final int idVacina) {
        final AlertDialog.Builder dialogDelete = new AlertDialog.Builder(getContext());

        dialogDelete.setTitle("Atenção!");
        dialogDelete.setMessage("Apagar Vacina?");
        dialogDelete.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    sqLiteHelperVacinas.deleteData(idVacina);
                    Snackbar snackbar = Snackbar.make(getView(), "Excluido!", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                } catch (Exception e){
                    Log.e("error", e.getMessage());
                }
                atualizarListView();
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

    public static final String[] VACINAS = new String[]{"V8", "V10", "Gripe Canina", "Giardíase", "Anti-rábica", "Quádrupla Felina"};

    private void ShowDialogAdd(){

        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.add_vacinas);
        dialog.setTitle("Adicionar");


         edtVacina = (AutoCompleteTextView) dialog.findViewById(R.id.edtVacina);
         ArrayAdapter<String> adpVac = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, VACINAS);
         edtVacina.setAdapter(adpVac);

         edtData = (EditText) dialog.findViewById(R.id.edtData);
         MaskEditTextChangedListener maskedtdata = new MaskEditTextChangedListener("##/##/####", edtData);
         edtData.addTextChangedListener(maskedtdata);
         edtRetorno = (EditText) dialog.findViewById(R.id.edtRetorno);
         MaskEditTextChangedListener maskedtretorno = new MaskEditTextChangedListener("##/##/####", edtRetorno);
         edtRetorno.addTextChangedListener(maskedtretorno);
        Cursor c = NavigationDrawer.sqLiteHelper.getData("SELECT * FROM PET");
        ArrayAdapter<String> arrID = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line);
        while (c.moveToNext()){
            arrID.add(c.getString(1));
        }
        nomepet = (AutoCompleteTextView) dialog.findViewById(R.id.nomePet);
        nomepet.setAdapter(arrID);

        Button btnAdd = (Button) dialog.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarVacina();
                dialog.dismiss();

                // time at which alarm will be scheduled here alarm is scheduled at 1 day from current time,
                // we fetch  the current time in milliseconds and added 1 day time
                // i.e. 24*60*60*1000= 86,400,000   milliseconds in a day
                Long time = new GregorianCalendar().getTimeInMillis()+5000;
                //24*60*60*1000

                // create an Intent and set the class which will execute when Alarm triggers, here we have
                // given AlarmReciever in the Intent, the onRecieve() method of this class will execute when
                // alarm triggers and
                //we will write the code to send SMS inside onRecieve() method pf Alarmreciever class
                Intent intentAlarm = new Intent(getContext(), MyReceiver.class);

                // create the object
                AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);

                //set the alarm for particular time
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,time, time, PendingIntent.getBroadcast(getContext(),1 ,  intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT));
                Toast.makeText(getContext(), "Será avisado quando estiver no dia", Toast.LENGTH_LONG).show();

            }







        });

        int width = (int) (getActivity().getResources().getDisplayMetrics().widthPixels * 0.95);
        int height = (int) (getActivity().getResources().getDisplayMetrics().heightPixels * 0.7);
        dialog.getWindow().setLayout(width, height);
        dialog.show();


    }






        /*
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(edtData.getText().toString()));

        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(PData.getText.toString()));
        Intent myIntent = new Intent(.this, MyReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(Vacina.this, 0, myIntent, 0);

        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);*/

        /*String data=edtData.getText().toString();
        ComponentName serviceName= new ComponentName(getContext(), ServicoAlarme.class);
        JobInfo jobInfo= new JobInfo.Builder(0, serviceName).setPeriodic(21/10/2017)
                .setMinimumLatency(12)
                .setRequiresCharging(false).build();
        JobScheduler scheduler= (JobScheduler) getContext().getSystemService(Context.JOB_SCHEDULER_SERVICE);
        int result= scheduler.schedule(jobInfo);
        if(result== JobScheduler.RESULT_SUCCESS)Log.d("MainActivity", "vacina agendada!");*/



    private void adicionarVacina() {

        try{

            if((nomepet.getText().toString().length() == 0) || (edtVacina.getText().toString().length() == 0)){
                if(nomepet.getText().toString().length() == 0) {
                    nomepet.setError("Preencha um nome");
                }else {
                    edtVacina.setError("Selecione uma vacina");
                }
            }else{

                sqLiteHelperVacinas.insertData(
                        nomepet.getText().toString().trim(),
                        edtVacina.getText().toString().trim(),
                        edtData.getText().toString().trim(),
                        edtRetorno.getText().toString().trim()
                );
                Snackbar snackbar = Snackbar.make(getView(), "Adicionado!", Snackbar.LENGTH_SHORT);
                snackbar.show();
                nomepet.setText("");
                edtVacina.setText("");
                edtData.setText("");
                edtRetorno.setText("");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        atualizarListView();
    }

    private void atualizarListView(){

        Cursor cursor = sqLiteHelperVacinas.getData("SELECT * FROM VACINAS");
        list.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String nomePet = cursor.getString(1);
            String nomeVacina = cursor.getString(2);
            String pData = cursor.getString(3);
            String sData = cursor.getString(4);

            list.add(new Vacina(id, nomePet, nomeVacina, pData, sData));
        }
        adapter.notifyDataSetChanged();

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
