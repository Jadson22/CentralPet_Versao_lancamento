package appcentralpet.com.newcentralpet.ListExpansivel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import appcentralpet.com.newcentralpet.R;

public class TextosDuvidas extends AppCompatActivity {

    private TextView texto;
    private TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto_duvidas);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Dúvidas frequentes");

        texto = (TextView) findViewById(R.id.setText);
        titulo = (TextView) findViewById(R.id.titulo);

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            String opcaoescolhida = extra.getString("opcao");
            //Vacinação
            if(opcaoescolhida.equals("op0")){

            }else if(opcaoescolhida.equals("op2")){
                getSupportActionBar().setTitle("Reações das Vacinas");
                texto.setText("É comum algumas alterações no comportamento de cães vacinados:\n" +
                        "– febre\n" +
                        "– edema na região onde foi aplicada a vacina (inchaço)\n" +
                        "– prostração (o cão fica “pra baixo” e desanimado)\n" +
                        " \n" +
                        "Esses efeitos devem passar em 24 horas, avise sempre seu veterinário sobre qualquer mudança no comportamento do seu cachorro.");
            }else if(opcaoescolhida.equals("op3")){
                getSupportActionBar().setTitle("Recomendações");
                texto.setText("– Cães dóceis devem estar com coleira e guia, ser conduzidos por pessoas com tamanho suficiente para controlá-los e contê-los na hora de tomar a vacina.\n" +
                        "– Crianças não devem levar os animais para vacinar.\n" +
                        "– Animais bravos devem estar com focinheira para não oferecer nenhum risco de agressão ao proprietário ou outras pessoas.\n" +
                        "– Gatos são naturalmente muito assustados e devem ser levados em caixas de transporte ou similar, para evitar fuga ou acidentes.\n" +
                        "– Animais doentes não devem ser vacinados. Exemplos: animais com diarreia, secreção ocular ou nasal, sem apetite, animais que estão convalescendo de cirurgias ou outras enfermidades.\n");

            //Doenças comuns em gatos
            }else if(opcaoescolhida.equals("op7")){
                getSupportActionBar().setTitle("Doenças comuns em gatos");
                titulo.setText("Peritonite Infecciosa Felina (PIF)\n");
                texto.setText("É um vírus que contamina o abdómen, o fígado, rins, cérebro e sistema nervoso, criando nessas zonas abcessos e infecções. A transmissão pode ocorrer de duas formas: através do contacto do gato saudável com as fezes de um felino contaminado (por exemplo, se existem vários gatos a partilhar a mesma caixa de areia/W.C.) ou através da amamentação, em que a gata infecta as suas crias. Perda de apetite, emagrecimento, anemia, diarreia, febre constante, abdómen distendido, gânglios linfáticos aumentados são alguns dos sintomas.\n" +
                        "Infelizmente esta é uma doença fatal para os gatos, não existindo qualquer cura. Uma vez diagnosticada, poderão não viver muito mais tempo. Aqueles que conseguem fazer frente à PIF, podem viver mais dois anos, no máximo, com a ajuda de um tratamento de apoio.\n");
            }else if(opcaoescolhida.equals("op8")){
                getSupportActionBar().setTitle("Doenças comuns em gatos");
                titulo.setText("Vírus da Imunodeficiência Felina (FIV)\n");
                texto.setText("Afetando exclusivamente os gatos, o FIV é um vírus que diminui drasticamente as capacidades imunitárias, o que proporciona o fácil aparecimento de infecções e outras doenças.\n" +
                        "É transmitido por um gato infectado, nomeadamente na transmissão de sangue, sendo este género de contato extremamente frequente durante as lutas de gatos onde as mordidas provocam feridas abertas. Podem viver muitos anos (até cinco!) antes de se descobrir que são FIV positivos mas, se sintomas como falta de apetite, emagrecimento, febre, diarreia ou dificuldades respiratórias persistirem, é melhor fazer o teste. Uma vez transmitido, o vírus aloja-se no corpo para sempre. Não existe cura, mas podem viver uma vida normal e longa, desde que o dono lhe proporcione uma alimentação saudável e equilibrada, complementada com suplementos vitamínicos, lhe assegure a vacinação sempre em dia, mantendo-se sempre atento à condição física e, claro, mantê-los dentro de casa para não correr o risco de ficarem doentes e para não poderem infectar mais nenhum outro gato.\n");
            }else if(opcaoescolhida.equals("op9")){
                getSupportActionBar().setTitle("Doenças comuns em gatos");
                titulo.setText("Rim Policístico (PKD)\n");
                texto.setText("A Doença do Rim Policístico ou PKD (do inglês “Polycystic Kidney Disease”) é caracterizada pelo surgimento de cistos no rim, causando disfunção renal. A formação dos cistos ocorre ainda no período gestacional, porém estes aumentam de tamanho com o passar do tempo e podem variar de 1 mm a 1 cm de diâmetro. Normalmente animais mais velhos apresentam cistos maiores e em maior quantidade que animais mais jovens.\n" +
                        "Alguns dos sintomas clínicos da doença são: depressão, perda ou redução do apetite, sede demasiada, micção excessiva e perda de peso. Os problemas começam com o crescimento dos cistos, que causam disfunção renal, levando, finalmente, à falência renal. O diagnóstico pode ser feito de uma maneira nada agressiva, por meio de ultra-sonografia ou através de exames de DNA. Aos 10 meses de idade o exame anatómico chega a 98 % de precisão, quando realizado por veterinário experiente. Os exames de DNA são geralmente realizados em gatos com 8 a 10 semanas, e têm 100% de confiabilidade, em qualquer idade.\n");
            }else if(opcaoescolhida.equals("op10")){
                getSupportActionBar().setTitle("Doenças comuns em gatos");
                titulo.setText("Vírus da Leucose Felina (FeLV)\n");
                texto.setText("Tal como o FIV, também o FeLV é imunodepressivo, retirando ao sistema imunitário, de forma gradual, a capacidade de se defender contra as doenças ou infecções mais banais, podendo essas ser, muitas vezes, fatais.\n" +
                        "Para além de um maior risco na contracção de infecções várias, o FeLV está também associado ao desenvolvimento de tumores ou leucemias mortais. Este vírus, que só pode ser transmitido entre gatos, transmite-se pela saliva, lágrimas, urina, fezes ou através do leite, na fase da amamentação.\n" +
                        "A descoberta do vírus do FeLV é normalmente antecedida por sintomas como: perda ou falta de apetite, anemia, diarreia, doença respiratória crónica, infecções crónicas da boca, abcessos persistentes e recorrentes. No entanto, cerca de 25 a 30% dos gatos contagiados rejeitam o vírus, evitando assim a infecção; aproximadamente 30% mantém uma concentração elevada do vírus no sangue, com o risco de contrair linfoma ou outra doença associada ao FeLV; os restantes 40% desenvolvem uma infecção que acaba por passar, mas tornam-se portador do vírus, que poderá ser facilmente activado se o sistema imunitário estiver debilitado ou exposto a outras doenças. Não existindo ainda qualquer cura, dependemos dos cuidados paliativos e de alguns cuidados básicos como a boa alimentação e alguns suplementos vitamínicos, evitar o contacto físico com outros animais, não partilhar comedouros, bebedouros, brinquedos e caixas de areia. E manter-nos dentro de casa. \n" +
                        "Em média, um portador deste vírus vive dois anos, mas existem estudos que apontam para uma taxa de sobrevivência de três anos e meio para cerca de 83% dos felinos.\n" +
                        "Entretanto, existe uma vacina contra o FeLV que o seu gato pode e deve levar. Informe-se junto do Veterinário.\n");
            }else if(opcaoescolhida.equals("op11")){
                getSupportActionBar().setTitle("Doenças comuns em gatos");
                titulo.setText("Coriza\n");
                texto.setText("Sob esta designação generalizada existem duas viroses responsáveis por sintomas idênticos, associados a patologia do sistema respiratório.\n" +
                        " A infecção por calicivírus ou por herpesvírus pode provocar lesões irreversíveis na mucosa respiratória com uma desidratação generalizada intensa, podendo levar à morte dos pequenos gatinhos.\n" +
                        " Os gatos infectados já na idade adulta tornam-se portadores crônicos deste vírus.");
            }
            else if(opcaoescolhida.equals("op12")){
                getSupportActionBar().setTitle("Doenças comuns em gatos");
                titulo.setText("Panleucopénia\n");
                texto.setText("É uma doença viral provocada por um parvovírus que origina uma leucopenia (diminuição do número de glóbulos brancos), bem como uma diarreia aguda.\n" +
                        " Pode levar à morte dos pequenos gatinhos e, na fêmea gestante pode provocar malformações irreversíveis nos fetos.");
            }else if(opcaoescolhida.equals("op13")){
                getSupportActionBar().setTitle("Doenças comuns em gatos");
                titulo.setText("Leucose\n");
                texto.setText("É uma das principais causas de morte no gato. Esta doença, provocada por um retrovírus, pode estar relacionada com uma situação de anemia, aparecimento de tumores ou leucemia.\n" +
                        " Um despiste sanguíneo prévio à vacinação é aconselhado para uma avaliação do estado do animal.");
            }else if(opcaoescolhida.equals("op14")){
                getSupportActionBar().setTitle("Doenças comuns em gatos");
                titulo.setText("Raiva\n");
                texto.setText("Ela é causada por um vírus da família Rhabdoviridae do Gênero Lyssavirus, por isso se trata de uma doença infecto-contagiosa. Este vírus tem a capacidade de atingir todas as espécies de mamíferos. A patogenia (o que faz) do vírus é atacar o sistema central nervoso. Este é o sistema de que fazem parte cérebro, medula e controle de sentidos como visão, olfato, audição, paladar. \n" +
                        "Quando ele entra no organismo, multiplica-se atingindo rapidamente o sistema nervoso, alcançando depois outros órgãos e glândulas salivares, onde se replica.\n" +
                        "O vírus, quando presente no gato, fica concentrado em maior parte na saliva, então a principal forma de transmissão da doença é a mordida. Neste caso, o gato infectado morde outros gatos ou mamíferos como o ser humano e passa a doença. As feridas e lambida de mucosas são outras formas de passar raiva pelo agente transmissor.\n");
            }else if(opcaoescolhida.equals("op15")){
                getSupportActionBar().setTitle("Doenças comuns em gatos");
                titulo.setText("Clamidiose\n");
                texto.setText("Causada por uma bactéria batizada de Clamidia Psittaci, a Clamidiose Felina é uma infecção que afeta o trato respiratório e ocular dos gatos, provocando sintomas como os da conjuntivite e da rinite no animal.\n" +
                        " Mais comum em locais onde há muitos bichanos aglomerados, a doença é bastante contagiosa, e o contato direto de um gato saudável com um animal contaminado (ou com as secreções liberadas por este animal doente) é a sua principal forma de transmissão.\n" +
                        "Gatas prenhas que tenham a doença também podem passar a sua bactéria de origem para as crias, e locais pouco ventilados e sem higiene também favorecem a transmissão da Clamidiose, sendo que boa parte dos gatos infectados uma vez pela doença acabam sofrendo com a ocorrência de maneira reincidente");
            }else if(opcaoescolhida.equals("op16")){
                getSupportActionBar().setTitle("Doenças comuns em gatos");
                titulo.setText("Toxoplasmose\n");
                texto.setText("É uma doença parasitária na qual o gato pode actuar como um dos hospedeiros do parasita. Os últimos estudos científicos demonstram que, respeitando as seguintes regras, o risco de transmissão do gato ao homem é nulo:\n" +
                        "Não alimentar o seu gato com carne crua ou mal cozinhada;\n" +
                        "Eliminar, diariamente, as matérias fecais do caixote de areia/W.C.;\n" +
                        "Jardinar sempre com luvas calçadas;\n" +
                        "Ferver a água não potável sempre antes da sua utilização;\n" +
                        "Desparasitar regularmente o seu animal.\n");
            }

            //Doenças comuns em cães


            //alimentação
            else if(opcaoescolhida.equals("op27")){
                getSupportActionBar().setTitle("Alimento adequado");
                texto.setText("Raça, tamanho, peso, idade, necessidades especiais, tudo isso deve ser levado em consideração antes de escolher o alimento correto para o animal.\n" +
                        "Os nutrientes que o animal necessita e a quantidade mudam de acordo com a idade. Bem como obesidade, alergias e outros problemas de saúde que podem criar  necessidade de uma ração com ingredientes especiais.\n" +
                        "Leia atentamente a informação nutricional no  rótulo das rações, e escolha a que melhor se adapte às necessidades do seu pet\n");
            } else if(opcaoescolhida.equals("op28")){
                getSupportActionBar().setTitle("Quantidade");
                texto.setText("É comum os pets comerem o que você servir, seja muito ou pouco. Por isso, você é o responsável por determinar essa quantidade visando a nutrição ideal para ele, sem ganho de peso excessivo.\n" +
                        "Sirva a quantidade adequada, assim você evita que o pet se acostume mal e que fique obeso, adquirindo todos os problemas vindos dessa condição\n" +
                        "Divida a quantidade recomendada para o seu pet em mais de uma refeição diária. O ideal são duas ou mesmo três refeições por dia, com a quantidade diária indicada na embalagem da ração, mas dividida em porções.\n"
                        +
                        "Dessa forma ele aproveita muito mais os nutrientes e não passa fome entre os intervalos da alimentação\n");
            }

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            default:break;
        }
        return true;
    }
}
