package appcentralpet.com.newcentralpet.Vacinas;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import appcentralpet.com.newcentralpet.R;

/**
 * Created by Jadson on 15/09/2017.
 */
public class VacinaListAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Vacina> vacinaList;

    public VacinaListAdapter(Context context, int layout, ArrayList<Vacina> vacinaList) {
        this.context = context;
        this.layout = layout;
        this.vacinaList = vacinaList;
    }

    @Override
    public int getCount() {
        return vacinaList.size();
    }

    @Override
    public Object getItem(int position) {
        return vacinaList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        TextView nomePet, nomeVacina, pData, sData;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.nomePet = (TextView) row.findViewById(R.id.setarNome);
            holder.nomeVacina = (TextView) row.findViewById(R.id.setarVacina);
            holder.pData = (TextView) row.findViewById(R.id.pData);
            holder.sData = (TextView) row.findViewById(R.id.sData);
            row.setTag(holder);
        }else{
            holder = (ViewHolder) row.getTag();
        }

        Vacina vacina = vacinaList.get(position);

        holder.nomePet.setText(vacina.getNomePet());
        holder.nomeVacina.setText(vacina.getNomeVacina());
        holder.pData.setText(vacina.getpData());
        holder.sData.setText(vacina.getsData());

        return row;
    }
}
