package appcentralpet.com.newcentralpet.ListExpansivel;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import appcentralpet.com.newcentralpet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DuvFrequentes extends Fragment {

    private Toolbar toolbar_duvidas;
    private ExpandableListView lst_view;
    private String [] opcao = {"op0", "op1", "op2", "op3", "op4", "op5", "op6", "op7", "op8", "op9", "op10", "op11"};

    public DuvFrequentes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_duv_frequentes, container, false);

        toolbar_duvidas = (Toolbar) view.findViewById(R.id.toolbar_duvidas);
        toolbar_duvidas.setTitle("Dúvidas Frequentes");

        lst_view = (ExpandableListView) view.findViewById(R.id.lst_view);


        //cria os grupos
        List<String> lstgrupos = new ArrayList<>();
        lstgrupos.add("Vacinas - Cães");
        lstgrupos.add("Vacinas - Gatos");
        lstgrupos.add("Doenças");
        lstgrupos.add("Alimentação");

        //cria os itens de cada grupo
        List<Info_duv> lstVacinasCaes = new ArrayList<>();
        lstVacinasCaes.add(new Info_duv("Vermífugo", ""));
        lstVacinasCaes.add(new Info_duv("Anti-pulgas", ""));
        lstVacinasCaes.add(new Info_duv("V8 ou V10", ""));
        lstVacinasCaes.add(new Info_duv("Tosse", ""));
        lstVacinasCaes.add(new Info_duv("Anti-rábica", ""));
        lstVacinasCaes.add(new Info_duv("Giardíase", ""));
        lstVacinasCaes.add(new Info_duv("Gripe canina", ""));

        List<Info_duv> lstVacinasGatos = new ArrayList<>();
        lstVacinasGatos.add(new Info_duv("Vermífugo", ""));
        lstVacinasGatos.add(new Info_duv("Anti-pulgas", ""));
        lstVacinasGatos.add(new Info_duv("V4", ""));
        lstVacinasGatos.add(new Info_duv("Anti-rábica", ""));
        lstVacinasGatos.add(new Info_duv("Quadrupla felina", ""));

        //cria os itens de cada grupo
        List<Info_duv> lstDoencas = new ArrayList<>();
        lstDoencas.add(new Info_duv("Pulgas", ""));
        lstDoencas.add(new Info_duv("Ferida", ""));
        lstDoencas.add(new Info_duv("Febre", ""));
        lstDoencas.add(new Info_duv("Conjuntive", ""));


        //cria os itens de cada grupo
        List<Info_duv> lstAliment = new ArrayList<>();
        lstAliment.add(new Info_duv("Pedgree", ""));
        lstAliment.add(new Info_duv("Vitamax", ""));

        // cria o "relacionamento" dos grupos com seus itens
        HashMap<String, List<Info_duv>> lstItensGrupo = new HashMap<>();
        lstItensGrupo.put(lstgrupos.get(0), lstVacinasCaes);
        lstItensGrupo.put(lstgrupos.get(1), lstVacinasGatos);
        lstItensGrupo.put(lstgrupos.get(2), lstDoencas);
        lstItensGrupo.put(lstgrupos.get(3), lstAliment);

        // cria um adaptador (BaseExpandableListAdapter) com os dados acima
        adaptador_lst adaptador = new adaptador_lst(getContext(), lstgrupos, lstItensGrupo);
        // define o apadtador do ExpandableListView
        lst_view.setAdapter(adaptador);

        return view;
    }

}
