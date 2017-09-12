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
            } else if(opcaoescolhida.equals("op12")){
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
            else if(opcaoescolhida.equals("op17")){
                getSupportActionBar().setTitle("Doenças comuns em cães");
                titulo.setText("Leishmaniose\n");
                texto.setText("A leishmaniose canina, também conhecida como calazar, é uma doença causada por um parasita do género Leishmania, transmitido aos cães através da picada de mosquitos. Este parasita infiltra-se na medula óssea e em órgãos como o baço, o fígado e a pele.\n" +
                        "Após o cão ser infetado, o período de incubação pode variar de apenas um mês até dois anos. Os primeiros sintomas verificam-se na pele, através da perda de pelo, descamação da pele e aparecimento de úlceras.\n" +
                        "À medida que a doença evolui, o cão pode sofrer de emagrecimento, vómitos, perda de apetite, atrofia muscular, anemia, hemorragias nasais e alterações nos órgãos internos, em particular no fígado e nos rins.");
            } else if(opcaoescolhida.equals("op18")){
                getSupportActionBar().setTitle("Doenças comuns em cães");
                titulo.setText("Cinomose\n");
                texto.setText("Também conhecida como esgana ou doença de Carré, é uma doença provocada pelo vírus CDV (Canine Distemper Vírus) e uma das mais graves doenças infeciosas que podem afetar os cães — apenas a raiva possui uma taxa de mortalidade superior.\n"+"O vírus da cinomose é capaz de afetar todo o organismo do animal, em especial os pulmões, o trato intestinal e o sistema nervoso. Os primeiros sintomas costumam ser respiratórios, com o aparecimento de secreções nasais purulentas, dificuldade em respirar e até pneumonias. Nos olhos, também aparecem secreções purulentas, as conhecidas remelas, em quantidade excessiva.");
            } else if(opcaoescolhida.equals("op19")){
                getSupportActionBar().setTitle("Doenças comuns em cães");
                titulo.setText("Sarna\n");
                texto.setText("A sarna é uma doença provocada por ácaros nocivos, que danificam de diferentes formas a pele dos cães.\n" +
                        "Existem três tipos de sarna, cada um provocado por um determinado tipo de ácaros, cada um deles com as suas características e diferentes formas de atacar os animais.\n" +
                        "É muito importante que não se aplique medicação por iniciativa própria, uma vez que cada tipo de sarna tem o seu modo de atuação e o seu respetivo tratamento. Deve ser sempre o veterinário a fazer o diagnóstico e então recomendar o tratamento mais adequado.");
            } else if(opcaoescolhida.equals("op20")){
                getSupportActionBar().setTitle("Doenças comuns em cães");
                titulo.setText("Leptospirose\n");
                texto.setText("A leptospirose é uma doença provocada por bactérias do género Leptospira, que afeta diversos mamíferos incluindo seres humanos.\n" +
                        "A bactéria desenvolve-se nos rins do animal infetado. Quando este urina, a bactéria é libertada viva para o ambiente, onde consegue sobreviver por vários meses caso encontre as condições ideais: épocas chuvosas e águas paradas. A chuva arrasta a urina até fontes de águas paradas, que ficam assim infetadas.\n" +
                        "Um cão pode apanhar leptospirose apenas por cheirar a urina de um animal infetado, aumentando as hipóteses de contaminação se beber ou brincar em água contaminada. A bactéria também consegue entrar no organismo através de feridas abertas, ou através da simples mordida num alimento que tenha estado em contacto com a bactéria.");
            } else if(opcaoescolhida.equals("op21")){
                getSupportActionBar().setTitle("Doenças comuns em cães");
                titulo.setText("Giardia\n");
                texto.setText("A giardíase é uma doença causada por parasitas do género Giardia, que invadem o sistema digestivo do animal e se alimentam dos nutrientes que este ingere. A giardíase também afeta gatos e seres humanos.\n" +
                        "A transmissão deste parasita é feita através de cistos, que chegam ao meio ambiente através das fezes de outros animais previamente infetados. Mesmo após a remoção das fezes, os cistos são capazes de sobreviver durante meses.\n" +
                        "Para o cão ser infetado, basta pisar os cistos na rua e posteriormente ingeri-los ao lamber as patas. A ingestão de água ou alimentos contaminados também dá origem à infeção. Uma vez dentro do organismo, os cistos desenvolvem-se nos parasitas adultos.\n" +
                        "Como a Giardia absorve os nutrientes da alimentação do animal, o cão começa a perder peso e a desidratar, aos quais são associados sintomas como as dores abdominais, a diarreia e os vómitos, que ainda enfraquecem mais o animal.");
            } else if(opcaoescolhida.equals("op22")){
                getSupportActionBar().setTitle("Doenças comuns em cães");
                titulo.setText("Parvovirose\n");
                texto.setText("A parvovirose é uma doença provocada por um vírus da família Parvoviridae, de atuação muito rápida e aguda especialmente perigosa para os cães mais jovens. É uma doença conhecida há relativamente pouco tempo, com os primeiros casos a terem sido reportados na Austrália em 1978.\n" +
                        "Geralmente os cães contraem esta doença através do solo contaminado. Como o vírus se desenvolve no trato intestinal dos cães infetados, é libertado em grandes quantidades nas fezes, que por sua vez vão para os solos. Trata-se de um vírus muito resistente, capaz de sobreviver durante meses no solo até infetar o próximo animal.\n" +
                        "Cerca de 4 a 14 dias após a infeção, o animal começa a ter febre e a perder o apetite. Um ou dois dias depois, chegam os vómitos e a diarreia, que contém progressivamente mais sangue de cada vez que o animal defeca. Os sintomas progridem muito rapidamente e a taxa de mortalidade é elevada.");
            } else if(opcaoescolhida.equals("op23")){
                getSupportActionBar().setTitle("Doenças comuns em cães");
                titulo.setText("Raiva\n");
                texto.setText("A raiva é uma das doenças mais conhecidas e temidas pelas pessoas, que atinge não apenas os cães como todos os mamíferos, particularmente raposas, furões, coiotes, guaxinins, morcegos, doninhas e seres humanos.\n" +
                        "Apesar de ser uma doença erradicada em vários países, é incurável e tem um prognóstico muito grave, que na esmagadora maioria dos casos se revela fatal. Aliás, é a doença com a mais elevada taxa de mortalidade nos cães.\n" +
                        "A raiva é uma doença provocada por um vírus da família Rhabdoviridae, que atinge o sistema nervoso. O principal método de transmissão é através da saliva, pelo que um animal pode ser infetado através de uma mordedura, arranhão ou lambidela.\n" +
                        "Afetando o sistema nervoso, a raiva provoca uma alteração profunda no comportamento do animal. Os cães ficam extremamente agitados, com espasmos intensos nos músculos, não respondem aos donos e procuram locais escuros e escondidos para ficar.\n" +
                        "Em poucos dias, evolui para um quadro de agressividade, com muita salivação, o animal deixa de comer e de beber, até chegar a um estado paralisia que leva o animal à morte.");
            } else if(opcaoescolhida.equals("op24")){
                getSupportActionBar().setTitle("Doenças comuns em cães");
                titulo.setText("Coronavirose\n");
                texto.setText("Tal como o nome indica, trata-se de uma doença provocada por um vírus do género Coronavirus. Este vírus, altamente contagioso, desenvolve-se no interior do intestino dos cães e transmite-se assim através de fezes infetadas. É também conhecida como Gastroenterite Contagiosa dos Cães.\n" +
                        "A infeção provocada por Coronavirus não é considerada grave, e geralmente provoca apenas vómitos e diarreia durante alguns dias até ao animal recuperar, sem necessidade de tomar medicação.\n" +
                        "No entanto, animais com sistema imunitário mais frágil (como bebés) estão em maior risco de desenvolver complicações graves, como inflamação no intestino, diarreia prolongada e desidratação.\n" +
                        "O facto de a coronavirose poder passar sem tratamento específico não implica que se deva deixar de ir ao veterinário quando os sintomas aparecem — até porque os sintomas são semelhantes ao da parvovirose, que é mais grave. Pode-se pensar que é uma coisa, e é outra. Tem de ser o veterinário a diagnosticar, atempadamente, para evitar complicações maiores.");
            } else if(opcaoescolhida.equals("op25")){
                getSupportActionBar().setTitle("Doenças comuns em cães");
                titulo.setText("Dermatofitose\n");
                texto.setText("A dermatofitose é uma doença de pele provocada por fungos. Geralmente não é considerada uma doença grave em cães saudáveis, com o sistema imunitário normal, uma vez que este é capaz de combater os fungos.\n" +
                        "Em cães com sistema imunitário mais frágil, como os mais novos, mais velhos ou que tenham outra doença a interferir, é necessário ter outro tipo de cuidados, pois pode chegar a evoluir para um quadro clínico grave e mesmo crónico.\n" +
                        "A transmissão da dermatofitose dá-se através do contacto direto com o pelo de outros animais infetados. O fungo infeta diversos mamíferos, incluindo gatos e nós próprios.\n" +
                        "A dermatofitose é facilmente identificada no corpo do animal, pois provoca lesões redondas com peladas, com maior incidência na face e nas patas dianteiras. Em casos mais graves, o cão coça-se muito e fica com dores nos locais afetados.");
            } else if(opcaoescolhida.equals("op26")){
                getSupportActionBar().setTitle("Doenças comuns em cães");
                titulo.setText("Tosse dos canis\n");
                texto.setText("A tosse dos canis, mais corretamente chamada de traqueobronquite infecciosa canina, é uma doença respiratória relativamente comum nos cães.\n" +
                        "Na sua base não está apenas um microrganismo, mas vários, em particular os vírus Parainfluenza canina, Influenza canina e Adenovírus canino tipo 2, bem como a bactéria Bordetella bronchiseptica, esta última capaz de infetar também seres humanos.\n" +
                        "Sendo uma doença transmitida por contacto direto, tem uma grande capacidade de propagação em sítios onde são mantidos muitos animais juntos, como associações e canis (daí a origem do nome).\n" +
                        "Os animais infetados sofrem de tosse seca constante e espirros, que por vezes são desencadeados em sessões que parecem intermináveis. Em casos mais graves, podem surgir sintomas como febre, perda de apetite, secreções nos olhos ou tosse com catarro.\n" +
                        "A doença pode chegar a evoluir para uma pneumonia. Cães mais jovens e mais idosos são os que correm maior risco.");
            }

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
