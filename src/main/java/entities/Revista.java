package entities;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "revista")
@Entity
public class Revista {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private UUID id;

    @Column
    private  String titulo;

    @Column
    private String org;

    @Column
    private int vol;

    @Column
    private int nro;

    @Column
    private int ano;

    public Revista(String titulo, String org, int vol, int nro, int ano){
        this.setTitulo(titulo);
        this.setOrg(org);
        this.setVol(vol);
        this.setNro(nro);
        this.setAno(ano);
    }

    public UUID getId() {
        return id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Revista get(){
        return this;
    }
}