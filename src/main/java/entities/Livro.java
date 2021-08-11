package entities;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "livro")
@Entity
public class Livro {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private UUID id;

    private String titulo;

    private String autor;

    private int ano;

    public Livro(String titulo, String autor, int ano){
        this.setTitulo(titulo);
        this.setAutor(autor);
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Livro get(){
        return this;
    }

}