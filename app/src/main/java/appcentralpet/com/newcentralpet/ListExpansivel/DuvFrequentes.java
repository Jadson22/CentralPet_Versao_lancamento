package appcentralpet.com.newcentralpet.ListExpansivel;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

        lst_view = (ExpandableListView) view.findViewById(R.id.lst_view);

        lst_view.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                //Toast.makeText(Duvidas_freq.this, "clic", Toast.LENGTH_SHORT).show();
                switch (i) {
                    case 0:
                        switch (i1){
                            case 0 : Intent intent = new Intent(getContext(), TabelaVacinasCaes.class);
                                startActivity(intent);
                                break;
                            case 1 : Intent intent1 = new Intent(getContext(), TabelaVacinasGato.class);
                                startActivity(intent1);
                                break;
                            case 2 : Intent intent2 = new Intent(getContext(), TextosDuvidas.class);
                                intent2.putExtra("opcao", opcao[2]);
                                startActivity(intent2);
                                break;
                            case 3 : Intent intent3 = new Intent(getContext(), TextosDuvidas.class);
                                intent3.putExtra("opcao", opcao[3]);
                                startActivity(intent3);
                                break;
                        }break;

                    case 1:
                        switch (i1){
                            case 0 : Intent intent7 = new Intent(getContext(), TextosDuvidas.class);
                                intent7.putExtra("opcao", opcao[7]);
                                startActivity(intent7);
                                break;
                            case 1 : Intent intent8 = new Intent(getActivity(), TextosDuvidas.class);
                                intent8.putExtra("opcao", opcao[8]);
                                startActivity(intent8);
                                break;
                            case 2 : Intent intent9 = new Intent(getContext(), TextosDuvidas.class);
                                intent9.putExtra("opcao", opcao[9]);
                                startActivity(intent9);
                                break;
                            case 3 : Intent intent10 = new Intent(getContext(), TextosDuvidas.class);
                                intent10.putExtra("opcao", opcao[10]);
                                startActivity(intent10);
                                break;
                            case 4 : Intent intent11 = new Intent(getContext(), TextosDuvidas.class);
                                intent11.putExtra("opcao", opcao[11]);
                                startActivity(intent11);
                                break;
                        }break;
                    case 2:
                        switch (i1){
                            case 0 : //Toast.makeText(Duvidas_freq.this, "pulgas", Toast.LENGTH_SHORT).show();
                                break;
                            case 1 :// Toast.makeText(Duvidas_freq.this, "ferida", Toast.LENGTH_SHORT).show();
                                break;
                            case 2 : //Toast.makeText(Duvidas_freq.this, "febre", Toast.LENGTH_SHORT).show();
                                break;
                            case 3 : //Toast.makeText(Duvidas_freq.this, "conjuntivite", Toast.LENGTH_SHORT).show();
                                break;
                        }break;
                    case 3:
                        switch (i1){
                            case 0 : //Toast.makeText(Duvidas_freq.this, "pedgree", Toast.LENGTH_SHORT).show();
                                break;
                            case 1 : //Toast.makeText(Duvidas_freq.this, "vitamax", Toast.LENGTH_SHORT).show();
                                break;
                        }break;

                }
                return true;
            }
        });


        //cria os grupos
        List<String> lstgrupos = new ArrayList<>();
        lstgrupos.add("Vacinação");
        lstgrupos.add("Doenças comuns gatos");
        lstgrupos.add("Doenças comuns cães");
        lstgrupos.add("Alimentação");

        //cria os itens de cada grupo
        List<Info_duv> vacinas = new ArrayList<>();
        vacinas.add(new Info_duv("Tabela de vacinação cães", ""));
        vacinas.add(new Info_duv("Tabela de vacinação gatos", ""));
        vacinas.add(new Info_duv("Reações das vacinas", ""));
        vacinas.add(new Info_duv("Recomendações", ""));

        List<Info_duv> dcg = new ArrayList<>();
        dcg.add(new Info_duv("X", ""));
        dcg.add(new Info_duv("X", ""));
        dcg.add(new Info_duv("X", ""));
        dcg.add(new Info_duv("X", ""));
        dcg.add(new Info_duv("X", ""));

        //cria os itens de cada grupo
        List<Info_duv> dccaes = new ArrayList<>();
        dccaes.add(new Info_duv("X", ""));
        dccaes.add(new Info_duv("X", ""));
        dccaes.add(new Info_duv("X", ""));
        dccaes.add(new Info_duv("X", ""));


        //cria os itens de cada grupo
        List<Info_duv> lstAliment = new ArrayList<>();
        lstAliment.add(new Info_duv("Quantidade certa", ""));
        lstAliment.add(new Info_duv("Alimento adequado", ""));
        lstAliment.add(new Info_duv("Marca de rações", ""));

        // cria o "relacionamento" dos grupos com seus itens
        HashMap<String, List<Info_duv>> lstItensGrupo = new HashMap<>();
        lstItensGrupo.put(lstgrupos.get(0), vacinas);
        lstItensGrupo.put(lstgrupos.get(1), dcg);
        lstItensGrupo.put(lstgrupos.get(2), dccaes);
        lstItensGrupo.put(lstgrupos.get(3), lstAliment);

        // cria um adaptador (BaseExpandableListAdapter) com os dados acima
        adaptador_lst adaptador = new adaptador_lst(getContext(), lstgrupos, lstItensGrupo);
        // define o apadtador do ExpandableListView
        lst_view.setAdapter(adaptador);

        return view;
    }

}
