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

import java.util.ArrayList;

import appcentralpet.com.newcentralpet.R;

/**
 * Created by L Moraes on 30/08/2017.
 */
public class PetListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Pet> petList;

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
        TextView textoName, textoRaca, textoIdade, textoAnos;
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
            holder.textoAnos = (TextView) row.findViewById(R.id.idy) ;

            row.setTag(holder);
        }else{
            holder = (ViewHolder) row.getTag();
        }

        Pet pet = petList.get(position);

        holder.textoName.setText(pet.getName());
        holder.textoRaca.setText(pet.getRaca());
        holder.textoIdade.setText(pet.getIdade());
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

        if(pet.getIdade()!=null) {
            try {
                double idadee = Double.parseDouble(pet.getIdade());
                if (idadee < 1) {
                    holder.textoAnos.setText("meses");
                } else if (idadee > 1) {
                    holder.textoAnos.setText("anos");
                }
            } catch (NumberFormatException e) {
            }
        }

        if(pet.getIdade().equals("")){
            holder.textoAnos.setText("");
        }else if(pet.getIdade().equals("1")){
            holder.textoAnos.setText("ano");
        }

        return row;
    }
}
