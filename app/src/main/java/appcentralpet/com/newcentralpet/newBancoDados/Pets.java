package appcentralpet.com.newcentralpet.newBancoDados;

import java.io.Serializable;

import appcentralpet.com.newcentralpet.BancoMeusPets.Pet;

/**
 * Created by Jadson on 13/09/2017.
 */
public class Pets implements Serializable{

    private long id;
    private String name;
    private String raca;
    private String idade;
    private String sexo;
    private String tipo;
    private byte[] image;

    public Pets(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString(){
        return name;
    }
}
