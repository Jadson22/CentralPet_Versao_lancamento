package appcentralpet.com.newcentralpet.BancoMeusPets;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;
import org.joda.time.Years;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import appcentralpet.com.newcentralpet.R;

/**
 * Created by L Moraes on 30/08/2017.
 */
public class PetListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Pet> petList;
    public String NovaIdade;

    public PetListAdapter(Context context, int layout, ArrayList<Pet> petList) {
        this.context = context;
        this.layout = layout;
        this.petList = petList;
    }

    @Override
    public int getCount() {
        return petList.size();
    }

    @Override
    public Object getItem(int position) {
        return petList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imgPerfil, iconeSexo, iconeTipo;
        TextView textoName, textoRaca, textoIdade;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.textoName = (TextView) row.findViewById(R.id.textoName);
            holder.textoRaca = (TextView) row.findViewById(R.id.textoRaca);
            holder.textoIdade = (TextView) row.findViewById(R.id.textoIdade);
            holder.imgPerfil = (ImageView) row.findViewById(R.id.imgPerfil);
            holder.iconeSexo = (ImageView) row.findViewById(R.id.iconeSexo);
            holder.iconeTipo = (ImageView) row.findViewById(R.id.iconeTipo);

            row.setTag(holder);
        }else{
            holder = (ViewHolder) row.getTag();
        }

        Pet pet = petList.get(position);

        String ani = pet.getIdade();
        calcularIdade(ani);
        Idade idade1 = new Idade(NovaIdade);


        holder.textoName.setText(pet.getName());
        holder.textoRaca.setText(pet.getRaca());
        holder.textoIdade.setText(idade1.getIdadeClasse());

        byte[] petImage = pet.getImage();
        Glide.with(this.context)
                .load(petImage)
                .asBitmap()
                .centerCrop()
                .into(holder.imgPerfil);

        //getraca
        if(pet.getSexo().equals("macho")){
            holder.iconeSexo.setImageResource(R.drawable.iconemasc);
        }else{
            holder.iconeSexo.setImageResource(R.drawable.iconefem);
        }

        //getsexo
        if (pet.getTipo().equals("cao")){
            holder.iconeTipo.setImageResource(R.drawable.iconecao);
        }else{
            holder.iconeTipo.setImageResource(R.drawable.iconegato);
        }

        return row;

    }
    private void calcularIdade(String aniv) {
        Calendar c = Calendar.getInstance();
        int diaA = c.get(Calendar.DAY_OF_MONTH);
        int mesA = c.get(Calendar.MONTH);
        int anoA = c.get(Calendar.YEAR);

        String DataAtual = diaA + "/" + mesA + "/" + anoA;
        String DataNascimento = aniv;

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Date date1 = null;
        Date date2 = null;

        try {
            date1 = format.parse(DataNascimento);
            date2 = format.parse(DataAtual);

            DateTime dt1 = new DateTime(date1);
            DateTime dt2 = new DateTime(date2);

            long difdia = Days.daysBetween(dt1, dt2).getDays();
            long difMes = Months.monthsBetween(dt1, dt2).getMonths();
            long difAnos = Years.yearsBetween(dt1, dt2).getYears();

            long idade = difAnos;

            if (idade == 1) {
                //edtIdade.setText(idade + " ano");
                NovaIdade = idade + " ano";
            } else if (idade > 1) {
                //edtIdade.setText(idade + " anos");
                NovaIdade = idade + " anos";
            } else if (idade < 1) {
                idade = difMes;
                if (idade == 1) {
                    //edtIdade.setText(idade + " mês");
                    NovaIdade = idade + " mês";
                } else if (idade > 1) {
                    //edtIdade.setText(idade + " meses");
                    NovaIdade = idade + " meses";
                } else if (idade < 1) {
                    idade = difdia;
                    if (idade == 1) {
                        //edtIdade.setText(idade + " dia");
                        NovaIdade = idade + " dia";
                    } else {
                        //edtIdade.setText(idade + " dias");
                        NovaIdade = idade + " dias";
                    }
                }
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void passarIdade(String idaa){
        String idaadee = idaa;
    }
}
