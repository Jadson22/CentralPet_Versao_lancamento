package appcentralpet.com.newcentralpet.ListExpansivel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import appcentralpet.com.newcentralpet.R;


/**
 * Created by L Moraes on 08/06/2017.
 */
public class adaptador_lst extends BaseExpandableListAdapter {

    private List<String> lstGrupos;
    private HashMap<String, List<Info_duv>> lstitensgrupo;
    private Context context;

    public adaptador_lst(Context context, List<String> grupos, HashMap<String, List<Info_duv>> itensGrupos){
        // inicializa as variáveis da classe
        this.context = context;
        lstGrupos = grupos;
        lstitensgrupo = itensGrupos;
    }

    @Override
    public int getGroupCount() {
        // retorna a quantidade de grupos
        return lstGrupos.size();
    }

    @Override
    public int getChildrenCount(int i) {
        // retorna a quantidade de itens de um grupo
        return lstitensgrupo.get(getGroup(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        // retorna um grupo
        return lstGrupos.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        // retorna um item do grupo
        return lstitensgrupo.get(getGroup(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        // retorna o id do grupo, porém como nesse exemplo
        // o grupo não possui um id específico, o retorno
        // será o próprio groupPosition
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        // retorna o id do item do grupo, porém como nesse exemplo
        // o item do grupo não possui um id específico, o retorno
        // será o próprio childPosition
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        // retorna se os ids são específicos (únicos para cada
        // grupo ou item) ou relativos
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        // cria os itens principais (grupos)

        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.grupo_lst, null);
        }

        TextView tvGrupo = (TextView) view.findViewById(R.id.tvGrupo);

        tvGrupo.setText((String) getGroup(i));

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        // cria os subitens (itens dos grupos)

        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_grupo, null);
        }

        TextView tvItem = (TextView) view.findViewById(R.id.tvItem);
        TextView tvValor = (TextView) view.findViewById(R.id.tvValor);

        Info_duv Info_duv = (Info_duv) getChild(i, i1);
        tvItem.setText(Info_duv.getNome());
        tvValor.setText(String.valueOf(Info_duv.getValor()));

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        // retorna se o subitem (item do grupo) é selecionável
        return true;
    }
}
