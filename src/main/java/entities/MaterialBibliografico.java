package entities;

import repositories.LivroRepository;
import repositories.RevistaRepository;

import java.util.*;

public class MaterialBibliografico {

    final RevistaRepository revistaRepository;

    final LivroRepository livroRepository;

    public MaterialBibliografico(LivroRepository livroRepository,RevistaRepository revistaRepository){
        this.revistaRepository = revistaRepository;
        this.livroRepository = livroRepository;
    }

    public List<Livro> getLivros(){
        return livroRepository.findAll();
    }

    public List<Revista> getRevistas(){
        return revistaRepository.findAll();
    }

    public void addRevista(String titulo,String org, int vol, int nro, int ano){
        Revista newRevista = new Revista(titulo,org,vol,nro,ano);
        revistaRepository.save(newRevista);
    }

    public void addLivro(String titulo,String autor, int ano){
        Livro newLivro = new Livro(titulo,autor,ano);
        livroRepository.save(newLivro);
    }
}