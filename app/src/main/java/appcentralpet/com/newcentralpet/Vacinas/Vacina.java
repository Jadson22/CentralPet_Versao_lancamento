package appcentralpet.com.newcentralpet.Vacinas;

/**
 * Created by Jadson on 15/09/2017.
 */
public class Vacina {

    private int id;
    private String nomePet;
    private String nomeVacina;
    private String pData;
    private String sData;

    public Vacina(int id, String nomePet, String nomeVacina, String pData, String sData) {
        this.id = id;
        this.nomePet = nomePet;
        this.nomeVacina = nomeVacina;
        this.pData = pData;
        this.sData = sData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public String getpData() {
        return pData;
    }

    public void setpData(String pData) {
        this.pData = pData;
    }

    public String getsData() {
        return sData;
    }

    public void setsData(String sData) {
        this.sData = sData;
    }
}
