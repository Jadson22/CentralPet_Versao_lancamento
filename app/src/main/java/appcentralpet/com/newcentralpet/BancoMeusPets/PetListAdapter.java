package appcentralpet.com.newcentralpet.BancoMeusPets;

import android.content.Context;
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

        holder.textoName.setText(pet.getName());
        holder.textoRaca.setText(pet.getIdade());
        holder.textoIdade.setText(pet.getTipo());
        byte[] petImage = pet.getImage();
        Glide.with(this.context)
                .load(petImage)
                .asBitmap()
                .centerCrop()
                .into(holder.imgPerfil);

        //getraca
        if(pet.getRaca().equals("Macho")){
            holder.iconeSexo.setImageResource(R.drawable.iconemasc);
        }else{
            holder.iconeSexo.setImageResource(R.drawable.iconefem);
        }

        //getsexo
        if (pet.getTipo().equals("Cão")){
            holder.iconeTipo.setImageResource(R.drawable.iconecao);
        }else{
            holder.iconeTipo.setImageResource(R.drawable.iconegato);
        }


        return row;
    }
}
