package appcentralpet.com.newcentralpet.ListExpansivel;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    private String [] opcao = {"op0", "op1", "op2", "op3", "op4", "op5", "op6", "op7", "op8", "op9", "op10", "op11", "op12", "op13", "op14", "op15", "op16", "op17", "op18", "op19", "op20", "op21", "op22", "op23", "op24", "op25", "op26", "op27", "op28"};

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
                            case 5 : Intent intent12 = new Intent(getContext(), TextosDuvidas.class);
                                intent12.putExtra("opcao", opcao[12]);
                                startActivity(intent12);
                                break;
                            case 6 : Intent intent13 = new Intent(getContext(), TextosDuvidas.class);
                                intent13.putExtra("opcao", opcao[13]);
                                startActivity(intent13);
                                break;
                            case 7 : Intent intent14 = new Intent(getContext(), TextosDuvidas.class);
                                intent14.putExtra("opcao", opcao[14]);
                                startActivity(intent14);
                                break;
                            case 8 : Intent intent15 = new Intent(getContext(), TextosDuvidas.class);
                                intent15.putExtra("opcao", opcao[15]);
                                startActivity(intent15);
                                break;
                            case 9 : Intent intent16 = new Intent(getContext(), TextosDuvidas.class);
                                intent16.putExtra("opcao", opcao[16]);
                                startActivity(intent16);
                                break;
                        }break;
                    case 2:
                        switch (i1){
                            case 0 : Intent intent17 = new Intent(getContext(), TextosDuvidas.class);
                                intent17.putExtra("opcao", opcao[17]);
                                startActivity(intent17);
                                break;
                            case 1 :Intent intent18 = new Intent(getContext(), TextosDuvidas.class);
                                intent18.putExtra("opcao", opcao[18]);
                                startActivity(intent18);
                                break;
                            case 2 : Intent intent19 = new Intent(getContext(), TextosDuvidas.class);
                                intent19.putExtra("opcao", opcao[19]);
                                startActivity(intent19);
                                break;
                            case 3 : Intent intent20 = new Intent(getContext(), TextosDuvidas.class);
                                intent20.putExtra("opcao", opcao[20]);
                                startActivity(intent20);
                                break;
                            case 4 : Intent intent21 = new Intent(getContext(), TextosDuvidas.class);
                                intent21.putExtra("opcao", opcao[21]);
                                startActivity(intent21);
                                break;
                            case 5 : Intent intent22 = new Intent(getContext(), TextosDuvidas.class);
                                intent22.putExtra("opcao", opcao[22]);
                                startActivity(intent22);
                                break;
                            case 6 : Intent intent23 = new Intent(getContext(), TextosDuvidas.class);
                                intent23.putExtra("opcao", opcao[23]);
                                startActivity(intent23);
                                break;
                            case 7 : Intent intent24 = new Intent(getContext(), TextosDuvidas.class);
                                intent24.putExtra("opcao", opcao[24]);
                                startActivity(intent24);
                                break;
                            case 8 : Intent intent25 = new Intent(getContext(), TextosDuvidas.class);
                                intent25.putExtra("opcao", opcao[25]);
                                startActivity(intent25);
                                break;
                            case 9: Intent intent26 = new Intent(getContext(), TextosDuvidas.class);
                                intent26.putExtra("opcao", opcao[26]);
                                startActivity(intent26);
                                break;
                        }break;
                    case 3:
                        switch (i1){
                            case 0 : Intent intent27 = new Intent(getContext(), TextosDuvidas.class);
                                intent27.putExtra("opcao", opcao[27]);
                                startActivity(intent27);
                                break;
                            case 1 : Intent intent28 = new Intent(getContext(), TextosDuvidas.class);
                                intent28.putExtra("opcao", opcao[28]);
                                startActivity(intent28);
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
        vacinas.add(new Info_duv("Tabela de vacinação-Cães", ""));
        vacinas.add(new Info_duv("Tabela de vacinação-Gatos", ""));
        vacinas.add(new Info_duv("Reações das vacinas", ""));
        vacinas.add(new Info_duv("Recomendações", ""));

        List<Info_duv> dcg = new ArrayList<>();
        dcg.add(new Info_duv("Peritonite Infecciosa Felina (PIF)", ""));
        dcg.add(new Info_duv("Vírus da Imunodeficiência Felina (FIV)", ""));
        dcg.add(new Info_duv("Rim Policístico (PKD)", ""));
        dcg.add(new Info_duv("Vírus da Leucose Felina (FeLV)", ""));
        dcg.add(new Info_duv("Coriza", ""));
        dcg.add(new Info_duv("Panleucopénia", ""));
        dcg.add(new Info_duv("Leucose", ""));
        dcg.add(new Info_duv("Raiva", ""));
        dcg.add(new Info_duv("Clamidiose", ""));
        dcg.add(new Info_duv("Toxoplasmose", ""));


        //cria os itens de cada grupo
        List<Info_duv> dccaes = new ArrayList<>();
        dccaes.add(new Info_duv("Leishmaniose", ""));
        dccaes.add(new Info_duv("Cinomose / Esgana", ""));
        dccaes.add(new Info_duv("Sarna", ""));
        dccaes.add(new Info_duv("Leptospirose", ""));
        dccaes.add(new Info_duv("Giardia", ""));
        dccaes.add(new Info_duv("Parvovirose", ""));
        dccaes.add(new Info_duv("Raiva", ""));
        dccaes.add(new Info_duv("Coronavirose", ""));
        dccaes.add(new Info_duv("Dermatofitose", ""));
        dccaes.add(new Info_duv("Tosse dos canis", ""));



        //cria os itens de cada grupo
        List<Info_duv> lstAliment = new ArrayList<>();
        lstAliment.add(new Info_duv("Alimento adequado", ""));
        lstAliment.add(new Info_duv("Quantidade", ""));

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.adicionar);
        item.setVisible(false);
    }
}
